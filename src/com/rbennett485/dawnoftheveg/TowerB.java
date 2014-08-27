package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.math.Vector2;

public class TowerB extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_B_WIDTH = 1f;
	public static final float TOWER_B_HEIGHT = 1f;
	public static final int TOWER_B_COST = 120;
	public static final float TOWER_B_RANGE = 3f;
	public static final float TOWER_B_DAMAGE = 7f;
	
	public TowerB(float x, float y) {
		this(x, y, TOWER_B_WIDTH, TOWER_B_HEIGHT);
	}
	
	private TowerB(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_B_RANGE;
		reloadTime = RELOAD_TIME;
		damage = TOWER_B_DAMAGE;
	}

	@Override
	int getCost() {
		return TOWER_B_COST;
	}

	@Override
	public Projectile newProj(Vector2 projVel) {
		return new ProjectileB(this.position, projVel);
	}
}
