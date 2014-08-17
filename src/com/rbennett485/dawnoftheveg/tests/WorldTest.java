package com.rbennett485.dawnoftheveg.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.rbennett485.dawnoftheveg.Level;
import com.rbennett485.dawnoftheveg.Level1;
import com.rbennett485.dawnoftheveg.World;
import com.rbennett485.dawnoftheveg.World.WorldListener;

public class WorldTest {
	private World world;
	private WorldListener worldListener;
	private Level level;

	
	@Before
	public void buildUp() {
		level = new Level1();
		worldListener = new WorldListener() {

			@Override
			public void shot() {
				// TODO Auto-generated method stub
			}

			@Override
			public void splat() {
				// TODO Auto-generated method stub
			}

		};
		world = new World(worldListener, level);
	}
	
	@Test
	public void updateTest() {
		fail("Not yet implemented");
	}

}
