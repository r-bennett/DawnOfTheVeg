package com.rbennett485.dawnoftheveg.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Banana;
import com.rbennett485.dawnoftheveg.Enemy;
import com.rbennett485.dawnoftheveg.Grape;
import com.rbennett485.dawnoftheveg.Orange;

public class EnemyTest {
	private Enemy orange;
	private Enemy banana;
	private Enemy grape;
	private List<Vector2> waypoints;
	

	@Before
	public void buildUp() {
		waypoints = new ArrayList<>();
		waypoints.add(new Vector2(0,10));
		waypoints.add(new Vector2(2,12));
		orange = new Orange(waypoints);
		banana = new Banana(waypoints);
		grape = new Grape(waypoints);
	}
	
	@Test
	public void testClone() {
		Enemy orangeClone = orange.clone();
		assertEquals(orange.position.x, orangeClone.position.x, 0.0001);
		assertEquals(orange.position.y, orangeClone.position.y, 0.0001);
		assertEquals(orange.bounds.height, orangeClone.bounds.height, 0.0001);
		assertEquals(orange.bounds.width, orangeClone.bounds.width, 0.0001);
		assertEquals(orange.bounds.lowerLeft.x, orangeClone.bounds.lowerLeft.x, 0.0001);
		assertEquals(orange.bounds.lowerLeft.y, orangeClone.bounds.lowerLeft.y, 0.0001);
	}

}
