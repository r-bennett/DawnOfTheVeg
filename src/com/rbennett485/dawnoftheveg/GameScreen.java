package com.rbennett485.dawnoftheveg;

import java.util.List;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.FPSCounter;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.data.Progress;
import com.rbennett485.dawnoftheveg.model.Level;
import com.rbennett485.dawnoftheveg.model.Tower;
import com.rbennett485.dawnoftheveg.model.TowerA;
import com.rbennett485.dawnoftheveg.model.TowerB;
import com.rbennett485.dawnoftheveg.model.TowerC;
import com.rbennett485.dawnoftheveg.model.TowerD;
import com.rbennett485.dawnoftheveg.model.World;
import com.rbennett485.dawnoftheveg.model.World.WorldListener;
import com.rbennett485.dawnoftheveg.variables.Objectives;
import com.rbennett485.dawnoftheveg.variables.Upgrades;

/**
 * The {@link Screen} instance for playing the game
 * 
 * @author Bennett_Richard
 *
 */
public class GameScreen extends GLScreen {

	private boolean paused;
	private Camera2D guiCam;
	private SpriteBatcher batcher;
	private World world;
	private WorldListener worldListener;
	private WorldRenderer renderer;
	private Rectangle pauseBounds;
	private Rectangle continueBounds;
	private Rectangle callNextWaveBounds;
	private Rectangle quitBounds;
	private Vector2 touchPoint;
	private FPSCounter fpsCounter;
	private Random rand;

