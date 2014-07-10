package com.badlogic.androidgames.dawnoftheveg;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.GLGame;

public class DawnOfTheVeg extends GLGame {
	boolean firstTimeCreate = true;

	@Override
	public Screen getStartScreen() {
		return new TitleScreen(this);
	}
	
	
}
