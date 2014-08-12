package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class Projectile extends DynamicGameObject {

	public int damagePoints;
	public float speed;

	public Projectile(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float deltaTime) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        bounds.lowerLeft.set(position).sub(bounds.width / 2, bounds.height / 2);
	}

}
