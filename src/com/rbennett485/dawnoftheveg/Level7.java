package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;

public class Level7 extends Level {
	public Level7() {
		super(1000, Assets.level7background, Assets.level7backgroundRegion);
		number = 7;
	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(5.50f,0));
		result.add(new Vector2(8.08f,5.53f));
		result.add(new Vector2(20,5.53f));
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
		result.add(new Vector2(8.18f,7.08f));
		result.add(new Vector2(9.5f,7.08f));
		result.add(new Vector2(10.83f,7.08f));
		result.add(new Vector2(12.03f,7.08f));
		result.add(new Vector2(13.35f,7.08f));
		result.add(new Vector2(14.68f,7.08f));
		result.add(new Vector2(15.95f,7.08f));
		result.add(new Vector2(17.28f,7.08f));
		result.add(new Vector2(18.6f,7.08f));
		return result;
	}
	

}
