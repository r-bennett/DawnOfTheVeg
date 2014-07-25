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

public class Level1GameScreen extends GLScreen {

	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle pauseBounds;
	Rectangle continueBounds;
	Rectangle quitBounds;
	Vector2 touchPoint;

	boolean paused = false;

	public Level1GameScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		pauseBounds = new Rectangle(760, 440, 40, 40);
		continueBounds = new Rectangle(400-35, 240-21, 60, 20);
		quitBounds = new Rectangle(400-37, 240-43, 60, 20);
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
			if(paused){
				if(OverlapTester.pointInRectangle(continueBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					paused = false;
					return;
				}
				if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new MapScreen(game));
					return;
				}
			} else {
				if(event.type == TouchEvent.TOUCH_UP) {
					if(OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
						Assets.playSound(Assets.clickSound);
						paused = true;
						return;
					}
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

		batcher.beginBatch(Assets.icons);          
		batcher.drawSprite(780, 460, 40, 40, Assets.back);

		if(paused) {
			batcher.drawSprite(400, 240, 132, 101, Assets.pauseMenu);
		}

		batcher.endBatch();

		gl.glDisable(GL10.GL_BLEND);
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
