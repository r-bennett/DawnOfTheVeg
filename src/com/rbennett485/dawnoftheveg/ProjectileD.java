package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class ProjectileD extends Projectile {
	public static final int PROJECTILE_D_DAMAGE = 4;
	public static final float PROJECTILE_D_SPEED = 5f;
	public static final float PROJECTILE_D_WIDTH = 0.2f;
	public static final float PROJECTILE_D_HEIGHT = 0.2f;
	
	public ProjectileD(Vector2 position, Vector2 velocity) {
		this(position.x, position.y, PROJECTILE_D_WIDTH, PROJECTILE_D_HEIGHT);
		this.velocity = velocity;
	}
	
	private ProjectileD(float x, float y, float width, float height) {
		super(x, y, width, height);
		damagePoints = PROJECTILE_D_DAMAGE;
		speed = PROJECTILE_D_SPEED;
	}


}
