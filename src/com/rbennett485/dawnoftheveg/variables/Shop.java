package com.rbennett485.dawnoftheveg.variables;

import com.rbennett485.dawnoftheveg.Assets;
import com.rbennett485.dawnoftheveg.ShopItem;

/**
 * Stores information about what is contained in shop
 * @author Bennett_Richard
 *
 */
public class Shop {

	public static final ShopItem[] items;
	public final static int NUMBER_OF_ITEMS = 2; 
	
	static {
		items = new ShopItem[NUMBER_OF_ITEMS];
		items[0] = new ShopItem(0,Assets.towerC,25, 100, 100);
		items[1] = new ShopItem(1,Assets.towerD,75, 100, 100);
	}

}
