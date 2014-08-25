package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.Music;
import com.badlogic.androidgames.framework.Sound;
import com.badlogic.androidgames.framework.gl.Font;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGame;

public class Assets {
	public static Texture sprites;
	public static TextureRegion patch;
	public static TextureRegion towerA;
	public static TextureRegion towerB;
	public static TextureRegion towerC;
	public static TextureRegion towerD;
	public static TextureRegion projectileA;
	public static TextureRegion projectileB;
	public static TextureRegion projectileC;
	public static TextureRegion projectileD;
	public static TextureRegion healthBarRed;
	public static TextureRegion healthBarGreen;
	public static TextureRegion orange;
	public static TextureRegion grape;
	public static TextureRegion chilli;
	public static TextureRegion pea;
	public static TextureRegion back;
	public static TextureRegion help;
	public static TextureRegion menu;
	public static TextureRegion objectives;
	public static TextureRegion pauseMenu;
	public static TextureRegion rightArrow;
	public static TextureRegion soundOff;
	public static TextureRegion soundOn;
	public static TextureRegion title;
	public static TextureRegion shop;
	public static TextureRegion callWave;
	public static TextureRegion complete;
	public static TextureRegion gameOver;
	public static TextureRegion buy;
	public static TextureRegion bought;
	public static TextureRegion tickBox;
	public static TextureRegion tick;
	
	public static Font font;
	
	public static Texture background;
	public static TextureRegion backgroundRegion;
	
	public static Texture level1background;
	public static TextureRegion level1backgroundRegion;
	public static Texture level2background;
	public static TextureRegion level2backgroundRegion;
	public static Texture level3background;
	public static TextureRegion level3backgroundRegion;
	public static Texture level4background;
	public static TextureRegion level4backgroundRegion;

	public static Texture helpImage;
	public static TextureRegion[] helpRegion;
	public static int NUMBER_OF_HELP_REGIONS = 2;
	
	public static Music music;
	
	public static Sound clickSound;
	
	public static void load(GLGame game) {
		
		sprites = new Texture(game, "spritesheet.png");
		patch = new TextureRegion(sprites, 336, 0, 40, 40);
		towerA = new TextureRegion(sprites, 871, 0, 50, 81);
		towerB = new TextureRegion(sprites, 930, 90, 80, 61);
		towerC = new TextureRegion(sprites, 811, 0, 54, 80);
		towerD = new TextureRegion(sprites, 929, 0, 76, 80);
		projectileA = new TextureRegion(sprites, 782, 2, 22, 10);
		projectileB = new TextureRegion(sprites, 783, 37, 4, 4);
		projectileC = new TextureRegion(sprites, 783, 18, 19, 4);
		projectileD = new TextureRegion(sprites, 783, 26, 17, 5);
		healthBarRed = new TextureRegion(sprites, 281, 0, 32, 3);
		healthBarGreen = new TextureRegion(sprites, 281, 5, 32, 3);
		orange = new TextureRegion(sprites, 559, 160, 80, 88);
		grape = new TextureRegion(sprites, 650, 164, 52, 81);
		chilli = new TextureRegion(sprites, 715, 164, 56, 81);
		pea = new TextureRegion(sprites, 472, 168, 80, 80);
		back = new TextureRegion(sprites, 180, 1, 80, 80);
		help = new TextureRegion(sprites, 145, 0, 35, 80);
		menu = new TextureRegion(sprites, 255, 304, 290, 240);
		objectives = new TextureRegion(sprites, 254, 469, 291, 74);
		pauseMenu = new TextureRegion(sprites, 0, 703, 313, 304);
		rightArrow = new TextureRegion(sprites, 0, 81, 60, 200);
		soundOff = new TextureRegion(sprites, 54, 0, 50, 80);
		soundOn = new TextureRegion(sprites, 54, 0, 90, 80);
		title = new TextureRegion(sprites, 60, 82, 375, 224);
		shop = new TextureRegion(sprites, 306, 386, 171, 71);
		callWave = new TextureRegion(sprites, 376, 1, 80, 80);
		complete = new TextureRegion(sprites, 486, 81, 291, 73);
		gameOver = new TextureRegion(sprites, 486, 1, 291, 82);
		buy = new TextureRegion(sprites, 1, 631, 291, 72);
		bought = new TextureRegion(sprites, 0, 559, 291, 72);
		tickBox = new TextureRegion(sprites, 456, 0, 30, 30);
		tick = new TextureRegion(sprites, 456, 30, 25, 23);
		
		font = new Font(sprites, 1, 307, 16, 16, 32);
				
		level1background = new Texture(game, "level_1_background.png");
		level1backgroundRegion = new TextureRegion(level1background, 0, 0, 800, 480);
		level2background = new Texture(game, "level_2_background.png");
		level2backgroundRegion = new TextureRegion(level2background, 0, 0, 800, 480);
		level3background = new Texture(game, "level_3_background.png");
		level3backgroundRegion = new TextureRegion(level3background, 0, 0, 800, 480);
		level4background = new Texture(game, "level_4_background.png");
		level4backgroundRegion = new TextureRegion(level4background, 0, 0, 800, 480);
		
		background = new Texture(game,"background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 4, 4);
				
		helpImage = new Texture(game, "help.png");
		helpRegion =  new TextureRegion[NUMBER_OF_HELP_REGIONS];
		helpRegion[0] =  new TextureRegion(helpImage, 0, 0, 560, 320);
		helpRegion[1] = new TextureRegion(helpImage, 560, 0, 560, 320);
		
		music = game.getAudio().newMusic("music.mp3");
		music.setLooping(true);
		music.setVolume(0.5f);
		if(Settings.soundEnabled)
				music.play();
		clickSound = game.getAudio().newSound("click.ogg");
	}
	
	public static void reload() {
		background.reload();
		level1background.reload();
		level2background.reload();
		level3background.reload();
		level4background.reload();
		sprites.reload();		
		
		if(Settings.soundEnabled)
			music.play();
	}
	
	public static void playSound(Sound sound) {
		if(Settings.soundEnabled)
			sound.play(1);
	}
}
