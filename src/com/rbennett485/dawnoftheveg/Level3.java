package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Level3 extends Level {
	public Level3() {
		super(1000, Assets.level3background, Assets.level3backgroundRegion);
		number = 3;

	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,10));
		result.add(new Vector2(17,10));
		result.add(new Vector2(17,7));
		result.add(new Vector2(3,7));
		result.add(new Vector2(3,3));
		result.add(new Vector2(20,3));
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
		result.add(new Vector2(9,11));
		result.add(new Vector2(3,9));
		result.add(new Vector2(16,10));
		result.add(new Vector2(3,1));
		result.add(new Vector2(5,4));
		result.add(new Vector2(16,3));
		return result;
	}
	

}
