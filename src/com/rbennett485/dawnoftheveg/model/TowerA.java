package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 * 
 */
public class TowerA extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_A_WIDTH = 0.625f;
	public static final float TOWER_A_HEIGHT = 1f;
	public static final int TOWER_A_COST = 100;
	public static final float TOWER_A_RANGE = 2.5f;
	public static final float TOWER_A_DAMAGE = 2f;

	public TowerA(float x, float y) {
		this(x, y, TOWER_A_WIDTH, TOWER_A_HEIGHT);
	}

	private TowerA(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_A_RANGE;
		reloadTime = RELOAD_TIME;
		damage = TOWER_A_DAMAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rbennett485.dawnoftheveg.model.Tower#getCost()
	 */
	@Override
	public int getCost() {
		return TOWER_A_COST;
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
		return new ProjectileA(this.position, projVel, (int) damage, range);
	}

}
