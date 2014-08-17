package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Level1 extends Level {
	public Level1() {
		super(1000);
		number = 1;
	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,10));
		result.add(new Vector2(8,10));
		result.add(new Vector2(8,2));
		result.add(new Vector2(20,2));
		return result;
	}

	@Override
	public List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Orange(wayPoints), 10));
		result.add(new Wave(10, new Banana(wayPoints), 8));
		result.add(new Wave(20, new Grape(wayPoints), 3));
		return result;
	}
	
	@Override
	public List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(7,9));
		result.add(new Vector2(9,1));
		result.add(new Vector2(16,3));
		
		return result;
	}
	
}
