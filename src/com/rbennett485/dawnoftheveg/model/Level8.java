package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 * 
 */
public class Level8 extends Level {
	public Level8() {
		super(500, Assets.level8background, Assets.level8backgroundRegion);
		number = 8;
		lives = 1;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0, 10.43f));
		result.add(new Vector2(15.6f, 10.43f));
		result.add(new Vector2(17.85f, 6.43f));
		result.add(new Vector2(12.68f, 6.43f));
		result.add(new Vector2(11.85f, 7.8f));
		result.add(new Vector2(6.83f, 7.88f));
		result.add(new Vector2(7.53f, 6.28f));
		result.add(new Vector2(2, 6.3f));
		result.add(new Vector2(4.48f, 2.33f));
		result.add(new Vector2(20, 2.13f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 5));
		result.add(new Wave(10, new Orange(wayPoints), 4));
		result.add(new Wave(20, new Orange(wayPoints), 7));
		result.add(new Wave(24, new Orange(wayPoints), 3));
		result.add(new Wave(26, new Chilli(wayPoints), 8));
		result.add(new Wave(30, new Orange(wayPoints), 8));
		result.add(new Wave(35, new Grape(wayPoints), 8));
		result.add(new Wave(40, new Pea(wayPoints), 15));
		result.add(new Wave(50, new Orange(wayPoints), 7));
		result.add(new Wave(59, new Orange(wayPoints), 3));
		result.add(new Wave(61, new Chilli(wayPoints), 9));
		result.add(new Wave(65, new Pea(wayPoints), 14));
		result.add(new Wave(85, new Chilli(wayPoints), 20));
		result.add(new Wave(90, new Orange(wayPoints), 10));
		result.add(new Wave(95, new Grape(wayPoints), 10));
		result.add(new Wave(100, new Pea(wayPoints), 20));
		return result;
	}

	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0.83f, 9.1f));
		result.add(new Vector2(4.83f, 7.88f));
		result.add(new Vector2(14.43f, 9.1f));
		result.add(new Vector2(18.08f, 9.1f));
		result.add(new Vector2(13.93f, 7.75f));
		result.add(new Vector2(0.68f, 5));
		result.add(new Vector2(8.3f, 5));
		result.add(new Vector2(13.23f, 5));
		result.add(new Vector2(18.5f, 4.85f));
		result.add(new Vector2(2.2f, 2.68f));
		result.add(new Vector2(5.38f, 3.68f));
		result.add(new Vector2(11.15f, 3.68f));
		result.add(new Vector2(16.55f, 3.68f));
		return result;
	}
}
