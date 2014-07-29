package com.rbennett485.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.FPSCounter;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.World.WorldListener;

public class GameScreen extends GLScreen {

	static final int GAME_RUNNING = 0;
	static final int GAME_PAUSED = 1;

	int state;
	Camera2D guiCam;
	SpriteBatcher batcher;
	World world;
	WorldListener worldListener;
	WorldRenderer renderer;
	Rectangle pauseBounds;
	Rectangle continueBounds;
	Rectangle quitBounds;
	Vector2 touchPoint;
	FPSCounter fpsCounter;

	public GameScreen(Game game) {
		super(game);
		state = GAME_RUNNING;
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		pauseBounds = new Rectangle(760, 440, 40, 40);
		continueBounds = new Rectangle(400-35, 240-21, 60, 20);
		quitBounds = new Rectangle(400-37, 240-43, 60, 20);
		touchPoint = new Vector2();
		fpsCounter = new FPSCounter();
		worldListener = new WorldListener() {

			@Override
			public void shot() {
				// TODO Auto-generated method stub
			}

			@Override
			public void splat() {
				// TODO Auto-generated method stub
			}

		};
		world = new World(worldListener);
		renderer = new WorldRenderer(glGraphics, batcher, world);
	}

	@Override
	public void update(float deltaTime) {
		switch(state) {
		case(GAME_RUNNING):
			updateRunning(deltaTime);
		break;
		case(GAME_PAUSED):
			updatePaused();
		break;
		}
	}

	public void updateRunning(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);
			if(event.type == TouchEvent.TOUCH_UP) {
				if(OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					state = GAME_PAUSED;
					return;
				}
			}
		}
		world.update(deltaTime);
	}

	public void updatePaused() {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);
			if(event.type == TouchEvent.TOUCH_UP) {
				if(OverlapTester.pointInRectangle(continueBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					state = GAME_RUNNING;
					return;
				}
				if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new MapScreen(game));
					return;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();        
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glEnable(GL10.GL_TEXTURE_2D);

		renderer.render();

		guiCam.setViewportAndMatrices();
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		batcher.beginBatch(Assets.icons);          
		switch(state) {
		case(GAME_RUNNING):
			presentRunning();
		break;
		case(GAME_PAUSED):
			presentPaused();
		break;
		}

		batcher.endBatch();
		gl.glDisable(GL10.GL_BLEND);
		fpsCounter.logFrame();
	}
	
	public void presentRunning() {
		batcher.drawSprite(780, 460, 40, 40, Assets.back);
	}
	
	public void presentPaused() {
		batcher.drawSprite(400, 240, 132, 101, Assets.pauseMenu);
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
