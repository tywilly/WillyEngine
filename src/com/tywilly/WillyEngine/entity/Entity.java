package com.tywilly.WillyEngine.entity;

import java.awt.Graphics;

public class Entity implements IEntity{

	protected float xLoc = 0;
	protected float yLoc = 0;
	protected int height = 0;
	protected int width = 0;
	
	protected int rotAngle = 0;
	
	
	public Entity(float x,float y, int height, int width){
		this.xLoc = x;
		this.yLoc = y;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void setX(float x){
		xLoc = x;
	}
	
	public float getX(){
		return xLoc;
	}
	
	public void setY(float y){
		yLoc = y;
	}
	
	public float getY(){
		return yLoc;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getRotation(){
		return rotAngle;
	}
	
	public void setRotation(int angle){
		rotAngle = angle;
	}
	
}
