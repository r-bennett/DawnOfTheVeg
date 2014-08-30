package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 * 
 */
public class Level6 extends Level {
	public Level6() {
		super(200, Assets.level6background, Assets.level6backgroundRegion);
		number = 6;
		lives = 3;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0, 9.02f));
		result.add(new Vector2(7.08f, 8.90f));
		result.add(new Vector2(11.73f, 3.38f));
		result.add(new Vector2(20, 3.08f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Orange(wayPoints), 1));
		result.add(new Wave(5, new Orange(wayPoints), 1));
		result.add(new Wave(9, new Orange(wayPoints), 1));
		result.add(new Wave(13, new Orange(wayPoints), 1));
		result.add(new Wave(16, new Orange(wayPoints), 1));
		result.add(new Wave(19, new Orange(wayPoints), 1));
		result.add(new Wave(25, new Pea(wayPoints), 3));
		result.add(new Wave(29, new Pea(wayPoints), 5));
		result.add(new Wave(29, new Orange(wayPoints), 1));
		result.add(new Wave(40, new Chilli(wayPoints), 1));
		result.add(new Wave(42, new Pea(wayPoints), 4));
		result.add(new Wave(50, new Orange(wayPoints), 2));
		result.add(new Wave(55, new Chilli(wayPoints), 7));
		return result;
	}

	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(6.55f, 10.43f));
		result.add(new Vector2(5.58f, 7.58f));
		result.add(new Vector2(12.95f, 4.70f));
		result.add(new Vector2(11.95f, 1.98f));
		result.add(new Vector2(18.10f, 4.60f));
		result.add(new Vector2(11.08f, 7));
		result.add(new Vector2(18.7f, 1.8f));
		return result;
	}

}
