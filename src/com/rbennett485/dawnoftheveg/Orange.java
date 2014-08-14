package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Orange extends Enemy {
	public static final float ORANGE_WIDTH = 1f;
	public static final float ORANGE_HEIGHT = 1f;
	public static final float ORANGE_VELOCITY = 2f;
	public static final int ORANGE_HP = 20;
	public final List<Vector2> wayPoints;
	public int nextWayPoint;

	public Orange(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x,wayPoints.get(0).y, wayPoints);
	}

	public Orange(float x, float y, List<Vector2> wayPoints) {
		super(x, y, ORANGE_WIDTH, ORANGE_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = ORANGE_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the orange at waypoint 0, have it head to waypoint 1
	}

	public void update(float deltaTime) {
		if(nextWayPoint<wayPoints.size()) {
			if(position.dist(wayPoints.get(nextWayPoint))<0.1) {
				nextWayPoint++;
				if(nextWayPoint<wayPoints.size()) {
					velocity.set(wayPoints.get(nextWayPoint).cpy().sub(this.position).nor().mul(ORANGE_VELOCITY));
				}
			}

		} 

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(ORANGE_WIDTH / 2, ORANGE_HEIGHT / 2);
	}

	@Override
	public Orange clone() {
		return new Orange(this.position.x, this.position.y, this.wayPoints);
	}

}
