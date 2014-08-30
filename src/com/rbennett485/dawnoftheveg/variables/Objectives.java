package com.rbennett485.dawnoftheveg.variables;

import android.util.Log;

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

		objectives[1][0][0] = "Constructor";
		objectives[1][0][1] = "Build 30 towers";
		objectives[1][1][0] = "Double Centurion";
		objectives[1][1][1] = "Destroy 200 enemies";
		objectives[1][2][0] = "Scholar";
		objectives[1][2][1] = "Visit all the help pages";
	}

	public static void level1Complete() {
		Progress.objective[0][0]  = true;		
	}

	public static void enemyKilled() {
		Progress.kills++;
		if(Progress.kills >= 200)
			Progress.objective[1][1] = true;
		else if(Progress.kills >= 50)
			Progress.objective[0][1] = true;
	}

	public static void helpPageVisited(int page) {
		if(Progress.objective[1][2])
			return;
		if(page == 0)
			Progress.objective[0][2] = true;
		Progress.helpVisited[page] = true;
		for(boolean b : Progress.helpVisited)
			if(!b)
				return;
		Progress.objective[1][2] = true;			
	}
	
	public static void builtTower() {
		Progress.towersBuilt++;
		if(Progress.towersBuilt >= 30)
			Progress.objective[1][0] = true;
	}
}
