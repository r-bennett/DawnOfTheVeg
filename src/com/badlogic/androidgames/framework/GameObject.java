package com.badlogic.androidgames.framework;

import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;

public class GameObject {
    public final Vector2 position;
    public final Rectangle bounds;
	public boolean inGame;
	public int hp;
    
    public GameObject(float x, float y, float width, float height) {
    	inGame = true;
        this.position = new Vector2(x,y);
        this.bounds = new Rectangle(x-width/2, y-height/2, width, height);
    }
    
    @Override 
    public GameObject clone() {
    	return new GameObject(this.position.x, this.position.y, 
    			this.bounds.width, this.bounds.height); 
    }
    
    public void update(float deltaTime) {
 
    }
}
