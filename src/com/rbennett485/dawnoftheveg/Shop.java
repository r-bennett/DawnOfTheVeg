package com.rbennett485.dawnoftheveg;

public class Shop {

	public static final ShopItem[] items;
	public final static int NUMBER_OF_ITEMS = 2; 
	
	static {
		items = new ShopItem[NUMBER_OF_ITEMS];
		items[0] = new ShopItem(0,Assets.towerD,100, 100, 100);
		items[1] = new ShopItem(1,Assets.towerC,100, 100, 100);
	}

}
