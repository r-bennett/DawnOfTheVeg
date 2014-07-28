package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class Orange extends DynamicGameObject {
	public static final float ORANGE_WIDTH = 1f;
	public static final float ORANGE_HEIGHT = 1f;
	public static final float ORANGE_VELOCITY = 2f;
	
	public Orange(float x, float y) {
		super(x, y, ORANGE_WIDTH, ORANGE_HEIGHT);
		velocity.set(ORANGE_VELOCITY,0); //probably going to need to change this....
	}
	
	public void update(float deltaTime) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        bounds.lowerLeft.set(position).sub(ORANGE_WIDTH / 2, ORANGE_HEIGHT / 2);
	}

}