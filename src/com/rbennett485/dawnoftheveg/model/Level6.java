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
		super(1000, Assets.level6background, Assets.level6backgroundRegion);
		number = 6;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(0,9.02f));
		result.add(new Vector2(7.08f,8.90f));
		result.add(new Vector2(11.73f,3.38f));
		result.add(new Vector2(20,3.08f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 10));
		result.add(new Wave(10, new Chilli(wayPoints), 8));
		result.add(new Wave(20, new Orange(wayPoints), 3));
		return result;
	}
	
	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(6.55f,10.43f));
		result.add(new Vector2(5.58f,7.58f));
		result.add(new Vector2(12.95f,4.70f));
		result.add(new Vector2(11.95f,1.98f));
		result.add(new Vector2(18.10f,4.60f));
		return result;
	}
	

}
