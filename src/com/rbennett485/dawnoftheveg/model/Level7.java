package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 *
 */
public class Level7 extends Level {
	public Level7() {
		super(800, Assets.level7background, Assets.level7backgroundRegion);
		number = 7;
		lives = 5;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(5.50f,0));
		result.add(new Vector2(8.08f,5.53f));
		result.add(new Vector2(20,5.53f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Grape(wayPoints), 10));
		result.add(new Wave(10, new Orange(wayPoints), 8));
		result.add(new Wave(13, new Chilli(wayPoints), 5));
		result.add(new Wave(18, new Pea(wayPoints), 3));
		result.add(new Wave(20, new Orange(wayPoints), 10));
		result.add(new Wave(27, new Grape(wayPoints), 10));
		result.add(new Wave(37, new Orange(wayPoints), 8));
		result.add(new Wave(40, new Chilli(wayPoints), 7));
		result.add(new Wave(45, new Pea(wayPoints), 5));
		
		return result;
	}
	
	@Override
	protected List<Vector2> towerPatchGenerator() {
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
