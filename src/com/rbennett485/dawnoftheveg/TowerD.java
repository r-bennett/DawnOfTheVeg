package com.rbennett485.dawnoftheveg;

public class TowerD extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_D_WIDTH = 1f;
	public static final float TOWER_D_HEIGHT = 1f;
	public static final int TOWER_D_COST = 200;
	public static final float TOWER_D_RANGE = 3f;
	
	public TowerD(float x, float y) {
		this(x, y, TOWER_D_WIDTH, TOWER_D_HEIGHT);
	}
	
	private TowerD(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.range = TOWER_D_RANGE;
		reloadTime = RELOAD_TIME;
	}

	@Override
	int getCost() {
		return TOWER_D_COST;
	}

}
