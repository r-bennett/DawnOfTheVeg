package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;

public class StoryScreen extends GLScreen {
	private int frame;
	Camera2D guiCam;
	SpriteBatcher batcher;
	Vector2 touchPoint;

	public StoryScreen(Game game, int frame) {
		super(game);
		this.frame = frame;
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void present(float deltaTime) {
		batcher.beginBatch(Assets.story[frame]);
		batcher.drawSprite(0, 0, 800, 480, Assets.storyRegion[frame]);
		batcher.endBatch();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