	/**
	 * Constructor
	 * 
	 * @param game The {@link Game} the object belongs to
	 * @param level The {@link Level} which the GameScreen is to model
	 */
	public GameScreen(Game game, Level level) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 1000);
		pauseBounds = new Rectangle(760, 440, 40, 40);
		continueBounds = new Rectangle(400-313/2f, 240, 313, 304/2);
		callNextWaveBounds = new Rectangle(0, 440, 40, 40);
		quitBounds = new Rectangle(400-313/2f, 240-304/2, 313, 304/2);
		touchPoint = new Vector2();
		fpsCounter = new FPSCounter();
		paused = false;
		rand = new Random();
		worldListener = new WorldListener() {
			@Override
			public void splat() {
				if(rand.nextInt(2)<1) {
					Assets.playSound(Assets.splat1);
				} else
					Assets.playSound(Assets.splat2);
			}
		};
		world = new World(worldListener, level);
		renderer = new WorldRenderer(glGraphics, batcher, world);
	}

	/**
	 * Handles touch events, checking whether UI items have been touched
	 * and responding appropriately
	 */
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
				Objectives.level1Complete();
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
					if(world.towerAt(world.patchMenuCentre)){
						Tower t = world.getTowerAt(world.patchMenuCentre);
						// proceed with upgrade menu for tower t
						if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x-60, guiCoordsPatchMenuCentre.y, 60, 60), touchPoint)
								&& world.money >= Upgrades.RANGE_COST) {
							//upgrade range
							t.upgradeRange();
							world.money -= Upgrades.RANGE_COST;
						} else if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x, guiCoordsPatchMenuCentre.y, 60, 60), touchPoint)
								&& world.money >= Upgrades.DAMAGE_COST) {
							//upgrade damage
							t.upgradeDamage();
							world.money -= Upgrades.DAMAGE_COST;
						} else if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x-60, guiCoordsPatchMenuCentre.y-60, 60, 60), touchPoint)
								&& world.money >= Upgrades.RELOAD_COST){
							//upgrade reload time
							t.upgradeReload();
							world.money -= Upgrades.RELOAD_COST;
						}
					} else {
						//proceed with tower menu
						if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x-60, guiCoordsPatchMenuCentre.y, 60, 60), touchPoint)
								&& world.money >= TowerA.TOWER_A_COST
								&& Progress.tower[0]) {
							//build A
							Tower towerA = new TowerA(world.patchMenuCentre.x, world.patchMenuCentre.y);
							world.towers.add(towerA);
							world.money -= towerA.getCost();
							Objectives.builtTower();
						} else if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x, guiCoordsPatchMenuCentre.y, 60, 60), touchPoint)
								&& world.money >= TowerB.TOWER_B_COST
								&& Progress.tower[1]) {
							//build B
							Tower towerB = new TowerB(world.patchMenuCentre.x, world.patchMenuCentre.y);
							world.towers.add(towerB);
							world.money -= towerB.getCost();
							Objectives.builtTower();
						} else if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x-60, guiCoordsPatchMenuCentre.y-60, 60, 60), touchPoint)
								&& world.money >= TowerC.TOWER_C_COST
								&& Progress.tower[2]){
							//build C
							Tower towerC = new TowerC(world.patchMenuCentre.x, world.patchMenuCentre.y);
							world.towers.add(towerC);
							world.money-= towerC.getCost();
							Objectives.builtTower();
						} else if(OverlapTester.pointInRectangle(
								new Rectangle(guiCoordsPatchMenuCentre.x, guiCoordsPatchMenuCentre.y-60, 60, 60), touchPoint)
								&& world.money >= TowerD.TOWER_D_COST
								&& Progress.tower[3]){
							//build D
							Tower towerD = new TowerD(world.patchMenuCentre.x, world.patchMenuCentre.y);
							world.towers.add(towerD);
							world.money -= towerD.getCost();
							Objectives.builtTower();
						}
					}

					world.patchMenuCentre = null;
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

				if(world.state == World.WORLD_STATE_INITIAL_BUILD)
					updateInitialBuild(deltaTime);
			}
		}
		world.update(deltaTime);

	}

	private void updatePaused() {
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

	/**
	 * Renders the UI elements depending on the state of world
	 * 
	 * @param deltaTime Elapsed time in seconds since this method was last called
	 */
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
		batcher.drawSprite(400, 240, 291, 72, Assets.gameOver);

	}

	private void presentComplete() {
		batcher.drawSprite(400, 240, 291, 73, Assets.complete);
	}

	private void presentRunning() {
		batcher.drawSprite(780, 460, 40, 40, Assets.pause);
		if(world.patchMenuCentre != null) {
			Vector2 guiCoordsPatchCentre = new Vector2(800*world.patchMenuCentre.x/20f, 480*world.patchMenuCentre.y/12f);
			if(world.towerAt(world.patchMenuCentre)) {
				batcher.drawSprite(guiCoordsPatchCentre.x, guiCoordsPatchCentre.y, 120, 120, Assets.upgradeMenu);
				if(world.money < Upgrades.RANGE_COST) 	
					batcher.drawSprite(guiCoordsPatchCentre.x - 30, guiCoordsPatchCentre.y + 30, 36, 32, Assets.redCross);

				if(world.money < Upgrades.DAMAGE_COST) 					
					batcher.drawSprite(guiCoordsPatchCentre.x + 30, guiCoordsPatchCentre.y + 30, 36, 32, Assets.redCross);


				if(world.money < Upgrades.RELOAD_COST) 	
					batcher.drawSprite(guiCoordsPatchCentre.x - 30, guiCoordsPatchCentre.y - 30, 36, 32, Assets.redCross);
			} else {
				batcher.drawSprite(guiCoordsPatchCentre.x, guiCoordsPatchCentre.y, 120, 120, Assets.towerMenu);
				if(world.money < TowerA.TOWER_A_COST || !Progress.tower[0]) 	
					batcher.drawSprite(guiCoordsPatchCentre.x - 30, guiCoordsPatchCentre.y + 30, 36, 32, Assets.redCross);
				
				if(world.money < TowerB.TOWER_B_COST || !Progress.tower[1]) 					
					batcher.drawSprite(guiCoordsPatchCentre.x + 30, guiCoordsPatchCentre.y + 30, 36, 32, Assets.redCross);

			
				if(world.money < TowerC.TOWER_C_COST || !Progress.tower[2]) 	
					batcher.drawSprite(guiCoordsPatchCentre.x - 30, guiCoordsPatchCentre.y - 30, 36, 32, Assets.redCross);
				
				if(world.money < TowerD.TOWER_D_COST || !Progress.tower[3]) 	
					batcher.drawSprite(guiCoordsPatchCentre.x + 30, guiCoordsPatchCentre.y - 30, 36, 32, Assets.redCross);
			}
		}
	}

	private void presentPaused() {
		batcher.drawSprite(400, 240, 313, 304, Assets.pauseMenu);
	}

	@Override
	public void pause() {
		paused = true;
	}

	@Override
	public void resume() {
	}

	@Override 
	public void dispose() {
	}

}
