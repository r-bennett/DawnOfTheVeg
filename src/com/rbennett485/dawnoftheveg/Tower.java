package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.GameObject;

public abstract class Tower extends GameObject {
	public float idleTime;
	public float reloadTime;
	public float range;
	public List<Projectile> projectiles;

	public Tower(float x, float y, float width, float height) {
		super(x, y, width, height);
		projectiles = new ArrayList<>();
	}
	
	abstract int getCost();

}
