package com.rbennett485.dawnoftheveg.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.badlogic.androidgames.framework.FileIO;
import com.rbennett485.dawnoftheveg.Assets;
import com.rbennett485.dawnoftheveg.variables.Shop;

/**
 * Stores, securely saves and loads all measures of player progress in game
 * 
 * @author Bennett_Richard
 * 
 */
public class Progress {
	public final static int NUMBER_OF_LEVELS = 8;
	public final static int NUMBER_OF_OBJECTIVE_SETS = 4;
	public final static int NUMBER_OF_OBJECTIVES_PER_SET = 3;
	public final static int NUMBER_OF_TOWERS = 4;
	public static boolean[] level;
	public static boolean[][] objective;
	public static boolean[] shop;
	public static int currentObjectiveSet;
	public static int funds;
	public static boolean tower[];
	public static int kills;
	public static boolean helpVisited[];
	public static int towersBuilt;
	public static int dateLastObjectives[];
	public static boolean objectivesDateWritten;
	public static boolean objectivesFinished;
	private final static String file = ".dawnoftheveg";

	static {
		level = new boolean[NUMBER_OF_LEVELS];
		level[0] = true;
		objective = new boolean[NUMBER_OF_OBJECTIVE_SETS][NUMBER_OF_OBJECTIVES_PER_SET];
		shop = new boolean[Shop.NUMBER_OF_ITEMS];
		currentObjectiveSet = 0;
		funds = 0;
		tower = new boolean[NUMBER_OF_TOWERS];
		tower[0] = true;
		tower[1] = true;
		kills = 0;
		helpVisited = new boolean[Assets.NUMBER_OF_HELP_REGIONS];
		towersBuilt = 0;
		dateLastObjectives = new int[3];
		objectivesDateWritten = false;
		objectivesFinished = false;
	}

	/**
	 * Loads the progress data from file. If this fails (including if no
	 * progress file exists) then default values are used
	 * 
	 * @param files
	 *            The {@link FileIO} instance to use
	 */
	public static void load(FileIO files) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					files.readInternalFile(file)));
			for (int i = 0; i < NUMBER_OF_LEVELS; i++) {
				level[i] = Boolean.parseBoolean(in.readLine());
			}
			for (int i = 0; i < NUMBER_OF_OBJECTIVE_SETS; i++) {
				for (int j = 0; j < NUMBER_OF_OBJECTIVES_PER_SET; j++) {
					objective[i][j] = Boolean.parseBoolean(in.readLine());
				}
			}
			for (int i = 0; i < Shop.NUMBER_OF_ITEMS; i++) {
				shop[i] = Boolean.parseBoolean(in.readLine());
			}
			currentObjectiveSet = Integer.parseInt(in.readLine());
			funds = Integer.parseInt(in.readLine());
			for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
				tower[i] = Boolean.parseBoolean(in.readLine());
			}
			kills = Integer.parseInt(in.readLine());
			for (int i = 0; i < Assets.NUMBER_OF_HELP_REGIONS; i++) {
				helpVisited[i] = Boolean.parseBoolean(in.readLine());
			}
			towersBuilt = Integer.parseInt(in.readLine());
			for (int i = 0; i < 3; i++) {
				dateLastObjectives[i] = Integer.parseInt(in.readLine());
			}
			objectivesDateWritten = Boolean.parseBoolean(in.readLine());
			objectivesFinished = Boolean.parseBoolean(in.readLine());
		} catch (IOException ex) {
			// resort to initialisation defaults
		} catch (NumberFormatException ex) {
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * Saves the current values of all progress fields to internal storage.
	 * Takes no action if this fails for any reason
	 * 
	 * @param files
	 *            The {@link FileIO} instance to use
	 */
	public static void save(FileIO files) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeInternalFile(file)));
			for (int i = 0; i < NUMBER_OF_LEVELS; i++) {
				out.write(Boolean.toString(level[i]));
				out.write("\n");
			}
			for (int i = 0; i < NUMBER_OF_OBJECTIVE_SETS; i++) {
				for (int j = 0; j < NUMBER_OF_OBJECTIVES_PER_SET; j++) {
					out.write(Boolean.toString(objective[i][j]));
					out.write("\n");
				}
			}
			for (int i = 0; i < Shop.NUMBER_OF_ITEMS; i++) {
				out.write(Boolean.toString(shop[i]));
				out.write("\n");
			}
			out.write(Integer.toString(currentObjectiveSet));
			out.write("\n");
			out.write(Integer.toString(funds));
			out.write("\n");
			for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
				out.write(Boolean.toString(tower[i]));
				out.write("\n");
			}
			out.write(Integer.toString(kills));
			out.write("\n");
			for (int i = 0; i < Assets.NUMBER_OF_HELP_REGIONS; i++) {
				out.write(Boolean.toString(helpVisited[i]));
				out.write("\n");
			}
			out.write(Integer.toString(towersBuilt));
			out.write("\n");
			for (int i = 0; i < 3; i++) {
				out.write(Integer.toString(dateLastObjectives[i]));
				out.write("\n");
			}
			out.write(Boolean.toString(objectivesDateWritten));
			out.write("\n");
			out.write(Boolean.toString(objectivesFinished));
			out.write("\n");
		} catch (IOException ex) {
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException ex) {
			}
		}
	}
}
