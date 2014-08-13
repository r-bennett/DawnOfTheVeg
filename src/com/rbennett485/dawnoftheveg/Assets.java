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
	
	public static Texture fontImage;
	public static Font font;
	
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
		projectileC = new TextureRegion(towerImage, 40, 40, 40, 40);
		projectileD = new TextureRegion(towerImage, 0, 40, 40, 40);
		
		healthBars = new Texture(game, "healthBars.png");
		healthBarRed = new TextureRegion(healthBars, 0, 0, 32, 3);
		healthBarGreen = new TextureRegion(healthBars, 0, 5, 32, 3);
		
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
		
		characters = new Texture(game, "characters.png");
		orange = new TextureRegion(characters, 0, 0, 40, 40);
		
		fontImage = new Texture(game, "font2.png");
		font = new Font(fontImage, 0, 0, 16, 16, 32);
		
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
		
		if(Settings.soundEnabled)
			music.play();
	}
	
	public static void playSound(Sound sound) {
		if(Settings.soundEnabled)
			sound.play(1);
	}
}
