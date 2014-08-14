package com.rbennett485.dawnoftheveg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.util.Log;

import com.badlogic.androidgames.framework.FileIO;

public class Settings {
	public static boolean soundEnabled = true;
	public final static String file = ".dawnoftheveg";

	public static void load(FileIO files) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(files.readExternalFile(file)));
			soundEnabled = Boolean.parseBoolean(in.readLine());
		} catch (IOException ex) {
			// resort to initialisation defaults
			Log.d("exception", "settings load failed - IOException");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				Log.d("exception", "BufferedReader failed to close - IOException");
			}
		}
	}
	
	public static void save(FileIO files) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(files.writeExternalFile(file)));
			out.write(Boolean.toString(soundEnabled));
			out.write("\n");
		} catch (IOException ex) {
			Log.d("exception", "settings save failed - IOException");
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
