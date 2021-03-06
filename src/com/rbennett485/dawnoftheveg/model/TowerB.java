package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 * 
 */
public class TowerB extends Tower {
	public static final float RELOAD_TIME = 1f;
	public static final float TOWER_B_WIDTH = 1f;
	public static final float TOWER_B_HEIGHT = 0.75f;
	public static final int TOWER_B_COST = 120;
	public static final float TOWER_B_RANGE = 3.5f;
	public static final float TOWER_B_DAMAGE = 3f;

	public TowerB(float x, float y) {
		this(x, y, TOWER_B_WIDTH, TOWER_B_HEIGHT);
	}

	private TowerB(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_B_RANGE;
		reloadTime = RELOAD_TIME;
		damage = TOWER_B_DAMAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rbennett485.dawnoftheveg.model.Tower#getCost()
	 */
	@Override
	public int getCost() {
		return TOWER_B_COST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rbennett485.dawnoftheveg.model.Tower#newProj(com.badlogic.androidgames
	 * .framework.math.Vector2)
	 */
	@Override
	public Projectile newProj(Vector2 projVel) {
		return new ProjectileB(this.position, projVel, (int) damage, range);
	}
}
