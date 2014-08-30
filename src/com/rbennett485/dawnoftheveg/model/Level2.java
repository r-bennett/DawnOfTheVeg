package com.rbennett485.dawnoftheveg.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.badlogic.androidgames.framework.math.Vector2;
import com.rbennett485.dawnoftheveg.Assets;

/**
 * @author Bennett_Richard
 *
 */
public class Level2 extends Level {
	public Level2() {
		super(450, Assets.level2background, Assets.level2backgroundRegion);
		number = 2;
		lives = 5;
	}

	@Override
	protected List<Vector2> wayPointGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(5.7f,0));
		result.add(new Vector2(2.63f,4.2f));
		result.add(new Vector2(17.2f,4.28f));
		result.add(new Vector2(20,0.95f));
		return result;
	}

	@Override
	protected List<Wave> waveGenerator() {
		List<Wave> result = new ArrayList<>();
		result.add(new Wave(0, new Pea(wayPoints), 7));
		result.add(new Wave(10, new Chilli(wayPoints), 8));
		result.add(new Wave(30, new Orange(wayPoints), 7));
		result.add(new Wave(40, new Pea(wayPoints), 3));
		return result;
	}
	
	@Override
	protected List<Vector2> towerPatchGenerator() {
		List<Vector2> result = new ArrayList<>();
		result.add(new Vector2(1.93f,5.73f));
		result.add(new Vector2(5.8f,2.77f));
		result.add(new Vector2(10.73f,2.75f));
		result.add(new Vector2(16.7f,2.75f));
		result.add(new Vector2(16.35f,5.73f));
		result.add(new Vector2(19.25f,4.18f));
		
		return result;
	}
	
}
