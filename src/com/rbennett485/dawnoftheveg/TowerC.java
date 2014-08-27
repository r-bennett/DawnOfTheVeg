package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class TowerC extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_C_WIDTH = 1f;
	public static final float TOWER_C_HEIGHT = 1f;
	public static final int TOWER_C_COST = 140;
	public static final float TOWER_C_RANGE = 3f;
	public static final float TOWER_C_DAMAGE = 10;

	public TowerC(float x, float y) {
		this(x, y, TOWER_C_WIDTH, TOWER_C_HEIGHT);
	}

	private TowerC(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_C_RANGE;
		reloadTime = RELOAD_TIME;
		damage = TOWER_C_DAMAGE;
	}

	@Override
	int getCost() {
		return TOWER_C_COST;
	}

	@Override
	public Projectile newProj(Vector2 projVel) {
		return new ProjectileC(this.position, projVel);
	}

}
