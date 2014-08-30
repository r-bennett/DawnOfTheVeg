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
		super(400, Assets.level5background, Assets.level5backgroundRegion);
		number = 5;
		lives = 1;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0, 8.58f));
		result.add(new Vector2(14.05f, 8.58f));
		result.add(new Vector2(15.58f, 6.2f));
		result.add(new Vector2(3.25f, 5.85f));
		result.add(new Vector2(5.38f, 2.65f));
		result.add(new Vector2(20, 2.65f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Orange(wayPoints), 3));
		result.add(new Wave(10, new Orange(wayPoints), 4));
		result.add(new Wave(20, new Orange(wayPoints), 3));
		result.add(new Wave(33, new Grape(wayPoints), 5));
		result.add(new Wave(38, new Chilli(wayPoints), 3));
		result.add(new Wave(55, new Orange(wayPoints), 10));
		return result;
	}

	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0.85f, 7.28f));
		result.add(new Vector2(5.73f, 10.20f));
		result.add(new Vector2(12.05f, 10.20f));
		result.add(new Vector2(16.58f, 7.78f));
		result.add(new Vector2(6.58f, 4.25f));
		result.add(new Vector2(13.58f, 1.03f));
		result.add(new Vector2(12.3f, 4.3f));
		return result;
	}

}
