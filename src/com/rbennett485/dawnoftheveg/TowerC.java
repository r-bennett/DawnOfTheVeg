package com.rbennett485.dawnoftheveg;

public class TowerC extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_C_WIDTH = 1f;
	public static final float TOWER_C_HEIGHT = 1f;
	public static final int TOWER_C_COST = 150;
	public static final float TOWER_C_RANGE = 3f;

	public TowerC(float x, float y) {
		this(x, y, TOWER_C_WIDTH, TOWER_C_HEIGHT);
	}

	private TowerC(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_C_RANGE;
		reloadTime = RELOAD_TIME;
	}

	@Override
	int getCost() {
		return TOWER_C_COST;
	}

}
