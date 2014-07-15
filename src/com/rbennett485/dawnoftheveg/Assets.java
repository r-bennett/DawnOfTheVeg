package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.Music;
import com.badlogic.androidgames.framework.Sound;
import com.badlogic.androidgames.framework.gl.Font;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGame;

public class Assets {
	public static Texture background;
	public static TextureRegion backgroundRegion;
	
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
	
	public static Texture fontImage;
	public static Font font;
	
	public static Music music;
	
	public static Sound clickSound;
	
	public static void load(GLGame game) {
		background = new Texture(game,"background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 800, 480);
		
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
		
		fontImage = new Texture(game, "font.bmp");
		font = new Font(icons, 0, 0, 0, 32, 32);
		
		music = game.getAudio().newMusic("music.mp3");
		music.setLooping(true);
		music.setVolume(0.5f);
		if(Settings.soundEnabled)
				music.play();
		clickSound = game.getAudio().newSound("click.ogg");
	}
	
	public static void reload() {
		background.reload();
		icons.reload();
		if(Settings.soundEnabled)
			music.play();
	}
	
	public static void playSound(Sound sound) {
		if(Settings.soundEnabled)
			sound.play(1);
	}
}
