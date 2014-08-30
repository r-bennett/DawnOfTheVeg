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
import com.rbennett485.dawnoftheveg.data.Settings;

/**
 * The initial screen which is assigned to {@link DawnOfTheVeg} on launch
 * 
 * @author Bennett_Richard
 * 
 */
public class TitleScreen extends GLScreen {
	private Camera2D guiCam;
	private SpriteBatcher batcher;
	private Rectangle soundBounds;
	private Rectangle helpBounds;
	private Rectangle playBounds;
	private Rectangle shopBounds;
	private Rectangle objectivesBounds;
	private Vector2 touchPoint;

	/**
	 * Constructor
	 * 
	 * @param game
	 *            The game to which the screen belongs
	 */
	public TitleScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		soundBounds = new Rectangle(0, 400, 90, 80);
		helpBounds = new Rectangle(765, 400, 35, 80);
		playBounds = new Rectangle(255, 160, 290, 80);
		shopBounds = new Rectangle(255, 80, 290, 80);
		objectivesBounds = new Rectangle(255, 0, 290, 80);
		touchPoint = new Vector2();
	}

	/**
	 * Checks for user interaction with UI, and manages screen transition or
	 * changes settings appropriately
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
			if (event.type == TouchEvent.TOUCH_UP) {
				touchPoint.set(event.x, event.y);
				guiCam.touchToWorld(touchPoint);

				if (OverlapTester.pointInRectangle(soundBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					Settings.soundEnabled = !Settings.soundEnabled;
					if (Settings.soundEnabled)
						Assets.music.play();
					else
						Assets.music.pause();
					return;
				}
				if (OverlapTester.pointInRectangle(helpBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new HelpScreen(game));
					return;
				}
				if (OverlapTester.pointInRectangle(playBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new MapScreen(game));
					return;
				}
				if (OverlapTester.pointInRectangle(shopBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new ShopScreen(game));
					return;
				}
				if (OverlapTester
						.pointInRectangle(objectivesBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new ObjectivesScreen(game));
					return;
				}
			}
		}
	}

	/**
	 * Renders the screen
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

		batcher.beginBatch(Assets.background);
		batcher.drawSprite(400, 240, 800, 480, Assets.backgroundRegion);
		batcher.endBatch();

		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.sprites);

		batcher.drawSprite(400, 360, 375, 224, Assets.title);
		batcher.drawSprite(400, 120, 290, 240, Assets.menu);
		batcher.drawSprite(782.5f, 440, 35, 80, Assets.help);
		if (Settings.soundEnabled)
			batcher.drawSprite(45, 440, 90, 80, Assets.soundOn);
		else
			batcher.drawSprite(25, 440, 50, 80, Assets.soundOff);

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
