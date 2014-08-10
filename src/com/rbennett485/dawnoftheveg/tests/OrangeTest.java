package com.rbennett485.dawnoftheveg.tests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.rbennett485.dawnoftheveg.Orange;

public class OrangeTest extends TestCase {
	public Orange orange;
	
	@Before
	public void setUp() {
		orange = new Orange(2,4,null);
	}
	
	@Test
	public void testCreate() {
		assertEquals(2,orange.position.x,0.00001);
		assertEquals(4,orange.position.y,0.00001);
	}
	
	@Test
	public void testUpdate() {
		orange.update(1);
		assertEquals(2+orange.velocity.x*1,orange.position.x,0.00001);
		assertEquals(4+orange.velocity.y*1,orange.position.y,0.00001);
	}
}
