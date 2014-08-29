package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 *
 */
public class Pea extends Enemy {

	public static final float PEA_WIDTH = 0.33f;
	public static final float PEA_HEIGHT = 0.33f;
	public static final float PEA_VELOCITY = 2f;
	public static final int PEA_HP = 20;
	public final List<Vector2> wayPoints;
	public int nextWayPoint;

	public Pea(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x,wayPoints.get(0).y, wayPoints);
	}

	private Pea(float x, float y, List<Vector2> wayPoints) {
		super(x, y, PEA_WIDTH, PEA_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = PEA_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the enemy at waypoint 0, have it head to waypoint 1
		this.region = Assets.pea;
	}

	public void update(float deltaTime) {
		if(nextWayPoint<wayPoints.size()) {
			if(position.dist(wayPoints.get(nextWayPoint))<0.1) {
				nextWayPoint++;
				if(nextWayPoint<wayPoints.size()) {
					velocity.set(wayPoints.get(nextWayPoint).cpy().sub(this.position).nor().mul(PEA_VELOCITY));
				}
			}

		} 

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(PEA_WIDTH / 2, PEA_HEIGHT / 2);
	}

	@Override
	public Pea clone() {
		return new Pea(this.position.x, this.position.y, this.wayPoints);
	}

}
