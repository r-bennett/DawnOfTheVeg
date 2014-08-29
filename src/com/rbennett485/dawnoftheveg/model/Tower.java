package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.variables.Upgrades;

/**
 * Represents towers in the game's model
 * 
 * @author Bennett_Richard
 *
 */
public abstract class Tower extends GameObject {
	public float idleTime;
	public float reloadTime;
	public float range;
	public float damage;
	public List<Projectile> projectiles;

	/**
	 * Constructor
	 * 
	 * @param x x coord of tower's position (world coords)
	 * @param y y coord of tower's position (world coords)
	 * @param width width of tower
	 * @param height height of tower
	 */
	public Tower(float x, float y, float width, float height) {
		super(x, y, width, height);
		projectiles = new ArrayList<>();
	}
	
	/**
	 * @return cost to build tower
	 */
	public abstract int getCost();
	
	/**
	 * Updates the tower's idle time
	 * 
	 * @param deltaTime Seconds elapsed since last update
	 */
	@Override
	public void update(float deltaTime) {
		idleTime += deltaTime;
	}

	/**
	 * Creates a new projectile with the given velocity,the same initial position as the tower,
	 * and the damage and range as determined by the tower
	 * 
	 * @param projVel velocityof projectile
	 * @return the new {@link Projectile} instance
	 */
	public abstract Projectile newProj(Vector2 projVel);

	/**
	 * Increases tower's range by factor determined in {@link Upgrades}
	 */
	public void upgradeRange() {
		range *= Upgrades.RANGE_FACTOR;		
	}

	/**
	 * Increases tower's damage by factor determined in {@link Upgrades}
	 */
	public void upgradeDamage() {
		damage *= Upgrades.DAMAGE_FACTOR;
	}

	/**
	 * Decreases tower's reload time by factor determined in {@link Upgrades}
	 */
	public void upgradeReload() {
		reloadTime *= Upgrades.RELOAD_FACTOR;
	}

}
