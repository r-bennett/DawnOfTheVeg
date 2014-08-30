package com.rbennett485.dawnoftheveg.variables;

import com.rbennett485.dawnoftheveg.data.Progress;

/**
 * Stores objectives and their titles as strings
 * 
 * @author Bennett_Richard
 *
 */
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

	public static void level1Complete() {
		Progress.objective[0][0]  = true;		
	}
	
	public static void enemyKilled() {
		Progress.kills++;
		if(Progress.kills >= 50)
			Progress.objective[0][1] = true;
	}
	
	
	
	

}
