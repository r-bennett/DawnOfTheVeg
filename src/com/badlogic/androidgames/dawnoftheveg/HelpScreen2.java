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

public class HelpScreen2 extends GLScreen {	
	Camera2D guiCam;
	SpriteBatcher batcher;
	Rectangle nextBounds;
	Rectangle previousBounds; //for previous help screen
	Rectangle backBounds; //for returning to title screen
	Vector2 touchPoint;
	Texture helpImage;
	TextureRegion helpRegion;
	

	public HelpScreen2(Game game) {
		super(game);

		guiCam = new Camera2D(glGraphics, 800, 480);
		nextBounds = new Rectangle(220, 720, 40, 40);
		previousBounds = new Rectangle(220, 40, 40, 40);
		backBounds = new Rectangle(760, 440, 40, 40);
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
				// edit this to include more help screens
				if(OverlapTester.pointInRectangle(nextBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new HelpScreen1(game));
					return;
				}

				if(OverlapTester.pointInRectangle(previousBounds, touchPoint)) {
					Assets.playSound(Assets.clickSound);
					game.setScreen(new HelpScreen1(game));
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

		batcher.beginBatch(helpImage);
		batcher.drawSprite(400, 180, 560, 320, helpRegion);
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
		helpImage.dispose();
	}

	@Override
	public void resume() {
		helpImage = new Texture(glGame, "help2.png");
		helpRegion = new TextureRegion(helpImage, 0, 0, 560, 320);
	}

	@Override
	public void dispose() {
	}

}
