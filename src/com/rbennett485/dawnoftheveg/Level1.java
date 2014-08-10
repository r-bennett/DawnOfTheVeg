package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

class Level1 extends Level {
	public Level1() {
		super(1000);
	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,6));
		result.add(new Vector2(10,3));
		result.add(new Vector2(15,11));
		result.add(new Vector2(20,6));
		return result;
	}

	@Override
	public List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Orange(wayPoints), 1));
		result.add(new Wave(5, new Orange(wayPoints), 3));
		result.add(new Wave(10, new Orange(wayPoints), 3));
		return result;
	}
	
	@Override
	public List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(5,3));
		return result;
	}
	
}
