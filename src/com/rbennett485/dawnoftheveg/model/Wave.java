package com.rbennett485.dawnoftheveg.model;


/**
 * Stores the data for a wave of enemies
 * 
 * @author Bennett_Richard
 *
 */
public class Wave {
	public int time;
	public Enemy seed;
	public int number;
	
	public Wave(int time, Enemy seed, int number) {
		this.time = time;
		this.seed = seed;
		this.number = number;
	}
	
	
}
