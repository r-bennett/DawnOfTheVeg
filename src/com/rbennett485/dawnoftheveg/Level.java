package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.math.Vector2;

public abstract class Level {
	public final int INITIAL_MONEY;
	public final List<Vector2> wayPoints;
	public final List<Wave> waves;
	public final List<Vector2> towerPatches;
	public final Texture background;
	public final TextureRegion backgroundRegion;
	public int number;
	
	public Level(int INITIAL_MONEY, Texture background, TextureRegion backgroundRegion) {
		this.background = background;
		this.backgroundRegion= backgroundRegion;
		this.INITIAL_MONEY = INITIAL_MONEY;
		this.wayPoints = wayPointGenerator();
		this.waves = waveGenerator();
		this.towerPatches = towerPatchGenerator();
	}

	public abstract List<Vector2> wayPointGenerator();
	public abstract List<Wave> waveGenerator();
	public abstract List<Vector2> towerPatchGenerator();
}
