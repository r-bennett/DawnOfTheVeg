package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.gl.TextureRegion;

public class ShopItem {
	public int itemId;
	public TextureRegion region;
	public int cost;
	
	public ShopItem(int id, TextureRegion region, int cost) {
		this.itemId = id;
		this.region = region;
		this.cost = cost;
	}

}
