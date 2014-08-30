package com.rbennett485.dawnoftheveg;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGraphics;
import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.model.Enemy;
import com.rbennett485.dawnoftheveg.model.Projectile;
import com.rbennett485.dawnoftheveg.model.ProjectileA;
import com.rbennett485.dawnoftheveg.model.ProjectileB;
import com.rbennett485.dawnoftheveg.model.ProjectileC;
import com.rbennett485.dawnoftheveg.model.Splat;
import com.rbennett485.dawnoftheveg.model.Tower;
import com.rbennett485.dawnoftheveg.model.TowerA;
import com.rbennett485.dawnoftheveg.model.TowerB;
import com.rbennett485.dawnoftheveg.model.TowerC;
import com.rbennett485.dawnoftheveg.model.World;

/**
 * Responsible for rendering a given model on screen
 * 
 * @author Bennett_Richard
 * 
 */
public class WorldRenderer {
	private static final float FRUSTUM_WIDTH = 20;
	private static final float FRUSTUM_HEIGHT = 12;
	private static final float HEALTH_BAR_GAP = 0.1f;
	private static final float HEALTH_BAR_HEIGHT = 0.05f;
	private GLGraphics glGraphics;
	private World world;
	private Camera2D cam;
	private SpriteBatcher batcher;

	/**
	 * Constructor
	 * 
	 * @param glGraphics
	 *            The {@link GLGraphics} instance to use
	 * @param batcher
	 *            The {@link SpriteBatcher} that will be used to render each
	 *            texture region
	 * @param world
	 *            The model that will be rendered
	 */
	public WorldRenderer(GLGraphics glGraphics, SpriteBatcher batcher,
			World world) {
		this.glGraphics = glGraphics;
		this.world = world;
		this.cam = new Camera2D(glGraphics, FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.batcher = batcher;
	}

	/**
	 * Renders the model stored in world member
	 */
	public void render() {
		cam.setViewportAndMatrices();
		renderBackground();
		renderObjects();
	}

	private void renderBackground() {
		batcher.beginBatch(world.level.background);
		batcher.drawSprite(cam.position.x, cam.position.y, FRUSTUM_WIDTH,
				FRUSTUM_HEIGHT, world.level.backgroundRegion);
		batcher.endBatch();
	}

	private void renderObjects() {
		GL10 gl = glGraphics.getGL();
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.sprites);
		renderTowers();
		renderSplats();
		renderProjectiles();

		if (!world.enemies.isEmpty()) {
			renderEnemies();

			renderHealthBars();
		}

		renderText();
		batcher.endBatch();

		gl.glDisable(GL10.GL_BLEND);
	}

	private void renderSplats() {
		for (Splat s : world.splats) {
			batcher.drawSprite(s.position.x, s.position.y, s.bounds.width,
					s.bounds.height, s.region);
		}

	}

	private void renderTowers() {
		int len = world.towerPatches.size();
		outerloop: for (int i = 0; i < len; i++) {
			Vector2 patch = world.towerPatches.get(i);
			for (Tower t : world.towers) {
				if (patch.x == t.position.x && patch.y == t.position.y)
					continue outerloop; // don't render patch - there is a tower
										// there
			}
			batcher.drawSprite(patch.x, patch.y, 1, 1, Assets.patch);
		}

		len = world.towers.size();
		GameObject tower;
		TextureRegion region;
		for (int i = 0; i < len; i++) {
			tower = world.towers.get(i);
			if (tower instanceof TowerA)
				region = Assets.towerA;
			else if (tower instanceof TowerB)
				region = Assets.towerB;
			else if (tower instanceof TowerC)
				region = Assets.towerC;
			else
				region = Assets.towerD;
			batcher.drawSprite(tower.position.x, tower.position.y,
					tower.bounds.width, tower.bounds.height, region);
		}
	}

	private void renderProjectiles() {
		int len = world.projectiles.size();
		TextureRegion region;
		for (int i = 0; i < len; i++) {
			Projectile proj = world.projectiles.get(i);
			if (proj instanceof ProjectileA)
				region = Assets.projectileA;
			else if (proj instanceof ProjectileB)
				region = Assets.projectileB;
			else if (proj instanceof ProjectileC)
				region = Assets.projectileC;
			else
				region = Assets.projectileD;
			batcher.drawSprite(proj.position.x, proj.position.y,
					proj.bounds.width, proj.bounds.height,
					proj.velocity.angle(), region);
		}
	}

	private void renderEnemies() {
		int len = world.enemies.size();
		Enemy enemy;
		for (int i = len - 1; i >= 0; i--) {
			enemy = world.enemies.get(i);
			batcher.drawSprite(enemy.position.x, enemy.position.y,
					enemy.bounds.width, enemy.bounds.height, enemy.region);
		}
	}

	private void renderHealthBars() {
		int len = world.enemies.size();
		for (int i = 0; i < len; i++) {
			Enemy enemy = world.enemies.get(i); // Will need to change this once
												// more types of enemy are added
			batcher.drawSprite(enemy.position.x, enemy.position.y
					+ enemy.bounds.height / 2 + HEALTH_BAR_GAP, 1f,
					HEALTH_BAR_HEIGHT, Assets.healthBarRed);
			batcher.drawSprite(
					enemy.position.x - 0.5f * (enemy.initialHp - enemy.hp)
							/ enemy.initialHp,
					enemy.position.y + enemy.bounds.height / 2 + HEALTH_BAR_GAP,
					(float) enemy.hp / enemy.initialHp, HEALTH_BAR_HEIGHT,
					Assets.healthBarGreen);
		}
	}

	private void renderText() {
		Assets.font.drawTextScaled(batcher, "$" + world.money, 0.5f, 0.5f, 20,
				12);
		Assets.font.drawTextScaled(batcher, "lives: " + world.lives, 20 - 3.5f,
				0.5f, 20, 12);
	}
}
