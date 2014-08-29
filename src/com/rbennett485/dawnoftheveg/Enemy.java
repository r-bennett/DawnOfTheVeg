package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.DynamicGameObject;
import com.badlogic.androidgames.framework.gl.TextureRegion;

/** Represents enemies in game's model
 * 
 * @author Bennett_Richard
 *
 */
public abstract class Enemy extends DynamicGameObject {
	
	public TextureRegion region;

	public Enemy(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
    /**
     * Returns a new Enemy of the same type, 
     * with the same position and waypoints
     * 
     * @return the new Enemy instance
     */
    @Override 
    public abstract Enemy clone();

    /**
     * Decreases hp by the projectile's damagePoints.
     * If hp is below 0 as a result, it is changed to 0
     * 
     * @param p The projectile that has hit the enemy
     */
	public void hit(Projectile p) {
		hp -= p.damagePoints;
		if(hp<0)
			hp = 0;
	}

}
