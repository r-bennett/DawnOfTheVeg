package com.rbennett485.dawnoftheveg.model;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 * 
 */
public class Grape extends Enemy {
	public static final float GRAPE_WIDTH = 0.39f;
	public static final float GRAPE_HEIGHT = 0.6f;
	public static final float GRAPE_VELOCITY = 1.8f;
	public static final int GRAPE_HP = 15;
	private final List<Vector2> wayPoints;
	private int nextWayPoint;

	/**
	 * Constructor
	 * 
	 * @param wayPoints
	 *            An ordered list of the points the enemy will move between,
	 *            given in World coordinates. The enemy will be initialised at
	 *            the first of these points
	 */
	public Grape(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x, wayPoints.get(0).y, wayPoints);
	}

	private Grape(float x, float y, List<Vector2> wayPoints) {
		super(x, y, GRAPE_WIDTH, GRAPE_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = GRAPE_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the enemy at waypoint 0, have it head to
							// waypoint 1
		this.region = Assets.grape;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rbennett485.dawnoftheveg.model.Enemy#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		if (nextWayPoint < wayPoints.size()) {
			if (position.dist(wayPoints.get(nextWayPoint)) < 0.1) {
				nextWayPoint++;
				if (nextWayPoint < wayPoints.size()) {
					velocity.set(wayPoints.get(nextWayPoint).cpy()
							.sub(this.position).nor().mul(GRAPE_VELOCITY));
				}
			}

		}

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(GRAPE_WIDTH / 2, GRAPE_HEIGHT / 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rbennett485.dawnoftheveg.model.Enemy#clone()
	 */
	@Override
	public Grape clone() {
		return new Grape(this.position.x, this.position.y, this.wayPoints);
	}

}
