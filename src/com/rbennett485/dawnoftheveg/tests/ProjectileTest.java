package com.rbennett485.dawnoftheveg.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Projectile;
import com.rbennett485.dawnoftheveg.ProjectileA;
import com.rbennett485.dawnoftheveg.ProjectileB;
import com.rbennett485.dawnoftheveg.ProjectileC;
import com.rbennett485.dawnoftheveg.ProjectileD;

public class ProjectileTest {
	
	private Projectile projA;
	private Projectile projB;
	private Projectile projC;
	private Projectile projD;
	
	@Before
	public void buildUp() {
		projA = new ProjectileA(new Vector2(0,0), new Vector2(2,1));
		projB = new ProjectileB(new Vector2(0,0), new Vector2(2,1));
		projC = new ProjectileC(new Vector2(0,0), new Vector2(2,1));
		projD = new ProjectileD(new Vector2(0,0), new Vector2(2,1));
	}

	@Test
	public void testUpdate() {
		testUpdateHelper(projA);
		testUpdateHelper(projB);
		testUpdateHelper(projC);
		testUpdateHelper(projD);
	}
	
	public void  testUpdateHelper(Projectile proj) {
		float originalX = proj.position.x;
		float originalY = proj.position.y;
		proj.update(1);
		assertEquals(proj.position.x, (originalX + proj.velocity.x), 0.0001);
		assertEquals(proj.position.y, (originalY + proj.velocity.y), 0.0001);
	}

}
