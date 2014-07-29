package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class Wave {
	public int time;
	public DynamicGameObject seed;
	public int number;
	
	public Wave(int time, DynamicGameObject seed, int number) {
		this.time = time;
		this.seed = seed;
		this.number = number;
	}
	
	
}
