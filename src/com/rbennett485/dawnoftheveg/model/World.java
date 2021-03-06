package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.data.Progress;
import com.rbennett485.dawnoftheveg.variables.Objectives;

/**
 * The omniscient model class, responsible for maintaining and updating all
 * model objects
 * 
 * @author Bennett_Richard
 * 
 */
public class World {

	public interface WorldListener {
		/**
		 * Plays a random splat sound (for when an enemy dies)
		 */
		public void splat();
	}

	public static final float WORLD_WIDTH = 20;
	public static final float WORLD_HEIGHT = 12;
	public static final int WORLD_STATE_RUNNING = 0; // waves are coming, the
	// game is in play
	public static final int WORLD_STATE_COMPLETE = 1; // no more enemies and no
	// more waves
	public static final int WORLD_STATE_GAME_OVER = 2; // no more lives
	public static final int WORLD_STATE_INITIAL_BUILD = 3; // the initial state
	// - the timer is
	// not running, no
	// waves appear. Allows player to build initial towers
	// note - no pause state needed since GameScreen handles this, and does not
	// update World when paused
	public static final int VALUE_OF_KILL = 30;

	private final Runnable waveCreator;

	public final List<Vector2> wayPoints;
	public final List<Wave> waves;
	public final List<Vector2> towerPatches;

	public List<Enemy> enemies;
	public List<Tower> towers;
	public List<Projectile> projectiles;
	public List<Splat> splats;

	private final WorldListener listener;
	private final Random rand;

	public int money;
	public int state;
	public int nextWave;
	public int lives;
	public float timeElapsed;
	public boolean updating;
	public Vector2 patchMenuCentre;
	public Level level;

	private List<GameObject> removals; // used for storing all objects to be

	// removed during an iteration of a
	// collection

	/**
	 * Constructor
	 * 
	 * @param listener
	 *            The listener responsible for playing the sounds
	 * @param level
	 *            The object containing the level information
	 */
	public World(WorldListener listener, Level level) {
		this.enemies = new ArrayList<>();
		this.towers = new ArrayList<>();
		this.splats = new ArrayList<>();
		this.projectiles = new ArrayList<>();
		this.state = WORLD_STATE_INITIAL_BUILD;
		timeElapsed = 0;
		nextWave = 0;
		lives = level.lives;
		rand = new Random();
		updating = false;
		removals = new ArrayList<>();
		this.level = level;

		waveCreator = new Runnable() {
			public void run() {
				Wave wave = World.this.waves.get(nextWave);
				for (int i = 0; i < wave.number; i++) {
					synchronized (World.this) {
						enemies.add(wave.seed.clone());
					}
					try {
						Thread.sleep((long) (World.this.rand.nextFloat() * 2000));
					} catch (InterruptedException e) {
						// nothing to do here - just generates the next enemy a
						// little early
					}
				}
				updating = false;
				nextWave++;
			}
		};

		this.listener = listener;
		this.money = level.INITIAL_MONEY;
		this.wayPoints = level.wayPoints;
		this.waves = level.waves;
		this.towerPatches = level.towerPatches;
		patchMenuCentre = null;
	}

	/**
	 * Updates all aspects of the model
	 * 
	 * @param deltaTime
	 *            The time elapsed in seconds since the last update
	 */
	public void update(float deltaTime) {
		if (state != WORLD_STATE_INITIAL_BUILD)
			timeElapsed += deltaTime;

		switch (state) {
		case (WORLD_STATE_RUNNING):
			if (nextWave < waves.size()) {
				if (!updating)
					checkNewWave();
			} else if (enemies.isEmpty()) {
				state = WORLD_STATE_COMPLETE;
				if (Progress.NUMBER_OF_LEVELS > level.number) {
					Progress.level[level.number] = true;
				}
			}

			updateEnemies(deltaTime);
			updateTowers(deltaTime);
			updateProjectiles(deltaTime);
			checkCollisions();
			updateSplats(deltaTime);

			if (lives <= 0) {
				state = WORLD_STATE_GAME_OVER;
			}
			break;

		case (WORLD_STATE_COMPLETE):
			// display complete message and wait for user input..... should
			// probably delegate this task to GameScreen
			break;
		case (WORLD_STATE_GAME_OVER):
			// display gameover message and wait for user input..... should
			// probably delegate this task to GameScreen
			break;
		}

	}

