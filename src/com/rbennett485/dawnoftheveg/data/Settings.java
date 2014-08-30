package com.rbennett485.dawnoftheveg.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.badlogic.androidgames.framework.FileIO;

/**
 * Stores, saves and loads non-sensitive settings data
 * 
 * @author Bennett_Richard
 * 
 */
public class Settings {
	public static boolean soundEnabled = true;
	private final static String file = ".dawnoftheveg";

	/**
	 * Loads settings values from file. If this fails (including if no settings
	 * file exists) then default values are used
	 * 
	 * @param files
	 *            The {@link FileIO} instance to use
	 */
	public static void load(FileIO files) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					files.readExternalFile(file)));
			soundEnabled = Boolean.parseBoolean(in.readLine());
		} catch (IOException ex) {
			// resort to initialisation defaults
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
	 * Saves the settings to external storage. Takes no action if this fails for
	 * any reason
	 * 
	 * @param files
	 *            The {@link FileIO} instance to use
	 */
	public static void save(FileIO files) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeExternalFile(file)));
			out.write(Boolean.toString(soundEnabled));
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
