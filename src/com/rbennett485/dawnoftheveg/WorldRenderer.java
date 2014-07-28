package com.rbennett485.dawnoftheveg;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLGraphics;

public class WorldRenderer {
	static final float FRUSTUM_WIDTH = 20;
	static final float FRUSTUM_HEIGHT = 12;    
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

	public void renderBackground() {
		batcher.beginBatch(Assets.background);
		batcher.drawSprite(cam.position.x, cam.position.y,
				FRUSTUM_WIDTH, FRUSTUM_HEIGHT, 
				Assets.backgroundRegion);
		batcher.endBatch();
	}

	public void renderObjects() {
		GL10 gl = glGraphics.getGL();
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.characters);
		renderEnemies();
		Log.d("renderer", "rendered enemies");
		batcher.endBatch();
		gl.glDisable(GL10.GL_BLEND);
	}

	private void renderEnemies() {
		int len = world.enemies.size();
		for(int i = 0; i < len; i++) {
			Orange orange = (Orange)world.enemies.get(i); // Will need to change this once more types of enemy are added
			Log.d("coords", orange.position.x + ", " + orange.position.y);
			batcher.drawSprite(orange.position.x, orange.position.y, 1, 1, Assets.orange); // and this
		}
	}
}