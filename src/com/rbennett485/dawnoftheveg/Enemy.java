package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class Enemy extends DynamicGameObject {

	public Enemy(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
    @Override 
    public Enemy clone() {
    	return new Enemy(this.position.x, this.position.y, 
    			this.bounds.width, this.bounds.height); 
    }

	public void hit(Projectile p) {
		// TODO Auto-generated method stub
		
	}

}
