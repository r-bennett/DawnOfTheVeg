package com.rbennett485.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.variables.Objectives;

/**
 * The screen instance for help. Manages the presentation of the various help
 * images
 * 
 * @author Bennett_Richard
 * 
 */
public class HelpScreen extends GLScreen {
	private Camera2D guiCam;
	private SpriteBatcher batcher;
	private Rectangle nextBounds;
	private Rectangle previousBounds; // for previous help screen
	private Rectangle backBounds; // for returning to title screen
	private Vector2 touchPoint;
	private int currentRegion;

	/**
	 * Constructor
	 * 
	 * @param game
	 *            The game to which the screen belongs
	 */
	public HelpScreen(Game game) {
		super(game);

		guiCam = new Camera2D(glGraphics, 800, 480);
		nextBounds = new Rectangle(710, 140, 60, 200);
		previousBounds = new Rectangle(30, 140, 60, 200);
		backBounds = new Rectangle(720, 400, 80, 80);
		touchPoint = new Vector2();
		batcher = new SpriteBatcher(glGraphics, 100);
		currentRegion = 0;
		Objectives.helpPageVisited(0);
	}

	/**
	 * Checks for UI interaction, and updates the help image accordingly
	 * 
	 * @param deltaTime
	 *            unused
	 */
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);

			if (event.type == TouchEvent.TOUCH_UP) {
				if (OverlapTester.pointInRectangle(nextBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					currentRegion = (((currentRegion + 1) % Assets.NUMBER_OF_HELP_REGIONS) + Assets.NUMBER_OF_HELP_REGIONS)
							% Assets.NUMBER_OF_HELP_REGIONS;
					Objectives.helpPageVisited(currentRegion);
					return;
				}

				if (OverlapTester.pointInRectangle(previousBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					currentRegion = (((currentRegion - 1) % Assets.NUMBER_OF_HELP_REGIONS) + Assets.NUMBER_OF_HELP_REGIONS)
							% Assets.NUMBER_OF_HELP_REGIONS;
					Objectives.helpPageVisited(currentRegion);
					return;
				}

				if (OverlapTester.pointInRectangle(backBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new TitleScreen(game));
					return;
				}
			}
		}

	}

	/**
	 * renders the screen
	 * 
	 * @param deltaTime
	 *            unused
	 */
	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.setViewportAndMatrices();

		gl.glEnable(GL10.GL_TEXTURE_2D);

		batcher.beginBatch(Assets.helpImage);
		batcher.drawSprite(400, 240, 380, 380, Assets.helpRegion[currentRegion]);
		batcher.endBatch();

		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.sprites);
		batcher.drawSprite(740, 240, 40, 40, Assets.rightArrow);
		batcher.drawSprite(60, 240, -40, 40, Assets.rightArrow); // use -ve
																	// width for
																	// left
																	// arrow
		batcher.drawSprite(760, 440, 80, 80, Assets.back);
		batcher.endBatch();

		gl.glDisable(GL10.GL_BLEND);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
