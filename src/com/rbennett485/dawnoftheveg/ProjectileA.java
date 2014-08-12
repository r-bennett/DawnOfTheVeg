package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class ProjectileA extends Projectile {
	public static final int PROJECTILE_A_DAMAGE = 4;
	public static final float PROJECTILE_A_SPEED = 5f;
	public static final float PROJECTILE_A_WIDTH = 0.2f;
	public static final float PROJECTILE_A_HEIGHT = 0.2f;
	
	public ProjectileA(Vector2 position, Vector2 velocity) {
		this(position.x, position.y, PROJECTILE_A_WIDTH, PROJECTILE_A_HEIGHT);
		this.velocity = velocity;
	}
	
	private ProjectileA(float x, float y, float width, float height) {
		super(x, y, width, height);
		damagePoints = PROJECTILE_A_DAMAGE;
		speed = PROJECTILE_A_SPEED;
	}

}
