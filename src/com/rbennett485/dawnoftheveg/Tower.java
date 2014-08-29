package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.GameObject;
import com.badlogic.androidgames.framework.math.Vector2;

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

	public Tower(float x, float y, float width, float height) {
		super(x, y, width, height);
		projectiles = new ArrayList<>();
	}
	
	abstract int getCost();
	
	@Override
	public void update(float deltaTime) {
		idleTime += deltaTime;
	}

	public abstract Projectile newProj(Vector2 projVel);

	public void upgradeRange() {
		range *= Upgrades.RANGE_FACTOR;		
	}

	public void upgradeDamage() {
		damage *= Upgrades.DAMAGE_FACTOR;
	}

	public void upgradeReload() {
		reloadTime *= Upgrades.RELOAD_FACTOR;
	}

}
