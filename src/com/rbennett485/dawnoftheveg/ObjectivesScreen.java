package com.rbennett485.dawnoftheveg;

import java.util.Calendar;
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
import com.rbennett485.dawnoftheveg.data.Progress;
import com.rbennett485.dawnoftheveg.variables.Objectives;

/**
 * Displays objectives and indicates if complete
 * 
 * @author Bennett_Richard
 *
 */
public class ObjectivesScreen extends GLScreen {
	private Camera2D guiCam;
	private SpriteBatcher batcher;
	private Rectangle backBounds;
	private Vector2 touchPoint;
	
	/**
	 * Constructor
	 * 
	 * @param game The game instance to which the screen belongs
	 */
	public ObjectivesScreen(Game game) {
		super(game);
		guiCam = new Camera2D(glGraphics, 800, 480);
		batcher = new SpriteBatcher(glGraphics, 1000);
		backBounds = new Rectangle(720, 400, 80, 80);
		touchPoint = new Vector2();
		checkObjectivesSet();
	}

	private void checkObjectivesSet() {
		if(Progress.objectivesFinished)
			return;
		for(boolean b : Progress.objective[Progress.currentObjectiveSet]) {
			if(!b)
				return;
		}
		Calendar c = Calendar.getInstance();
		if(!Progress.objectivesDateWritten) {
			Progress.funds += 50;
			Progress.dateLastObjectives[0] = c.get(Calendar.DATE);
			Progress.dateLastObjectives[1] = c.get(Calendar.MONTH);
			Progress.dateLastObjectives[2] = c.get(Calendar.YEAR);
			Progress.objectivesDateWritten = true;
			if(Progress.currentObjectiveSet == Objectives.NUMBER_OF_OBJECTIVE_SETS)
				Progress.objectivesFinished = true;
			return;
		}
		if(c.get(Calendar.DATE)!=Progress.dateLastObjectives[0] ||
				c.get(Calendar.MONTH)!=Progress.dateLastObjectives[1] ||
				c.get(Calendar.YEAR)!=Progress.dateLastObjectives[2] )	{
			Progress.currentObjectiveSet++;
			Progress.objectivesDateWritten = false;
		}
	}

	/**
	 * Checks for UI interaction, and manages screen transition accordingly
	 * 
	 * @param deltaTime unused
	 */
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
			}
		}
	}

	/**
	 * Renders the screen
	 * 
	 * @param deltaTime unused
	 */
	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();        
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.setViewportAndMatrices();

		gl.glEnable(GL10.GL_TEXTURE_2D);

		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		batcher.beginBatch(Assets.sprites);          
		batcher.drawSprite(400, 420, 291, 74, Assets.objectives);
		batcher.drawSprite(760, 440, 80, 80, Assets.back);
		for(int i=0 ; i<3 ; i++) {
			batcher.drawSprite(760, 360-140*i, 40, 40, Assets.tickBox);
			if(Progress.objective[Progress.currentObjectiveSet][i]) {
				batcher.drawSprite(760, 360-140*i, 40, 40, Assets.tick);
			}
		}
				
		for(int i=0 ; i<3 ; i++) {
			Assets.font.drawText(batcher, (i+1) +". " + Objectives.objectives[Progress.currentObjectiveSet][i][0], 100, 360-140*i);
			Assets.font.drawText(batcher, Objectives.objectives[Progress.currentObjectiveSet][i][1], 100, 320-140*i);
		}
		
		if(Progress.objectivesFinished)
			batcher.drawSprite(400, 240, 319, 339, Assets.allObjectivesComplete);
		else if(Progress.objectivesDateWritten)
			batcher.drawSprite(400, 240, 319, 339, Assets.objectivesComplete);
		
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
