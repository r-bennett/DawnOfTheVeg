package com.rbennett485.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;

public class MapScreen extends GLScreen {
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle backBounds;
	Rectangle[] levelBounds;
	Vector2 touchPoint;

	public MapScreen(Game game) {
		super(game);

		Log.d("progress", Progress.level[0] + ", " + Progress.level[1]);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		backBounds = new Rectangle(760, 440, 40, 40);
		levelBounds = new Rectangle[Progress.NUMBER_OF_LEVELS];
		levelBounds[0] = new Rectangle(326, 398, 40, 40);
		levelBounds[1] = new Rectangle(344, 362, 40, 40);
		levelBounds[2] = new Rectangle(150, 331, 40, 40);
		levelBounds[3] = new Rectangle(760, 62, 40, 40);
		levelBounds[4] = new Rectangle(185, 372, 40, 40);
		levelBounds[5] = new Rectangle(88, 209, 40, 40);
		levelBounds[6] = new Rectangle(434, 305, 40, 40);
		levelBounds[7] = new Rectangle(696, 317, 40, 40);
		touchPoint = new Vector2();
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);

			if(event.type == TouchEvent.TOUCH_UP) {
				if(OverlapTester.pointInRectangle(backBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new TitleScreen(game));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[0], touchPoint) && Progress.level[0]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 0));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[1], touchPoint) && Progress.level[1]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 3));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[2], touchPoint) && Progress.level[2]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 4));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[3], touchPoint) && Progress.level[3]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 5));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[4], touchPoint) && Progress.level[4]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 6));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[5], touchPoint) && Progress.level[5]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 7));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[6], touchPoint) && Progress.level[6]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 8));
					return;
				}
				if(OverlapTester.pointInRectangle(levelBounds[7], touchPoint) && Progress.level[7]) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new StoryScreen(game, 9));
					return;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();        
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.setViewportAndMatrices();

		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.map);
		batcher.drawSprite(400, 240, 800, 480, Assets.mapRegion);
		batcher.endBatch();

		batcher.beginBatch(Assets.sprites);
		batcher.drawSprite(780, 460, 40, 40, Assets.back);
		presentLevelIcons();
		batcher.endBatch();

		gl.glDisable(GL10.GL_BLEND);
	}

	private void presentLevelIcons() {
		for(int i=0 ; i<Progress.NUMBER_OF_LEVELS ; i++) {
			Rectangle bounds = levelBounds[i];
			if(Progress.level[i]) {
				batcher.drawSprite(bounds.lowerLeft.x + bounds.width/2f, 
						bounds.lowerLeft.y + bounds.height/2f, 40, 40, Assets.hazard);
				Log.d("levels", "drawing hazard at " + bounds.lowerLeft.x + bounds.width/2f + ", " + bounds.lowerLeft.y + bounds.height/2f);
			} else {
				batcher.drawSprite(bounds.lowerLeft.x + bounds.width/2f, 
						bounds.lowerLeft.y + bounds.height/2f, 36, 32, Assets.cross);
				Log.d("levels", "drawing cross");
			}
		}
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
