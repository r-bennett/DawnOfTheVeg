package com.rbennett485.dawnoftheveg;

public class ProjectileA extends Projectile {
	public static final int PROJECTILE_A_DAMAGE = 4;
	
	public ProjectileA(float x, float y, float width, float height) {
		super(x, y, width, height);
		damagePoints = PROJECTILE_A_DAMAGE;
	}

}
