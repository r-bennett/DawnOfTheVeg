package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 *
 */
public class ProjectileD extends Projectile {
	public static final float PROJECTILE_D_SPEED = 5f;
	public static final float PROJECTILE_D_WIDTH = 0.2f;
	public static final float PROJECTILE_D_HEIGHT = 0.2f;
	
	public ProjectileD(Vector2 position, Vector2 velocity, int damage, float range) {
		this(position.x, position.y, PROJECTILE_D_WIDTH, PROJECTILE_D_HEIGHT);
		this.velocity = velocity;
		this.damagePoints = damage;
		this.rangeTime = range / velocity.len();
	}
	
	private ProjectileD(float x, float y, float width, float height) {
		super(x, y, width, height);
		speed = PROJECTILE_D_SPEED;
	}


}
