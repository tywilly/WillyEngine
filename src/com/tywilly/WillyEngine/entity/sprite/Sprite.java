package com.tywilly.WillyEngine.entity.sprite;

import java.awt.Graphics;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.texture.Texture;

public class Sprite extends Entity{

	Texture texture;
	
	public Sprite(int x, int y, int height, int width, Texture texture) {
		super(x, y, height, width);
		
		this.texture = texture;
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		//g.drawImage(texture.getImage(), this.xLoc, this.yLoc, null);
		g.drawImage(texture.getImage(), xLoc, yLoc, xLoc + this.width, yLoc + this.height, 0, 0, texture.getImage().getWidth(), texture.getImage().getWidth(), null);
		
	}
	
	public Texture getTexture(){
		return texture;
	}
	
	public void setTexure(Texture texture){
		this.texture = texture;
	}

}
