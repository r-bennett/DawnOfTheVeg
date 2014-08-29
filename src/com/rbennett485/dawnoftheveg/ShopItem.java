package com.rbennett485.dawnoftheveg;

import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.rbennett485.dawnoftheveg.data.Progress;

/**
 * Represents each item in the shop, both in terms of  its sale
 * and its presentation on screen
 * 
 * @author Bennett_Richard
 *
 */
public class ShopItem {
	public int itemId;
	public TextureRegion region;
	public int cost;
	public int width;
	public int height;
	
	/**
	 * Constructor
	 * 
	 * @param id The position in the shop
	 * @param region The {@link TextureRegion} to display on screen
	 * @param cost The cost to buy
	 * @param width	The width of the displayed image (pixels)
	 * @param height The height of the displayed images (pixels)
	 */
	public ShopItem(int id, TextureRegion region, int cost, int width, int height) {
		this.itemId = id;
		this.region = region;
		this.cost = cost;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Called to buy the item. If sufficient funds are available, cost is deducted
	 * and item added to {@link Progress#shop} record
	 * 
	 * @return indicates success or failure of transaction
	 */
	public boolean purchase() {
		if(Progress.funds >= cost) {
			Progress.shop[itemId] = true;
			Progress.funds -= cost;
			return true;
		} else {
			return false;
		}
	}

}
