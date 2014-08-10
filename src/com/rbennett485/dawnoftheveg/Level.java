package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public abstract class Level {
	public final int INITIAL_MONEY;
	public final List<Vector2> wayPoints;
	public final List<Wave> waves;
	public final List<Vector2> towerPatches;
	
	public Level(int INITIAL_MONEY) {
		this.INITIAL_MONEY = INITIAL_MONEY;
		this.wayPoints = wayPointGenerator();
		this.waves = waveGenerator();
		this.towerPatches = towerPatchGenerator();
	}

	public abstract List<Vector2> wayPointGenerator();
	public abstract List<Wave> waveGenerator();
	public abstract List<Vector2> towerPatchGenerator();
}
