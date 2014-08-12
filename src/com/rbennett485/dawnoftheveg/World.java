package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.util.Log;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.math.Vector2;

public class World {

	public interface WorldListener {
		public void shot();
		public void splat();
	}

	public static final float WORLD_WIDTH = 20;
	public static final float WORLD_HEIGHT = 12;
	public static final int INITIAL_LIVES = 20;
	public static final int WORLD_STATE_RUNNING = 0;	// waves are coming, the game is in play
	public static final int WORLD_STATE_COMPLETE = 1;	// no more enemies and no more waves
	public static final int WORLD_STATE_GAME_OVER = 2;	// no more lives
	public static final int WORLD_STATE_INITIAL_BUILD = 3;	// the initial state - the timer is not running, no 
	// waves appear. Allows player to build initial towers
	// note - no pause state needed since GameScreen handles this, and does not update World when paused
	
	public final Runnable waveCreator;

	public final int INITIAL_MONEY;
	public final List<Vector2> wayPoints;
	public final List<Wave> waves;
	public final List<Vector2> towerPatches;

	public List<GameObject> enemies;
	public List<GameObject> towers;
	public List<Projectile> projectiles;

	public final WorldListener listener;
	public final Random rand;

	public int money;
	public int state;
	public int nextWave;
	public int lives;
	public float timeElapsed;
	public boolean updating;
	public Vector2 patchMenuCentre;

	public World(WorldListener listener, Level level) {
		this.enemies = new ArrayList<GameObject>();
		this.towers = new ArrayList<GameObject>();
		this.state = WORLD_STATE_INITIAL_BUILD;
		timeElapsed = 0;
		nextWave = 0;
		lives = INITIAL_LIVES;
		rand = new Random();
		updating = false;
		
		waveCreator = new Runnable() {
			public void run() {
				Wave wave = World.this.waves.get(nextWave);
				for(int i=0 ; i<wave.number ; i++) {
					enemies.add(wave.seed.clone());
					try {
						Thread.sleep((long) (World.this.rand.nextFloat()*2000));
					} catch (InterruptedException e) {
						// nothing to do here - just generates the next enemy a little early
					}
				}
				updating = false;
				nextWave++;
			}
		};

		this.listener = listener;
		this.INITIAL_MONEY = level.INITIAL_MONEY;
		this.money = INITIAL_MONEY;
		this.wayPoints = level.wayPoints;
		this.waves = level.waves;
		this.towerPatches = level.towerPatches;
		patchMenuCentre = null;
	}

	public void update(float deltaTime) {
		if(state!=WORLD_STATE_INITIAL_BUILD)
			timeElapsed+=deltaTime;
		
		switch(state) {
		case(WORLD_STATE_RUNNING):
			if(nextWave<waves.size()){
				checkNewWave();
			}
			else if(enemies.isEmpty()) {
				Log.d("complete", "no more enemies");
				state = WORLD_STATE_COMPLETE;
			}
				
			updateTowers(deltaTime);
			updateEnemies(deltaTime);
			
			if(lives<=0) {
				Log.d("complete", "no more lives: " + lives);
				state = WORLD_STATE_GAME_OVER;
			}
			break;
			
		case(WORLD_STATE_COMPLETE):
			// display complete message and wait for user input..... should probably delegate this task to GameScreen
			break;
		case(WORLD_STATE_GAME_OVER):
			// display gameover message and wait for user input..... should probably delegate this task to GameScreen
			break;
		}
		
	}

	private void checkNewWave() {
		if(timeElapsed>waves.get(nextWave).time && !updating) {
			Log.d("complete", "new wave");
			updating = true;
			new Thread(waveCreator).start();
		}
	}

	private void updateEnemies(float deltaTime) { // add code to check if enemy has crossed the finish line, and deduct 1 life
		int len = enemies.size();
		Vector2 finishLine = wayPoints.get(wayPoints.size()-1);
		for (int i = 0; i < len; i++) {
			GameObject enemy = enemies.get(i);  
			enemy.update(deltaTime);
			if(enemy.position.dist(finishLine)<0.1 && enemy.inGame) {
				lives--;
				Log.d("complete", "lives: " + lives);
				enemy.inGame = false;
			}
		}		
	}

	private void updateTowers(float deltaTime) {
		int len = towers.size();
		for(int i=0 ; i<len ; i++) {
			towers.get(i).update(deltaTime);
		}
	} 
}
