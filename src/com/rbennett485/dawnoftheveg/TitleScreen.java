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

public class TitleScreen extends GLScreen {
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle soundBounds;
	Rectangle helpBounds;
	Rectangle playBounds;
	Rectangle shopBounds;
	Rectangle objectivesBounds;
	Vector2 touchPoint;
	
	public TitleScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		soundBounds = new Rectangle(0, 440, 40, 40);
		helpBounds = new Rectangle(760,440,40,40);
		playBounds = new Rectangle(400-60/2, 200+(2*89)/3f, 60, 89/3f);
		shopBounds = new Rectangle(400-60/2, 200+89/3f, 60, 89/3f);
		objectivesBounds = new Rectangle(400-60/2, 200, 60, 89/3f);
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
				touchPoint.set(event.x, event.y);
				guiCam.touchToWorld(touchPoint);
				
				if(OverlapTester.pointInRectangle(soundBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					Settings.soundEnabled = !Settings.soundEnabled;
					if(Settings.soundEnabled)
						Assets.music.play();
					else
						Assets.music.pause();
					return;
				}
				if(OverlapTester.pointInRectangle(helpBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new HelpScreen(game));
					return;
				}
				if(OverlapTester.pointInRectangle(playBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new MapScreen(game));
					return;
				}
				if(OverlapTester.pointInRectangle(shopBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new ShopScreen(game));
					return;
				}
				if(OverlapTester.pointInRectangle(objectivesBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new ObjectivesScreen(game));
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
		
		batcher.beginBatch(Assets.background);
		batcher.drawSprite(400, 240, 800, 480, Assets.backgroundRegion);
		batcher.endBatch();
		
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		batcher.beginBatch(Assets.sprites);
		
		batcher.drawSprite(400, 340, 179, 42, Assets.title);
		batcher.drawSprite(400, 200+89/2f, 60, 89, Assets.menu);
		batcher.drawSprite(780, 460, 40, 40, Assets.help);
		batcher.drawSprite(20, 460, 40, 40, Settings.soundEnabled?Assets.soundOn:Assets.soundOff);
		
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
