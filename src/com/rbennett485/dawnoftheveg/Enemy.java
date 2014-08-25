package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.DynamicGameObject;
import com.badlogic.androidgames.framework.gl.TextureRegion;

public class Enemy extends DynamicGameObject {
	
	public TextureRegion region;

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
		hp -= p.damagePoints;
		if(hp<0)
			hp = 0;
	}

}
