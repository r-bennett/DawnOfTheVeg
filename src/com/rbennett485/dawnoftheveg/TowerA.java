package com.rbennett485.dawnoftheveg;


public class TowerA extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_A_WIDTH = 1f;
	public static final float TOWER_A_HEIGHT = 1f;
	public static final int TOWER_A_COST = 100;

	public TowerA(float x, float y) {
		this(x, y, TOWER_A_WIDTH, TOWER_A_HEIGHT);
	}

	private TowerA(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	int getCost() {
		return TOWER_A_COST;
	}

	@Override
	public void update(float deltaTime) {
		idleTime += deltaTime;
	}

}
