package com.rbennett485.dawnoftheveg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.androidgames.framework.GameObject;

public class World {

	public interface WorldListener {
		public void shot();
		public void splat();
	}

	public static final float WORLD_WIDTH = 20;
	public static final float WORLD_HEIGHT = 12;
	public static final int INITIAL_MONEY = 1000;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_COMPLETE = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;

	public final List<GameObject> enemies;
	public final List<GameObject> towers;
	public final WorldListener listener;
	public final Random rand;

	public int money;
	public int state;

	public World(WorldListener listener) {
		this.enemies = new ArrayList<GameObject>();
		this.towers = new ArrayList<GameObject>();
		this.listener = listener;
		rand = new Random();

		this.money = INITIAL_MONEY;
		this.state = WORLD_STATE_RUNNING;
	}

	public void update(float deltaTime) {
		updateTowers(deltaTime);
		updateEnemies(deltaTime);
		checkGameOver();
	}

	private void checkGameOver() {
		// TODO Auto-generated method stub

	}

	private void updateEnemies(float deltaTime) {
		int len = enemies.size();
		for (int i = 0; i < len; i++) {
			Orange orange = (Orange)enemies.get(i);  // Will need to change this once more types of enemy are added
			orange.update(deltaTime);
		}		
	}

	private void updateTowers(float deltaTime) {
		// TODO Auto-generated method stub
	}

}
