package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 *
 */
public class Level5 extends Level {
	public Level5() {
		super(1000, Assets.level5background, Assets.level5backgroundRegion);
		number = 5;
	}

	@Override
	public List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,8.58f));
		result.add(new Vector2(14.05f,8.58f));
		result.add(new Vector2(15.58f,6.2f));
		result.add(new Vector2(3.25f,5.85f));
		result.add(new Vector2(5.38f,2.65f));
		result.add(new Vector2(20,2.65f));
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
		result.add(new Vector2(0.85f,7.28f));
		result.add(new Vector2(5.73f,10.20f));
		result.add(new Vector2(12.05f,10.20f));
		result.add(new Vector2(16.58f,7.78f));
		result.add(new Vector2(6.58f,4.25f));
		result.add(new Vector2(13.58f,1.03f));
		return result;
	}
	

}
