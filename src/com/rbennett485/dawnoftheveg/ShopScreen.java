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
import com.rbennett485.dawnoftheveg.data.Progress;
import com.rbennett485.dawnoftheveg.data.Settings;
import com.rbennett485.dawnoftheveg.variables.Shop;

/**
 * Displays the shop, and manages the display and navigation of items for sale
 * 
 * @author Bennett_Richard
 * 
 */
public class ShopScreen extends GLScreen {

	private Camera2D guiCam;
	private SpriteBatcher batcher;
	private Rectangle backBounds;
	private Vector2 touchPoint;
	private int currentItem;
	private Rectangle nextBounds;
	private Rectangle previousBounds;
	private Rectangle buyBounds;

	/**
	 * Constructor
	 * 
	 * @param game
	 *            The game to which the screen belongs
	 */
	public ShopScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		backBounds = new Rectangle(720, 400, 80, 80);
		nextBounds = new Rectangle(710, 140, 60, 200);
		previousBounds = new Rectangle(30, 140, 60, 200);
		buyBounds = new Rectangle(325, 75, 150, 50);
		touchPoint = new Vector2();
		currentItem = 0;
	}

	/**
	 * Monitors for UI interaction, and updates the screen or executes the
	 * purchase accordingly
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
				if (OverlapTester.pointInRectangle(backBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new TitleScreen(game));
					return;
				}
				if (OverlapTester.pointInRectangle(nextBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					currentItem = ((currentItem + 1) % Shop.NUMBER_OF_ITEMS + Shop.NUMBER_OF_ITEMS)
							% Shop.NUMBER_OF_ITEMS;
					return;
				}
				if (OverlapTester.pointInRectangle(previousBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					currentItem = ((currentItem - 1) % Shop.NUMBER_OF_ITEMS + Shop.NUMBER_OF_ITEMS)
							% Shop.NUMBER_OF_ITEMS;
					return;
				}
				if (!Progress.shop[currentItem]
						&& OverlapTester
								.pointInRectangle(buyBounds, touchPoint)) {
					Shop.items[currentItem].purchase();
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
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.sprites);
		presentIcons();
		presentItem();
		presentText();
		batcher.endBatch();

		gl.glDisable(GL10.GL_BLEND);
	}

	private void presentIcons() {
		batcher.drawSprite(740, 240, 40, 40, Assets.rightArrow);
		batcher.drawSprite(60, 240, -40, 40, Assets.rightArrow);
		batcher.drawSprite(400, 420, 171, 71, Assets.shop);
		batcher.drawSprite(760, 440, 80, 80, Assets.back);
		if (Progress.shop[currentItem])
			batcher.drawSprite(400, 100, 150, 50, Assets.bought);
		else
			batcher.drawSprite(400, 100, 150, 50, Assets.buy);
	}

	private void presentText() {
		Assets.font.drawText(batcher, "Gems: " + Progress.funds, 40, 440);
		if (!Progress.shop[currentItem])
			Assets.font.drawText(batcher, "Cost: "
					+ Shop.items[currentItem].cost, 360, 40);
	}

	private void presentItem() {
		ShopItem item = Shop.items[currentItem];
		batcher.drawSprite(400, 240, item.width, item.height, item.region);
	}

	@Override
	public void pause() {
		Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
