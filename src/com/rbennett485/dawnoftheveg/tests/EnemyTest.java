package com.rbennett485.dawnoftheveg.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.model.Chilli;
import com.rbennett485.dawnoftheveg.model.Enemy;
import com.rbennett485.dawnoftheveg.model.Grape;
import com.rbennett485.dawnoftheveg.model.Orange;
import com.rbennett485.dawnoftheveg.model.Projectile;
import com.rbennett485.dawnoftheveg.model.ProjectileA;
import com.rbennett485.dawnoftheveg.model.TowerA;

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
		banana = new Chilli(waypoints);
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
	
	@Test
	public void testHit() {
		testHitHelper(orange);
	}
	
	public void testHitHelper(Enemy enemy) {
		int hp = enemy.hp;
		Projectile projA = new ProjectileA(new Vector2(0,0), new Vector2(1,1), (int)TowerA.TOWER_A_DAMAGE, TowerA.TOWER_A_RANGE);
		enemy.hit(projA);
		assertEquals(enemy.hp, hp-(int)TowerA.TOWER_A_DAMAGE<0 ?
				0 : hp-(int)TowerA.TOWER_A_DAMAGE);
		enemy.hp = 4;
		enemy.hit(projA);
		assertEquals(enemy.hp, 0);
		enemy.hit(projA);
		assertEquals(enemy.hp, 0);
	}

	
	@Test
	public void testUpdate() {
		testUpdateHelper(orange);
		testUpdateHelper(grape);
		testUpdateHelper(banana);
	}
	
	public void testUpdateHelper(Enemy enemy) {
		enemy.update(1);
		assertEquals(enemy.velocity.x*1,enemy.position.x, 0.0001);
		assertEquals(10 + enemy.velocity.y*1,enemy.position.y, 0.0001);
	}
}
