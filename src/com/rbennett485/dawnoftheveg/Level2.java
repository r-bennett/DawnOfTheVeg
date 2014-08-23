package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Level2 extends Level {
	public Level2() {
		super(1000, Assets.level2backgroundRegion);
		number = 2;
	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(3,0));
		result.add(new Vector2(3,3));
		result.add(new Vector2(5,6));
		result.add(new Vector2(15,6));
		result.add(new Vector2(20,5));
		return result;
	}

	@Override
	public List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 10));
		result.add(new Wave(10, new Banana(wayPoints), 8));
		result.add(new Wave(20, new Orange(wayPoints), 3));
		return result;
	}
	
	@Override
	public List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(4,1));
		result.add(new Vector2(3,4));
		result.add(new Vector2(13,5));
		result.add(new Vector2(14,7));
		
		return result;
	}
	
}
