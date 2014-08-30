package com.rbennett485.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.rbennett485.dawnoftheveg.model.Level1;
import com.rbennett485.dawnoftheveg.model.Level2;
import com.rbennett485.dawnoftheveg.model.Level3;
import com.rbennett485.dawnoftheveg.model.Level4;
import com.rbennett485.dawnoftheveg.model.Level5;
import com.rbennett485.dawnoftheveg.model.Level6;
import com.rbennett485.dawnoftheveg.model.Level7;
import com.rbennett485.dawnoftheveg.model.Level8;

/**
 * Displays and manages transitions between storyboards, displayed before each
 * level
 * 
 * @author Bennett_Richard
 * 
 */
public class StoryScreen extends GLScreen {
	private int frame;
	private Camera2D guiCam;
	private SpriteBatcher batcher;

	/**
	 * Constructor
	 * 
	 * @param game
	 *            The game to which the screen belongs
	 * @param frame
	 *            The number of the first frame to display
	 */
	public StoryScreen(Game game, int frame) {
		super(game);
		this.frame = frame;
		batcher = new SpriteBatcher(glGraphics, 20);
		guiCam = new Camera2D(glGraphics, 800, 480);
	}

	/**
	 * If the user touches the screen it either advances to the next frame, or
	 * transitions to the relevant {@link GameScreen}
	 */
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				nextScreen();
				return;
			}
		}
	}

	private void nextScreen() {
		switch (frame) {
		case 0:
		case 1:
		case 9:
		case 10:
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

	/**
	 * Renders the screen
	 */
	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.setViewportAndMatrices();

		gl.glEnable(GL10.GL_TEXTURE_2D);
		batcher.beginBatch(Assets.story[frame]);
		batcher.drawSprite(400, 240, 800, 480, Assets.storyRegion[frame]);
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
