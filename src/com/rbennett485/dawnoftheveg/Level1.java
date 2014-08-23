package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.badlogic.androidgames.framework.math.Vector2;

public class Level1 extends Level {
	public Level1() {
		super(1000, Assets.level1background, Assets.level1backgroundRegion);
		number = 1;
		Log.d("background", "making level 1");

	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,9.02f));
		result.add(new Vector2(7.08f,8.90f));
		result.add(new Vector2(11.73f,3.38f));
		result.add(new Vector2(20,3.08f));
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
		result.add(new Vector2(5.75f,7.45f));
		result.add(new Vector2(12.35f,1.93f));
		result.add(new Vector2(16.78f,4.68f));
		
		return result;
	}
	
}
