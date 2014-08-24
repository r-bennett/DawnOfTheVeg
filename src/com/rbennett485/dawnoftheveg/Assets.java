package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.Music;
import com.badlogic.androidgames.framework.Sound;
import com.badlogic.androidgames.framework.gl.Font;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGame;

public class Assets {
	public static Texture towerImage;
	public static TextureRegion patch;
	public static TextureRegion towerA;
	public static TextureRegion towerB;
	public static TextureRegion towerC;
	public static TextureRegion towerD;
	public static TextureRegion projectileA;
	public static TextureRegion projectileB;
	public static TextureRegion projectileC;
	public static TextureRegion projectileD;
	
	public static Texture healthBars;
	public static TextureRegion healthBarRed;
	public static TextureRegion healthBarGreen;
	
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
	
	public static Texture characters;
	public static TextureRegion orange;
	public static TextureRegion grape;
	public static TextureRegion banana;
	
	public static Texture icons;
	public static TextureRegion back;
	public static TextureRegion help;
	public static TextureRegion menu;
	public static TextureRegion objectives;
	public static TextureRegion pauseMenu;
	public static TextureRegion rightArrow;
	public static TextureRegion soundOff;
	public static TextureRegion soundOn;
	public static TextureRegion tip;
	public static TextureRegion title;
	public static TextureRegion shop;
	public static TextureRegion callWave;
	public static TextureRegion towerMenu;
	public static TextureRegion complete;
	public static TextureRegion gameOver;
	public static TextureRegion buy;
	public static TextureRegion bought;
	public static TextureRegion tickBox;
	public static TextureRegion tick;
	
	public static Texture fontImage;
	public static Font font;
	
	public static Texture helpImage;
	public static TextureRegion[] helpRegion;
	public static int NUMBER_OF_HELP_REGIONS = 2;
	
	public static Music music;
	
	public static Sound clickSound;
	
	public static void load(GLGame game) {
		towerImage = new Texture(game, "towerImage.png");
		patch = new TextureRegion(towerImage, 0, 0, 40, 40);
		towerA = new TextureRegion(towerImage, 40, 0, 40, 40);
		towerB = new TextureRegion(towerImage, 80, 0, 40, 40);
		towerC = new TextureRegion(towerImage, 0, 40, 40, 40);
		towerD = new TextureRegion(towerImage, 40, 40, 40, 40);
		projectileA = new TextureRegion(towerImage, 80, 0, 40, 40);
		projectileB = new TextureRegion(towerImage, 40, 0, 40, 40);
		projectileC = new TextureRegion(towerImage, 80, 0, 40, 40);
		projectileD = new TextureRegion(towerImage, 0, 40, 40, 40);
		
		healthBars = new Texture(game, "healthBars.png");
		healthBarRed = new TextureRegion(healthBars, 0, 0, 32, 3);
		healthBarGreen = new TextureRegion(healthBars, 0, 5, 32, 3);
		
		level1background = new Texture(game, "level_1_background.png");
		level1backgroundRegion = new TextureRegion(level1background, 0, 0, 800, 480);
		level2background = new Texture(game, "level_2_background.png");
		level2backgroundRegion = new TextureRegion(level2background, 0, 0, 800, 480);
		level3background = new Texture(game, "level_3_background.png");
		level3backgroundRegion = new TextureRegion(level3background, 0, 0, 800, 480);
		level4background = new Texture(game, "level_4_background.png");
		level4backgroundRegion = new TextureRegion(level4background, 0, 0, 800, 480);
		
		background = new Texture(game,"background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 800, 480);
		
		characters = new Texture(game, "characters.png");
		orange = new TextureRegion(characters, 0, 0, 40, 40);
		grape = new TextureRegion(characters, 40, 0, 40, 40);
		banana = new TextureRegion(characters, 80, 0, 40, 40);
		
		icons = new Texture(game, "icons.png");
		back = new TextureRegion(icons, 0, 180, 40, 40);
		help = new TextureRegion(icons, 68, 143, 40, 40);
		menu = new TextureRegion(icons, 132, 42, 60, 89);
		objectives = new TextureRegion(icons, 0, 143, 68, 37);
		pauseMenu = new TextureRegion(icons, 0, 42, 132, 101);
		rightArrow = new TextureRegion(icons, 192, 39, 40, 40);
		soundOff = new TextureRegion(icons, 40, 183, 40, 40);
		soundOn = new TextureRegion(icons, 108, 143, 40, 40);
		tip = new TextureRegion(icons, 179, 0, 42, 39);
		title = new TextureRegion(icons, 0, 0, 179, 42);
		shop = new TextureRegion(icons, 130, 73, 47, 30);
		callWave = new TextureRegion(icons, 88, 195, 40, 40);
		towerMenu = new TextureRegion(icons, 160, 160, 80, 80);
		complete = new TextureRegion(icons, 240, 0, 240, 120);
		gameOver = new TextureRegion(icons, 257, 125, 240, 120);
		buy = new TextureRegion(icons, 0, 260, 150, 50);
		bought = new TextureRegion(icons, 0, 320, 150, 50);
		tickBox = new TextureRegion(icons, 170, 260, 40, 40);
		tick = new TextureRegion(icons, 170, 320, 40, 40);
		
		characters = new Texture(game, "characters.png");
		orange = new TextureRegion(characters, 0, 0, 40, 40);
		
		fontImage = new Texture(game, "font2.png");
		font = new Font(fontImage, 0, 0, 16, 16, 32);
		
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
		towerImage.reload();
		healthBars.reload();
		background.reload();
		icons.reload();
		fontImage.reload();
		characters.reload();
		level1background.reload();
		level2background.reload();
		level3background.reload();
		level4background.reload();
		
		
		if(Settings.soundEnabled)
			music.play();
	}
	
	public static void playSound(Sound sound) {
		if(Settings.soundEnabled)
			sound.play(1);
	}
}
