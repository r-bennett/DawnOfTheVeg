package com.rbennett485.dawnoftheveg;

public class TowerB extends Tower {
	public static final float RELOAD_TIME = 0.5f;
	public static final float TOWER_B_WIDTH = 1f;
	public static final float TOWER_B_HEIGHT = 1f;
	
	public TowerB(float x, float y) {
		this(x, y, TOWER_B_WIDTH, TOWER_B_HEIGHT);
	}
	
	private TowerB(float x, float y, float width, float height) {
		super(x, y, width, height);
	}


}
