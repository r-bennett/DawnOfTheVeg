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
	public static TextureRegion towerMenu;
	public static TextureRegion cross;
	public static TextureRegion hazard;
	public static TextureRegion pause;
	public static TextureRegion upgradeMenu;
	public static TextureRegion redCross;

	public static Font font;

	public static Texture background;
	public static TextureRegion backgroundRegion;

	public static Texture map;
	public static TextureRegion mapRegion;

	public static Texture level1background;
	public static TextureRegion level1backgroundRegion;
	public static Texture level2background;
	public static TextureRegion level2backgroundRegion;
	public static Texture level3background;
	public static TextureRegion level3backgroundRegion;
	public static Texture level4background;
	public static TextureRegion level4backgroundRegion;
	public static Texture level5background;
	public static TextureRegion level5backgroundRegion;
	public static Texture level6background;
	public static TextureRegion level6backgroundRegion;
	public static Texture level7background;
	public static TextureRegion level7backgroundRegion;
	public static Texture level8background;
	public static TextureRegion level8backgroundRegion;

	public static Texture helpImage;
	public static TextureRegion[] helpRegion;
	public static int NUMBER_OF_HELP_REGIONS = 2;

	public static Texture[] story;
	public static TextureRegion[] storyRegion;
	public static int NUMBER_OF_STORY_REGIONS = 12;

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
		menu = new TextureRegion(sprites, 255, 311, 290, 240);
		objectives = new TextureRegion(sprites, 254, 476, 291, 74);
		pauseMenu = new TextureRegion(sprites, 0, 703, 313, 304);
		rightArrow = new TextureRegion(sprites, 0, 81, 60, 200);
		soundOff = new TextureRegion(sprites, 54, 0, 50, 80);
		soundOn = new TextureRegion(sprites, 54, 0, 90, 80);
		title = new TextureRegion(sprites, 60, 82, 375, 224);
		shop = new TextureRegion(sprites, 306, 393, 171, 71);
		callWave = new TextureRegion(sprites, 376, 1, 80, 80);
		complete = new TextureRegion(sprites, 486, 81, 291, 73);
		gameOver = new TextureRegion(sprites, 486, 1, 291, 76);
		buy = new TextureRegion(sprites, 1, 631, 291, 72);
		bought = new TextureRegion(sprites, 0, 559, 291, 72);
		tickBox = new TextureRegion(sprites, 456, 0, 30, 30);
		tick = new TextureRegion(sprites, 456, 30, 25, 23);
		cross = new TextureRegion(sprites, 835, 94, 36, 32);
		hazard = new TextureRegion(sprites, 881, 90, 45, 40);
		pause = new TextureRegion(sprites, 0, 0, 53, 80);
		towerMenu = new TextureRegion(sprites, 293, 559, 120, 120);
		upgradeMenu = new TextureRegion(sprites, 413, 559, 120, 120);
		redCross = new TextureRegion(sprites, 788, 91, 36, 32);


		font = new Font(sprites, 1, 307, 16, 16, 32);

		map =  new Texture(game, "map.png");
		mapRegion = new TextureRegion(map, 0, 0, 800, 480);

		level1background = new Texture(game, "level_1_background.png");
		level1backgroundRegion = new TextureRegion(level1background, 0, 0, 800, 480);
		level2background = new Texture(game, "level_2_background.png");
		level2backgroundRegion = new TextureRegion(level2background, 0, 0, 800, 480);
		level3background = new Texture(game, "level_3_background.png");
		level3backgroundRegion = new TextureRegion(level3background, 0, 0, 800, 480);
		level4background = new Texture(game, "level_4_background.png");
		level4backgroundRegion = new TextureRegion(level4background, 0, 0, 800, 480);
		level5background = new Texture(game, "level_5_background.png");
		level5backgroundRegion = new TextureRegion(level5background, 0, 0, 800, 480);
		level6background = new Texture(game, "level_6_background.png");
		level6backgroundRegion = new TextureRegion(level6background, 0, 0, 800, 480);
		level7background = new Texture(game, "level_7_background.png");
		level7backgroundRegion = new TextureRegion(level7background, 0, 0, 800, 480);
		level8background = new Texture(game, "level_8_background.png");
		level8backgroundRegion = new TextureRegion(level8background, 0, 0, 800, 480);

		background = new Texture(game,"background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 4, 4);

		helpImage = new Texture(game, "help.png");
		helpRegion =  new TextureRegion[NUMBER_OF_HELP_REGIONS];
		helpRegion[0] =  new TextureRegion(helpImage, 0, 0, 560, 320);
		helpRegion[1] = new TextureRegion(helpImage, 560, 0, 560, 320);

		story = new Texture[NUMBER_OF_STORY_REGIONS];
		storyRegion = new TextureRegion[NUMBER_OF_STORY_REGIONS];
		story[0] = new Texture(game, "story0.png");
		storyRegion[0] = new TextureRegion(story[0], 0, 0, 800, 480);
		story[1] = new Texture(game, "story1.png");
		storyRegion[1] = new TextureRegion(story[1], 0, 0, 800, 480);
		story[2] = new Texture(game, "story2.png");
		storyRegion[2] = new TextureRegion(story[2], 0, 0, 800, 480);
		story[3] = new Texture(game, "story3.png");
		storyRegion[3] = new TextureRegion(story[3], 0, 0, 800, 480);
		story[4] = new Texture(game, "story4.png");
		storyRegion[4] = new TextureRegion(story[4], 0, 0, 800, 480);
		story[5] = new Texture(game, "story5.png");
		storyRegion[5] = new TextureRegion(story[5], 0, 0, 800, 480);
		story[6] = new Texture(game, "story6.png");
		storyRegion[6] = new TextureRegion(story[6], 0, 0, 800, 480);
		story[7] = new Texture(game, "story7.png");
		storyRegion[7] = new TextureRegion(story[7], 0, 0, 800, 480);
		story[8] = new Texture(game, "story8.png");
		storyRegion[8] = new TextureRegion(story[8], 0, 0, 800, 480);
		story[9] = new Texture(game, "story9.png");
		storyRegion[9] = new TextureRegion(story[9], 0, 0, 800, 480);
		story[10] = new Texture(game, "story10.png");
		storyRegion[10] = new TextureRegion(story[10], 0, 0, 800, 480);
		story[11] = new Texture(game, "story11.png");
		storyRegion[11] = new TextureRegion(story[11], 0, 0, 800, 480);

		music = game.getAudio().newMusic("music.mp3");
		music.setLooping(true);
		music.setVolume(0.5f);
		if(Settings.soundEnabled)
			music.play();
		clickSound = game.getAudio().newSound("click.ogg");
	}

	public static void reload() {
		sprites.reload();
		background.reload();
		map.reload();
		level1background.reload();
		level2background.reload();
		level3background.reload();
		level4background.reload();
		level5background.reload();
		level6background.reload();
		level7background.reload();
		level8background.reload();
		helpImage.reload();
		for(Texture t : story) 
			t.reload();
		
		if(Settings.soundEnabled)
			music.play();
	}

	public static void playSound(Sound sound) {
		if(Settings.soundEnabled)
			sound.play(1);
	}
}
