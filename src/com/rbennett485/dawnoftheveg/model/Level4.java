package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 * 
 */
public class Level4 extends Level {
	public Level4() {
		super(700, Assets.level4background, Assets.level4backgroundRegion);
		number = 4;
		lives = 1;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0, 6.23f));
		result.add(new Vector2(20, 6.23f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 3));
		result.add(new Wave(7, new Orange(wayPoints), 2));
		result.add(new Wave(18, new Grape(wayPoints), 3));
		result.add(new Wave(20, new Orange(wayPoints), 5));
		result.add(new Wave(40, new Pea(wayPoints), 5));
		result.add(new Wave(46, new Orange(wayPoints), 4));
		result.add(new Wave(52, new Orange(wayPoints), 4));
		result.add(new Wave(65, new Chilli(wayPoints), 20));

		return result;
	}

	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(1.25f, 8.33f));
		result.add(new Vector2(4.63f, 8.33f));
		result.add(new Vector2(8.25f, 8.33f));
		result.add(new Vector2(11.93f, 8.33f));
		result.add(new Vector2(15.38f, 8.33f));
		result.add(new Vector2(18.95f, 8.33f));
		result.add(new Vector2(3.63f, 5));
		result.add(new Vector2(7.25f, 5));
		result.add(new Vector2(10.93f, 5));
		result.add(new Vector2(14.38f, 5));
		result.add(new Vector2(18.13f, 5));
		return result;
	}

}
