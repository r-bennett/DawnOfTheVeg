package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.DynamicGameObject;

/**
 * Represents projectiles in the game's model
 * 
 * @author Bennett_Richard
 *
 */
public class Projectile extends DynamicGameObject {

	public int damagePoints;
	public float speed;
	public float rangeTime;
	public float stateTime;

	/**
	 * Constructor
	 * 
	 * @param x Initial position x coord (world coords)
	 * @param y Initial position y coord (world coords)
	 * @param width Width of bounds rectangle
	 * @param height Height of bounds rectangle
	 */
	public Projectile(float x, float y, float width, float height) {
		super(x, y, width, height);
		stateTime = 0;
	}
	
	/**
	 * Updates the projectile's position, bounds and stateTime
	 * 
	 * @param deltaTime The time elapsed in seconds since the projectile
	 * was last updated
	 */
	@Override
	public void update(float deltaTime) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        bounds.lowerLeft.set(position).sub(bounds.width / 2, bounds.height / 2);
        stateTime += deltaTime;
	}

}