	private void updateSplats(float deltaTime) {
		removals.clear();
		for (Splat s : splats) {
			s.update(deltaTime);
			if (s.stateTime > Splat.TIME_TO_LIVE)
				removals.add(s);
		}
		splats.removeAll(removals);
	}

	private synchronized void checkCollisions() {
		removals.clear();
		for (Projectile p : projectiles) {
			for (Enemy e : enemies) {
				if (OverlapTester.overlapRectangles(p.bounds, e.bounds)) {
					e.hit(p);
					removals.add(p);
					break;
				}
			}
		}
		projectiles.removeAll(removals);

	}

	private synchronized void updateProjectiles(float deltaTime) {
		removals.clear();
		for (Projectile p : projectiles) {
			p.update(deltaTime);
			if (p.stateTime > p.rangeTime)
				removals.add(p);
		}
		projectiles.removeAll(removals);
	}

	private void checkNewWave() {
		if (timeElapsed > waves.get(nextWave).time && !updating) {
			updating = true;
			new Thread(waveCreator).start();
		}
	}

	private synchronized void updateEnemies(float deltaTime) {
		removals.clear();
		for (Enemy e : enemies) {
			if (e.hp <= 0) {
				removals.add(e);
				splats.add(new Splat(e));
				Objectives.enemyKilled();
				money += VALUE_OF_KILL;
				listener.splat();
			}
		}
		enemies.removeAll(removals);

		removals.clear();
		int len = enemies.size();
		Vector2 finishLine = wayPoints.get(wayPoints.size() - 1);
		for (int i = 0; i < len; i++) {
			Enemy enemy = enemies.get(i);
			enemy.update(deltaTime);
			if (enemy.position.dist(finishLine) < 0.1 && enemy.inGame) {
				lives--;
				enemy.inGame = false;
			}
			if (enemy.position.x > WORLD_WIDTH + 1)
				removals.add(enemy);
		}
		enemies.removeAll(removals);
	}

	private synchronized void updateTowers(float deltaTime) {
		int len = towers.size();
		for (int i = 0; i < len; i++) {
			Tower tower = towers.get(i);
			tower.update(deltaTime);
			if (tower.idleTime >= tower.reloadTime) {
				float closest = Float.MAX_VALUE;
				Enemy closestEnemy = null;
				for (Enemy e : enemies) {
					float dist = e.position.dist(tower.position);
					if (dist < closest) {
						closestEnemy = e;
						closest = dist;
					}
				}

				if (closest <= tower.range) {
					tower.idleTime = 0;
					Vector2 projVel = closestEnemy.position.cpy()
							.sub(tower.position).nor()
							.mul(ProjectileA.PROJECTILE_A_SPEED);
					projectiles.add(tower.newProj(projVel));
				}
			}
		}
	}

	/**
	 * For determining if a tower is present at a given position (must match
	 * exactly)
	 * 
	 * @param pos
	 *            The position to test
	 * @return true if there is a tower there, false otherwise
	 */
	public boolean towerAt(Vector2 pos) {
		for (Tower t : towers) {
			if (t.position.x == pos.x && t.position.y == pos.y)
				return true;
		}
		return false;
	}

	/**
	 * Retrieves the tower at a given position
	 * 
	 * @param pos
	 *            The position to get the tower from
	 * @return The towerat that position, or null if no such tower
	 */
	public Tower getTowerAt(Vector2 pos) {
		for (Tower t : towers) {
			if (t.position.x == pos.x && t.position.y == pos.y)
				return t;
		}
		return null;
	}
}
