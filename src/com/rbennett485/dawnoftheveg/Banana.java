package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Banana extends Enemy {
	public static final float BANANA_WIDTH = 1f;
	public static final float BANANA_HEIGHT = 1f;
	public static final float BANANA_VELOCITY = 2f;
	public static final int BANANA_HP = 20;
	public final List<Vector2> wayPoints;
	public int nextWayPoint;

	public  Banana(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x,wayPoints.get(0).y, wayPoints);
	}

	public  Banana(float x, float y, List<Vector2> wayPoints) {
		super(x, y, BANANA_WIDTH, BANANA_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = BANANA_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the banana at waypoint 0, have it head to waypoint 1
	}

	public void update(float deltaTime) {
		if(nextWayPoint<wayPoints.size()) {
			if(position.dist(wayPoints.get(nextWayPoint))<0.1) {
				nextWayPoint++;
				if(nextWayPoint<wayPoints.size()) {
					velocity.set(wayPoints.get(nextWayPoint).cpy().sub(this.position).nor().mul(BANANA_VELOCITY));
				}
			}

		} 

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(BANANA_WIDTH / 2, BANANA_HEIGHT / 2);
	}

	@Override
	public  Banana clone() {
		return new  Banana(this.position.x, this.position.y, this.wayPoints);
	}

}
