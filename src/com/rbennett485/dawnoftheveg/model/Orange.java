package com.rbennett485.dawnoftheveg.model;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 *
 */
public class Orange extends Enemy {
	public static final float ORANGE_WIDTH = 1f;
	public static final float ORANGE_HEIGHT = 1.1f;
	public static final float ORANGE_VELOCITY = 1.4f;
	public static final int ORANGE_HP = 20;
	private final List<Vector2> wayPoints;
	private int nextWayPoint;

	/**
	 * Constructor
	 * 
	 * @param wayPoints	An ordered list of the points the enemy will move between, 
	 * given in World coordinates. The enemy will be initialised at the first of these points 
	 */
	public Orange(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x,wayPoints.get(0).y, wayPoints);
	}

	private Orange(float x, float y, List<Vector2> wayPoints) {
		super(x, y, ORANGE_WIDTH, ORANGE_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = ORANGE_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the orange at waypoint 0, have it head to waypoint 1
		this.region = Assets.orange;
	}

	/* (non-Javadoc)
	 * @see com.rbennett485.dawnoftheveg.model.Enemy#update(float)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.rbennett485.dawnoftheveg.model.Enemy#clone()
	 */
	@Override
	public Orange clone() {
		return new Orange(this.position.x, this.position.y, this.wayPoints);
	}

}
