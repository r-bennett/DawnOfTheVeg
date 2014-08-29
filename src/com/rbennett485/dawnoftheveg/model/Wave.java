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
	
	/**
	 * Constructor
	 * 
	 * @param time Time in seconds into the game at which the wave should appear
	 * @param seed An enemy which will be cloned to create all enemies in the wave
	 * @param number The number of enemies which will be in the wave
	 */
	public Wave(int time, Enemy seed, int number) {
		this.time = time;
		this.seed = seed;
		this.number = number;
	}
	
	
}
