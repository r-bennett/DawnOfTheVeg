package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.DynamicGameObject;
import com.badlogic.androidgames.framework.math.Vector2;

public class Grape extends DynamicGameObject {
	public static final float GRAPE_WIDTH = 1f;
	public static final float GRAPE_HEIGHT = 1f;
	public static final float GRAPE_VELOCITY = 2f;
	public static final int GRAPE_HP = 10;
	public final List<Vector2> wayPoints;
	public int nextWayPoint;
	
	public Grape(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x,wayPoints.get(0).y, wayPoints);
	}

	public Grape(float x, float y, List<Vector2> wayPoints) {
		super(x, y, GRAPE_WIDTH, GRAPE_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = GRAPE_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the enemy at waypoint 0, have it head to waypoint 1
	}

	public void update(float deltaTime) {
		if(nextWayPoint<wayPoints.size()) {
			if(position.dist(wayPoints.get(nextWayPoint))<0.1) {
				nextWayPoint++;
				if(nextWayPoint<wayPoints.size()) {
					velocity.set(wayPoints.get(nextWayPoint).cpy().sub(this.position).nor().mul(GRAPE_VELOCITY));
				}
			}
			
		} 

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(GRAPE_WIDTH / 2, GRAPE_HEIGHT / 2);
	}

	@Override
	public Grape clone() {
		return new Grape(this.position.x, this.position.y, this.wayPoints);
	}

}