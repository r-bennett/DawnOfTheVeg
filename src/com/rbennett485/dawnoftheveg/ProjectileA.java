package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class ProjectileA extends Projectile {
	public static final float PROJECTILE_A_SPEED = 5f;
	public static final float PROJECTILE_A_WIDTH = 0.2f;
	public static final float PROJECTILE_A_HEIGHT = 0.2f;
	
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
