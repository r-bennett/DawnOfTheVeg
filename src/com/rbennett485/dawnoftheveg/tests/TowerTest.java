package com.rbennett485.dawnoftheveg.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.model.Projectile;
import com.rbennett485.dawnoftheveg.model.Tower;
import com.rbennett485.dawnoftheveg.model.TowerA;
import com.rbennett485.dawnoftheveg.model.TowerB;
import com.rbennett485.dawnoftheveg.model.TowerC;
import com.rbennett485.dawnoftheveg.model.TowerD;

public class TowerTest {

	private Tower towerA;
	private Tower towerB;
	private Tower towerC;
	private Tower towerD;

	@Before
	public void buildUp() {
		towerA = new TowerA(2, 4);
		towerB = new TowerB(2, 4);
		towerC = new TowerC(2, 4);
		towerD = new TowerD(2, 4);
	}

	@Test
	public void updateTest() {
		updateTestHelper(towerA);
		updateTestHelper(towerB);
		updateTestHelper(towerC);
		updateTestHelper(towerD);
	}

	private void updateTestHelper(Tower tower) {
		tower.update(1);
		assertEquals(tower.idleTime, 1f, 0.0001);
	}

	@Test
	public void newProjTest() {
		newProjTestHelper(towerA);
		newProjTestHelper(towerB);
		newProjTestHelper(towerC);
		newProjTestHelper(towerD);
	}

	private void newProjTestHelper(Tower tower) {
		Projectile proj = tower.newProj(new Vector2(1, 2));
		assertEquals(proj.position.x, tower.position.x, 0.0001);
		assertEquals(proj.position.y, tower.position.y, 0.0001);

	}

}
