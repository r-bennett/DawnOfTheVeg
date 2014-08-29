package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 *
 */
public class Level3 extends Level {
	public Level3() {
		super(1000, Assets.level3background, Assets.level3backgroundRegion);
		number = 3;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,2.6f));
		result.add(new Vector2(8.5f,2.6f));
		result.add(new Vector2(5.1f,6.4f));
		result.add(new Vector2(12.85f,6.4f));
		result.add(new Vector2(16.25f,2.6f));
		result.add(new Vector2(20,2.6f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 10));
		result.add(new Wave(10, new Chilli(wayPoints), 8));
		result.add(new Wave(20, new Orange(wayPoints), 3));
		return result;
	}
	
	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(4.15f,5.5f));
		result.add(new Vector2(9.5f,0.85f));
		result.add(new Vector2(8.75f,5.03f));
		result.add(new Vector2(14.85f,2.05f));
		result.add(new Vector2(15.25f,6.5f));
		return result;
	}
	

}
