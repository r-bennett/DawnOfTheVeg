package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;


public class TowerA extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_A_WIDTH = 1f;
	public static final float TOWER_A_HEIGHT = 1f;
	public static final int TOWER_A_COST = 100;
	public static final float TOWER_A_RANGE = 3f;
	public static final float TOWER_A_DAMAGE = 5f;

	public TowerA(float x, float y) {
		this(x, y, TOWER_A_WIDTH, TOWER_A_HEIGHT);
	}

	private TowerA(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_A_RANGE;
		reloadTime = RELOAD_TIME;
		damage = TOWER_A_DAMAGE;
	}

	@Override
	int getCost() {
		return TOWER_A_COST;
	}

	@Override
	public Projectile newProj(Vector2 projVel) {
		return new ProjectileA(this.position, projVel);
	}

}
