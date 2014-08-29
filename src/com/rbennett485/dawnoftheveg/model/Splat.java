package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * Represents splats in the game's model (used  when an 
 * enemy has died)
 * 
 * @author Bennett_Richard
 *
 */
public class Splat extends GameObject {
	
	public float stateTime;
	public static final float TIME_TO_LIVE = 3;
	public TextureRegion region;
	
	/**
	 * Constructor
	 * 
	 * @param e The enemy from which the splat copies its colour, position and size
	 */
	public Splat(Enemy e) {
		super(e.position.x, e.position.y, e.bounds.width, e.bounds.height);
		
		if(e instanceof Orange)
			region = Assets.orangeSplat;
		else if(e instanceof Grape) 
			region = Assets.grapeSplat;
		else if(e instanceof Chilli) 
			region = Assets.chilliSplat;
		else
			region = Assets.peaSplat;
	}
	
	/**
	 * Updates the splat's state time
	 * 
	 * @param deltaTime Seconds elapsed since last updated
	 */
	public void update(float deltaTime) {
		stateTime += deltaTime;
	}
}
