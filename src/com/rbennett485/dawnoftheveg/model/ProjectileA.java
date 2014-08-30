package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 *
 */
public class ProjectileA extends Projectile {
	public static final float PROJECTILE_A_SPEED = 5f;
	public static final float PROJECTILE_A_WIDTH = 0.275f;
	public static final float PROJECTILE_A_HEIGHT = 0.125f;
	
	/**
	 * Constructor
	 * 
	 * @param position Initial position (world coords)
	 * @param velocity Projectile's velocity
	 * @param damage Number of damage points the projectile will do on enemy
	 * @param range The maximum distance the projectile can travel
	 */
	public ProjectileA(Vector2 position, Vector2 velocity, int damage, float range) {
		this(position.x, position.y, PROJECTILE_A_WIDTH, PROJECTILE_A_HEIGHT);
		this.velocity = velocity;
		this.damagePoints = damage;
		this.rangeTime = range / velocity.len();
	}
	
	private ProjectileA(float x, float y, float width, float height) {
		super(x, y, width, height);
		speed = PROJECTILE_A_SPEED;
	}

}
