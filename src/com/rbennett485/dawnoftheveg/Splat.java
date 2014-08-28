package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.gl.TextureRegion;

public class Splat extends GameObject {
	
	public float stateTime;
	public static final float TIME_TO_LIVE = 3;
	public TextureRegion region;
	
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
	
	public void update(float deltaTime) {
		stateTime += deltaTime;
	}
}
