package com.rbennett485.dawnoftheveg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.util.Log;

import com.badlogic.androidgames.framework.FileIO;

public class Progress {
	public final static int NUMBER_OF_LEVELS = 2;
	public final static int NUMBER_OF_OBJECTIVE_SETS = 4;
	public final static int NUMBER_OF_OBJECTIVES_PER_SET = 3;
	public final static int NUMBER_OF_SHOP_ITEMS = 1;
	public static boolean[] level;
	public static boolean[][] objective;
	public static boolean[] shop;
	public final static String file = ".dawnoftheveg";

	static {
		level = new boolean[NUMBER_OF_LEVELS];
		level[0] = true;
		objective = new boolean[NUMBER_OF_OBJECTIVE_SETS][NUMBER_OF_OBJECTIVES_PER_SET];
		shop = new boolean[NUMBER_OF_SHOP_ITEMS];
	}

	public static void load(FileIO files) {
		Log.d("progress", "load");
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(files.readInternalFile(file)));
			for(int i=0 ; i<NUMBER_OF_LEVELS ; i++) {
				level[i] = Boolean.parseBoolean(in.readLine());
			}
			for(int i=0 ; i<NUMBER_OF_OBJECTIVE_SETS ; i++) {
				for(int j=0 ; j<NUMBER_OF_OBJECTIVES_PER_SET ; j++) {
					objective[i][j] = Boolean.parseBoolean(in.readLine());
				}
			}
			for(int i=0 ; i<NUMBER_OF_SHOP_ITEMS ; i++) {
				shop[i] = Boolean.parseBoolean(in.readLine());
			}
		} catch (IOException ex) {
			// resort to initialisation defaults
			Log.d("exception", "level progress load failed - IOException");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				Log.d("exception", "BufferedReader failed to close - IOException");
			}
		}
		Log.d("progress", level[0]+"");
	}

	public static void save(FileIO files) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(files.writeInternalFile(file)));
			for(int i=0 ; i<NUMBER_OF_LEVELS ; i++) {
				out.write(Boolean.toString(level[i]));
				out.write("\n");
			}
		} catch (IOException ex) {
			Log.d("exception", "level progress save failed - IOException");
		} finally {
			try {
				if(out!=null) 
					out.close();
			} catch(IOException ex) {
				Log.d("exception", "BufferedWriter failed to close - IOException");
			}
		}
	}
}
