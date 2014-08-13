package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class ProjectileC extends Projectile {
	public static final int PROJECTILE_C_DAMAGE = 4;
	public static final float PROJECTILE_C_SPEED = 5f;
	public static final float PROJECTILE_C_WIDTH = 0.2f;
	public static final float PROJECTILE_C_HEIGHT = 0.2f;
	
	public ProjectileC(Vector2 position, Vector2 velocity) {
		this(position.x, position.y, PROJECTILE_C_WIDTH, PROJECTILE_C_HEIGHT);
		this.velocity = velocity;
	}
	
	private ProjectileC(float x, float y, float width, float height) {
		super(x, y, width, height);
		damagePoints = PROJECTILE_C_DAMAGE;
		speed = PROJECTILE_C_SPEED;
	}


}
