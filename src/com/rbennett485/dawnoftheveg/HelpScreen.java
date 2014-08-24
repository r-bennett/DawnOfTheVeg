package com.rbennett485.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;

public class HelpScreen extends GLScreen {
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle nextBounds;
	Rectangle previousBounds; //for previous help screen
	Rectangle backBounds; //for returning to title screen
	Vector2 touchPoint;
	private int currentRegion;
	
	public HelpScreen(Game game) {
		super(game);
		
		guiCam = new Camera2D(glGraphics, 800, 480);
		nextBounds = new Rectangle(720, 220, 40, 40);
		previousBounds = new Rectangle(40, 220, 40, 40);
		backBounds = new Rectangle(760, 440, 40, 40);
		touchPoint = new Vector2();
		batcher = new SpriteBatcher(glGraphics, 100);
		currentRegion = 0;
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
				if(OverlapTester.pointInRectangle(nextBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					currentRegion = (((currentRegion + 1) % Assets.NUMBER_OF_HELP_REGIONS) + 
							Assets.NUMBER_OF_HELP_REGIONS) % Assets.NUMBER_OF_HELP_REGIONS;
					return;
				}
				
				// edit this to include more help screens
				if(OverlapTester.pointInRectangle(previousBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					currentRegion = (((currentRegion - 1) % Assets.NUMBER_OF_HELP_REGIONS) + 
							Assets.NUMBER_OF_HELP_REGIONS) % Assets.NUMBER_OF_HELP_REGIONS;;
					return;
				}
				
				if(OverlapTester.pointInRectangle(backBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new TitleScreen(game));
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
		
		batcher.beginBatch(Assets.helpImage);
		batcher.drawSprite(400, 180, 560, 320, Assets.helpRegion[currentRegion]);
		batcher.endBatch();
		
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		batcher.beginBatch(Assets.icons);
		batcher.drawSprite(740, 240, 40, 40, Assets.rightArrow);
		batcher.drawSprite(60, 240, -40, 40, Assets.rightArrow);	//use -ve width for left arrow
		batcher.drawSprite(400, 420, 42, 39, Assets.tip);
		batcher.drawSprite(780, 460, 40, 40, Assets.back);
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
