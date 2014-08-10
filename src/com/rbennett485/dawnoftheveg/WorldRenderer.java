package com.rbennett485.dawnoftheveg;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLGraphics;
import com.badlogic.androidgames.framework.math.Vector2;

public class WorldRenderer {
	static final float FRUSTUM_WIDTH = 20;
	static final float FRUSTUM_HEIGHT = 12;
	static final float HEALTH_BAR_GAP = 0.1f;
	static final float HEALTH_BAR_HEIGHT = 0.05f;
	GLGraphics glGraphics;
	World world;
	Camera2D cam;
	SpriteBatcher batcher;    

	public WorldRenderer(GLGraphics glGraphics, SpriteBatcher batcher, World world) {
		this.glGraphics = glGraphics;
		this.world = world;
		this.cam = new Camera2D(glGraphics, FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.batcher = batcher;        
	}

	public void render() {
		cam.setViewportAndMatrices();
		renderBackground();
		renderObjects();        
	}

	private void renderBackground() {
		batcher.beginBatch(Assets.background);
		batcher.drawSprite(cam.position.x, cam.position.y,
				FRUSTUM_WIDTH, FRUSTUM_HEIGHT, 
				Assets.backgroundRegion);
		batcher.endBatch();
	}

	private void renderObjects() {
		GL10 gl = glGraphics.getGL();
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		if(!world.enemies.isEmpty()) {
			batcher.beginBatch(Assets.towerImage);
			renderTowers();
			batcher.endBatch();
			
			batcher.beginBatch(Assets.characters);
			renderEnemies();
			batcher.endBatch();
			
			batcher.beginBatch(Assets.healthBars);
			renderHealthBars();
			batcher.endBatch();
		}
		
		batcher.beginBatch(Assets.fontImage);
		renderText();
		batcher.endBatch();
		
		gl.glDisable(GL10.GL_BLEND);
	}
	
	private void renderTowers() {
		int len = world.towerPatches.size();
		for(int i=0 ; i<len ; i++) {
			Vector2 patch = world.towerPatches.get(i);
			batcher.drawSprite(patch.x, patch.y, 1, 1, Assets.patch);
		}
	}

	private void renderEnemies() {
		int len = world.enemies.size();
		for(int i = 0; i < len; i++) {
			Orange orange = (Orange)world.enemies.get(i); // Will need to change this once more types of enemy are added
			batcher.drawSprite(orange.position.x, orange.position.y, 1, 1, Assets.orange); // and this
		}
	}
	
	private void renderHealthBars() {
		int len = world.enemies.size();
		for(int i = 0; i < len; i++) {
			Orange orange = (Orange)world.enemies.get(i); // Will need to change this once more types of enemy are added
			batcher.drawSprite(orange.position.x, orange.position.y + orange.bounds.height/2 + HEALTH_BAR_GAP, 
					1f, HEALTH_BAR_HEIGHT, Assets.healthBarRed);
			batcher.drawSprite(orange.position.x-0.5f*(orange.initialHp - orange.hp)/orange.initialHp, orange.position.y + orange.bounds.height/2 + HEALTH_BAR_GAP, 
					(float)orange.hp/orange.initialHp, HEALTH_BAR_HEIGHT, Assets.healthBarGreen);
		}
	}
	
	private void renderText() {
		 Assets.font.drawTextScaled(batcher, "$" + world.money, 0.5f, 0.5f, 20, 12);
		 Assets.font.drawTextScaled(batcher, "lives: " + world.lives, 20-3.5f, 0.5f, 20, 12);
	}
}
