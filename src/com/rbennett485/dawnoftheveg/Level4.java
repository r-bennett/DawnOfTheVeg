package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Level4 extends Level {
	public Level4() {
		super(1000, Assets.level4background, Assets.level4backgroundRegion);
		number = 4;
	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,6.23f));
		result.add(new Vector2(20,6.23f));
		return result;
	}

	@Override
	public List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 10));
		result.add(new Wave(10, new Chilli(wayPoints), 8));
		result.add(new Wave(20, new Orange(wayPoints), 3));
		return result;
	}
	
	@Override
	public List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(1.75f,8.63f));
		result.add(new Vector2(5.13f,8.63f));
		result.add(new Vector2(8.75f,8.63f));
		result.add(new Vector2(12.43f,8.63f));
		result.add(new Vector2(15.88f,8.63f));
		result.add(new Vector2(19.45f,8.63f));
		result.add(new Vector2(4.13f,5.33f));
		result.add(new Vector2(7.75f,5.33f));
		result.add(new Vector2(11.43f,5.33f));
		result.add(new Vector2(14.88f,5.33f));
		result.add(new Vector2(18.63f,5.33f));
		return result;
	}
	

}
