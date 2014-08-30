package com.rbennett485.dawnoftheveg.model;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 * 
 */
public class TowerD extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_D_WIDTH = 0.95f;
	public static final float TOWER_D_HEIGHT = 1f;
	public static final int TOWER_D_COST = 200;
	public static final float TOWER_D_RANGE = 2.5f;
	public static final float TOWER_D_DAMAGE = 5;

	public TowerD(float x, float y) {
		this(x, y, TOWER_D_WIDTH, TOWER_D_HEIGHT);
	}

	private TowerD(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_D_RANGE;
		reloadTime = RELOAD_TIME;
		damage = TOWER_D_DAMAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rbennett485.dawnoftheveg.model.Tower#getCost()
	 */
	@Override
	public int getCost() {
		return TOWER_D_COST;
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
		return new ProjectileD(this.position, projVel, (int) damage, range);
	}

}
