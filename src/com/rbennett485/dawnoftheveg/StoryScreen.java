package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.Vector2;

public class StoryScreen extends GLScreen {
	private int frame;
	Camera2D guiCam;
	SpriteBatcher batcher;
	Vector2 touchPoint;

	public StoryScreen(Game game, int frame) {
		super(game);
		this.frame = frame;
		batcher = new SpriteBatcher(glGraphics, 20);
		touchPoint = new Vector2();
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				nextScreen();
				return;
			}
		}
	}

	private void nextScreen() {
		switch(frame) {
		case 0: case 1: case 9: case 10:
			frame++;
			break;
		case 2:
			game.setScreen(new GameScreen(game, new Level1()));
			break;
		case 3:
			game.setScreen(new GameScreen(game, new Level2()));
			break;
		case 4:
			game.setScreen(new GameScreen(game, new Level3()));
			break;
		case 5:
			game.setScreen(new GameScreen(game, new Level4()));
			break;
		case 6:
			game.setScreen(new GameScreen(game, new Level5()));
			break;
		case 7:
			game.setScreen(new GameScreen(game, new Level6()));
			break;
		case 8:
			game.setScreen(new GameScreen(game, new Level7()));
			break;
		case 11:
			game.setScreen(new GameScreen(game, new Level8()));
			break;
		}
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
