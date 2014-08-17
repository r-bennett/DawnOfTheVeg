package com.rbennett485.dawnoftheveg;

public class Objectives {
	
	public static final String[][][] objectives;
	public static final int NUMBER_OF_OBJECTIVE_SETS;
	
	static {
		NUMBER_OF_OBJECTIVE_SETS = 2;
		objectives = new String[NUMBER_OF_OBJECTIVE_SETS][3][2];
		objectives[0][0][0] = "Newbie";
		objectives[0][0][1] = "Complete your first level";
		objectives[0][1][0] = "The big five-o";
		objectives[0][1][1] = "Destroy 50 enemies";
		objectives[0][2][0] = "Help!";
		objectives[0][2][1] = "Visit the help page";
		
		//change these..
		objectives[1][0][0] = "Newbie";
		objectives[1][0][1] = "Complete your first level";
		objectives[1][1][0] = "The big five-o";
		objectives[1][1][1] = "Destroy 50 enemies";
		objectives[1][2][0] = "Help!";
		objectives[1][2][1] = "Visit the help page";
		
	}
	
	

}
