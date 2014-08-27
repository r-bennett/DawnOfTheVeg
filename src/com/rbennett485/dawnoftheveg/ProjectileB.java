package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class ProjectileB extends Projectile {
	public static final float PROJECTILE_B_SPEED = 5f;
	public static final float PROJECTILE_B_WIDTH = 0.2f;
	public static final float PROJECTILE_B_HEIGHT = 0.2f;
	
	public ProjectileB(Vector2 position, Vector2 velocity, int damage) {
		this(position.x, position.y, PROJECTILE_B_WIDTH, PROJECTILE_B_HEIGHT);
		this.velocity = velocity;
		this.damagePoints = damage;
	}
	
	private ProjectileB(float x, float y, float width, float height) {
		super(x, y, width, height);
		speed = PROJECTILE_B_SPEED;
	}


}
