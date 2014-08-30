package com.badlogic.androidgames.framework.math;

public class Rectangle {
	public final Vector2 lowerLeft;
	public float width, height;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * 
	 *            (x,y) coordinate gives lower-left corner of rectangle
	 */
	public Rectangle(float x, float y, float width, float height) {
		this.lowerLeft = new Vector2(x, y);
		this.width = width;
		this.height = height;
	}
}
