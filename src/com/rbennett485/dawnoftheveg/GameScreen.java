package com.rbennett485.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

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

	boolean paused;
	Camera2D guiCam;
	SpriteBatcher batcher;
	World world;
	WorldListener worldListener;
	WorldRenderer renderer;
	Rectangle pauseBounds;
	Rectangle continueBounds;
	Rectangle callNextWaveBounds;
	Rectangle quitBounds;
	Vector2 touchPoint;
	FPSCounter fpsCounter;

	public GameScreen(Game game, Level level) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 1000);
		pauseBounds = new Rectangle(760, 440, 40, 40);
		continueBounds = new Rectangle(400-35, 240-21, 60, 20);
		callNextWaveBounds = new Rectangle(0, 440, 40, 40);
		quitBounds = new Rectangle(400-37, 240-43, 60, 20);
		touchPoint = new Vector2();
		fpsCounter = new FPSCounter();
		paused = false;
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
		world = new World(worldListener, level);
		renderer = new WorldRenderer(glGraphics, batcher, world);
	}

	@Override
	public void update(float deltaTime) {
		if(paused) {
			updatePaused();
			return;
		} else {
			switch(world.state) {

			case(World.WORLD_STATE_RUNNING):
			case(World.WORLD_STATE_INITIAL_BUILD):
				updateRunningOrInitialBuild(deltaTime);
			break; 

			case(World.WORLD_STATE_GAME_OVER):
				updateGameOver();
				break;

			case(World.WORLD_STATE_COMPLETE):
				updateComplete();
			break;

			}
		}
	}

	private void updateComplete() {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);
			if(event.type == TouchEvent.TOUCH_UP) {
				game.setScreen(new MapScreen(game));
			}
		}
	}
	
	private void updateGameOver() {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);
			if(event.type == TouchEvent.TOUCH_UP) {
				game.setScreen(new MapScreen(game));
			}
		}
	}

	private void updateInitialBuild(float deltaTime) {
		// check callWave
		if(OverlapTester.pointInRectangle(callNextWaveBounds, touchPoint)) {
			Assets.playSound(Assets.clickSound);
			world.state = World.WORLD_STATE_RUNNING;
			return;
		}

	}


	private void updateRunning(float deltaTime) {
		//do some stuff
	}

	private void updateRunningOrInitialBuild(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0 ; i<len ; i++) {
			TouchEvent event = touchEvents.get(i);
			touchPoint.set(event.x, event.y);
			guiCam.touchToWorld(touchPoint);
			if(event.type == TouchEvent.TOUCH_UP) {


				// check pause
				if(OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					paused = true;
					return;
				}


				// check tower patches
				if(world.patchMenuCentre != null){
					Vector2 guiCoordsPatchMenuCentre = new Vector2(800*world.patchMenuCentre.x/20f, 480*world.patchMenuCentre.y/12f);
					if(OverlapTester.pointInRectangle(
							new Rectangle(guiCoordsPatchMenuCentre.x-40, guiCoordsPatchMenuCentre.y, 40, 40), touchPoint)){
						Tower towerA = new TowerA(world.patchMenuCentre.x, world.patchMenuCentre.y);
						world.towers.add(towerA);
						world.money -= towerA.getCost();
					}else if(OverlapTester.pointInRectangle(
							new Rectangle(guiCoordsPatchMenuCentre.x, guiCoordsPatchMenuCentre.y, 40, 40), touchPoint)){
						Tower towerB = new TowerB(world.patchMenuCentre.x, world.patchMenuCentre.y);
						world.towers.add(towerB);
						world.money -= towerB.getCost();
					}else if(OverlapTester.pointInRectangle(
							new Rectangle(guiCoordsPatchMenuCentre.x-40, guiCoordsPatchMenuCentre.y-40, 40, 40), touchPoint)){
						Tower towerC = new TowerC(world.patchMenuCentre.x, world.patchMenuCentre.y);
						world.towers.add(towerC);
						world.money-= towerC.getCost();
					}else if(OverlapTester.pointInRectangle(
							new Rectangle(guiCoordsPatchMenuCentre.x, guiCoordsPatchMenuCentre.y-40, 40, 40), touchPoint)){
						Tower towerD = new TowerD(world.patchMenuCentre.x, world.patchMenuCentre.y);
						world.towers.add(towerD);
						world.money -= towerD.getCost();
					} 
					world.patchMenuCentre = null;
					Log.d("patches", "clicked off menu");
				} else {

					for(Vector2 patchCentre : world.towerPatches) {
						Vector2 guiCoordsPatchCentre = new Vector2(800*patchCentre.x/20f, 480*patchCentre.y/12f);
						if(OverlapTester.pointInRectangle(new Rectangle(guiCoordsPatchCentre.x - 20, guiCoordsPatchCentre.y - 20, 40, 40), 
								touchPoint)) {
							world.patchMenuCentre = patchCentre;
							return;
						}
					}
				}

				if(world.state == World.WORLD_STATE_RUNNING)
					updateRunning(deltaTime);
				else if(world.state == World.WORLD_STATE_INITIAL_BUILD)
					updateInitialBuild(deltaTime);
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
					paused = false;
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
		batcher.beginBatch(Assets.sprites);   
		if(paused) {
			presentPaused();
		} else {
			switch(world.state) {
			case(World.WORLD_STATE_INITIAL_BUILD):
				presentInitialBuild();
			break;
			
			case(World.WORLD_STATE_RUNNING):
				presentRunning();
			break;
			
			case(World.WORLD_STATE_COMPLETE):
				presentComplete();
			break;
			

			case(World.WORLD_STATE_GAME_OVER):
				presentGameOver();
			break;
			}
		}

		batcher.endBatch();
		gl.glDisable(GL10.GL_BLEND);
		fpsCounter.logFrame();
	}

	private void presentInitialBuild() {
		presentRunning();
		batcher.drawSprite(20, 460, 40, 40, Assets.callWave);
	}

	private void presentGameOver() {
		batcher.drawSprite(400, 240, 240, 120, Assets.gameOver);
		
	}

	private void presentComplete() {
		batcher.drawSprite(400, 240, 240, 120, Assets.complete);
	}

	public void presentRunning() {
		batcher.drawSprite(780, 460, 40, 40, Assets.back);
		if(world.patchMenuCentre != null) {
			Vector2 guiCoordsPatchCentre = new Vector2(800*world.patchMenuCentre.x/20f, 480*world.patchMenuCentre.y/12f);
			batcher.drawSprite(guiCoordsPatchCentre.x, guiCoordsPatchCentre.y, 80, 80, Assets.towerMenu);
		}
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
