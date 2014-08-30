package com.rbennett485.dawnoftheveg.model;

import java.util.List;

import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.math.Vector2;

/**
 * Stores the data which defines a level - the waypoints
 * for the enemies, the positions of the tower patches, and 
 * the waves of enemies
 * 
 * @author Bennett_Richard
 *
 */
public abstract class Level {
	public final int INITIAL_MONEY;
	public final List<Vector2> wayPoints;
	public final List<Wave> waves;
	public final List<Vector2> towerPatches;
	public final Texture background;
	public final TextureRegion backgroundRegion;
	public int number;
	public int lives;	
	
	/**
	 * Constructor - initialises members and calls all generator methods
	 * 
	 * @param INITIAL_MONEY - the sum of money at the start of the level
	 * @param background - the texture to which the level background belongs
	 * @param backgroundRegion - the texture region for the level background
	 */
	public Level(int INITIAL_MONEY, Texture background, TextureRegion backgroundRegion) {
		this.background = background;
		this.backgroundRegion= backgroundRegion;
		this.INITIAL_MONEY = INITIAL_MONEY;
		this.wayPoints = wayPointGenerator();
		this.waves = waveGenerator();
		this.towerPatches = towerPatchGenerator();
	}

	protected abstract List<Vector2> wayPointGenerator();
	protected abstract List<Wave> waveGenerator();
	protected abstract List<Vector2> towerPatchGenerator();
}
