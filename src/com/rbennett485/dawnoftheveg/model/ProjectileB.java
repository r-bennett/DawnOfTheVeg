package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 *
 */
public class ProjectileB extends Projectile {
	public static final float PROJECTILE_B_SPEED = 10f;
	public static final float PROJECTILE_B_WIDTH = 0.15f;
	public static final float PROJECTILE_B_HEIGHT = 0.15f;
	
	/**
	 * Constructor
	 * 
	 * @param position Initial position (world coords)
	 * @param velocity Projectile's velocity
	 * @param damage Number of damage points the projectile will do on enemy
	 * @param range The maximum distance the projectile can travel
	 */
	public ProjectileB(Vector2 position, Vector2 velocity, int damage, float range) {
		this(position.x, position.y, PROJECTILE_B_WIDTH, PROJECTILE_B_HEIGHT);
		this.velocity = velocity;
		this.damagePoints = damage;
		this.velocity.nor().mul(speed);
		this.rangeTime = range / velocity.len();
	}
	
	private ProjectileB(float x, float y, float width, float height) {
		super(x, y, width, height);
		speed = PROJECTILE_B_SPEED;
	}


}
