package com.badlogic.androidgames.framework.math;

public class Circle {
	public final Vector2 center = new Vector2();
	public float radius;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 * 
	 *            (x,y) coordinate gives centre of circle
	 */
	public Circle(float x, float y, float radius) {
		this.center.set(x, y);
		this.radius = radius;
	}
}
