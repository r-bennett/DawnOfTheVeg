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

public class MapScreen extends GLScreen {
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle backBounds;
	Rectangle level1Bounds;
	Vector2 touchPoint;

	public MapScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 100);
		backBounds = new Rectangle(760, 440, 40, 40);
		level1Bounds = new Rectangle(100-Assets.font.glyphWidth/2, 
				300-Assets.font.glyphHeight/2, 7*Assets.font.glyphWidth, Assets.font.glyphHeight);
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
				if(OverlapTester.pointInRectangle(level1Bounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new Level1GameScreen(game));
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
        
        batcher.beginBatch(Assets.icons);
        batcher.drawSprite(780, 460, 40, 40, Assets.back);
        batcher.endBatch();
        
        batcher.beginBatch(Assets.fontImage);
        Assets.font.drawText(batcher, "Level 1", 100, 300);
        Assets.font.drawText(batcher, "Level 2", 200, 200);
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
