package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 *
 */
public class ProjectileC extends Projectile {
	public static final float PROJECTILE_C_SPEED = 5f;
	public static final float PROJECTILE_C_WIDTH = 0.2f;
	public static final float PROJECTILE_C_HEIGHT = 0.2f;
	
	public ProjectileC(Vector2 position, Vector2 velocity, int damage, float range) {
		this(position.x, position.y, PROJECTILE_C_WIDTH, PROJECTILE_C_HEIGHT);
		this.velocity = velocity;
		this.damagePoints = damage;
		this.rangeTime = range / velocity.len();
	}
	
	private ProjectileC(float x, float y, float width, float height) {
		super(x, y, width, height);
		speed = PROJECTILE_C_SPEED;
	}


}
