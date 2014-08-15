package com.rbennett485.dawnoftheveg;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.GLGame;

public class DawnOfTheVeg extends GLGame {
	boolean firstTimeCreate = true;

	@Override
	public Screen getStartScreen() {
		return new TitleScreen(this);
	}
	
	@Override 
	public void onSurfaceCreated(GL10 gl, EGLConfig config){
		super.onSurfaceCreated(gl, config);
		if(firstTimeCreate) {
			Settings.load(getFileIO());
			Progress.load(getFileIO());
			Log.d("progress", Progress.level[0] + ", " + Progress.level[1]);
			Assets.load(this);
			firstTimeCreate = false;
		} else {
			Assets.reload();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if(Settings.soundEnabled)
			Assets.music.pause();
		Progress.save(getFileIO());
	}
}
