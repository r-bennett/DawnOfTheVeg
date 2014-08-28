package com.rbennett485.dawnoftheveg;

import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

/**
 * @author Bennett_Richard
 *
 */
public class Chilli extends Enemy {
	public static final float CHILLI_WIDTH = 0.7f;
	public static final float CHILLI_HEIGHT = 1f;
	public static final float CHILLI_VELOCITY = 2f;
	public static final int CHILLI_HP = 10;
	public final List<Vector2> wayPoints;
	public int nextWayPoint;

	/**
	 * Constructor
	 * 
	 * @param wayPoints	An ordered list of the points the enemy will move between, 
	 * given in World coordinates. The enemy will be initialised at the first of these points 
	 */
	public  Chilli(List<Vector2> wayPoints) {
		this(wayPoints.get(0).x,wayPoints.get(0).y, wayPoints);
	}


	private Chilli(float x, float y, List<Vector2> wayPoints) {
		super(x, y, CHILLI_WIDTH, CHILLI_HEIGHT);
		this.wayPoints = wayPoints;
		initialHp = CHILLI_HP;
		hp = initialHp;
		nextWayPoint = 0; // create the banana at waypoint 0, have it head to waypoint 1
		this.region = Assets.chilli;
	}

	/**
	 * Updates the enemy's position and bounds, and advances the enemy
	 * to the next waypoint if it is within 0.1 units of its current waypoint
	 * 
	 * @param deltaTime	The time in seconds since the method was last called
	 */
	@Override
	public void update(float deltaTime) {
		if(nextWayPoint<wayPoints.size()) {
			if(position.dist(wayPoints.get(nextWayPoint))<0.1) {
				nextWayPoint++;
				if(nextWayPoint<wayPoints.size()) {
					velocity.set(wayPoints.get(nextWayPoint).cpy().sub(this.position).nor().mul(CHILLI_VELOCITY));
				}
			}

		} 

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(CHILLI_WIDTH / 2, CHILLI_HEIGHT / 2);
	}

	/* (non-Javadoc)
	 * @see com.rbennett485.dawnoftheveg.Enemy#clone()
	 */
	@Override
	public  Chilli clone() {
		return new  Chilli(this.position.x, this.position.y, this.wayPoints);
	}

}
