package com.tywilly.WillyEngine.entity;

import java.awt.Graphics;

public class Entity implements IEntity{

	protected int xLoc = 0;
	protected int yLoc = 0;
	protected int height = 0;
	protected int width = 0;
	
	public Entity(int x,int y, int height, int width){
		this.xLoc = x;
		this.yLoc = y;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void setX(int x){
		xLoc = x;
	}
	
	public int getX(){
		return xLoc;
	}
	
	public void setY(int y){
		yLoc = y;
	}
	
	public int getY(){
		return yLoc;
	}
	
}
