package com.badlogic.androidgames.dawnoftheveg;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.gl.Camera2D;
import com.badlogic.androidgames.framework.gl.SpriteBatcher;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLScreen;
import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;

public class HelpScreen extends GLScreen {
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle nextBounds;
	Rectangle previousBounds;
	Vector2 touchPoint;
	Texture helpImage;
	TextureRegion helpRegion;
	
	public HelpScreen(Game game) {
		super(game);
		
		guiCam = new Camera2D(glGraphics, 800, 480);
		nextBounds = new Rectangle(220, 720, 40, 40);
		previousBounds = new Rectangle(220, 40, 40, 40);
		touchPoint = new Vector2();
		batcher = new SpriteBatcher(glGraphics, 100);
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
					game.setScreen(new HelpScreen2(game));
					return;
				}
				
				// edit this to include more help screens
				if(OverlapTester.pointInRectangle(previousBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new HelpScreen2(game));
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
		
		batcher.beginBatch(helpImage);
		batcher.drawSprite(????);
		batcher.endBatch();
		
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		batcher.beginBatch(Assets.icons);
		batcher.drawSprite(x, y, width, height, Assets.rightArrow);
		batcher.drawSprite(x, y, width, height, Assets.rightArrow);//use -ve width for left arrow
		// any other icons - title etc
		batcher.endBatch();
		
		gl.glDisable(GL10.GL_BLEND);
	}

	@Override
	public void pause() {
		helpImage.dispose();
	}

	@Override
	public void resume() {
		helpImage = new Texture(glGame, "help1.png");
		helpRegion = new TextureRegion(helpImage, 0, 0, ???, ???);
	}

	@Override
	public void dispose() {
	}

}
