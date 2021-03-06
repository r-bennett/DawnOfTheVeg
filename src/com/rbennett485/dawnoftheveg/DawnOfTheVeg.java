package com.rbennett485.dawnoftheveg;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.GLGame;
import com.google.analytics.tracking.android.EasyTracker;
import com.rbennett485.dawnoftheveg.data.Progress;
import com.rbennett485.dawnoftheveg.data.Settings;

/**
 * The main activity for the app
 * 
 * @author Bennett_Richard
 * 
 */
public class DawnOfTheVeg extends GLGame {
	private boolean firstTimeCreate = true;

	/**
	 * Sets the start screen to a new {@link TitleScreen}
	 */
	@Override
	public Screen getStartScreen() {
		return new TitleScreen(this);
	}

	/**
	 * Loads {@link Settings}, {@link Progress} and {@link Assets} if this is a
	 * first time load. Otherwise, calls {@link Assets#reload()}
	 */
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		if (firstTimeCreate) {
			Settings.load(getFileIO());
			Progress.load(getFileIO());
			Assets.load(this);
			firstTimeCreate = false;
		} else {
			Assets.reload();
		}
	}

	/**
	 * Pauses music if sound is enabled, and calls
	 * {@link Progress#save(com.badlogic.androidgames.framework.FileIO)
	 * Progress.save()}
	 */
	@Override
	public void onPause() {
		super.onPause();
		if (Settings.soundEnabled)
			Assets.music.pause();
		Progress.save(getFileIO());
		Settings.save(getFileIO());
	}

	@Override
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this); // Add this method.
	}

	@Override
	public void onStop() {
		super.onStop();
		EasyTracker.getInstance(this).activityStop(this); // Add this method.
	}
}
