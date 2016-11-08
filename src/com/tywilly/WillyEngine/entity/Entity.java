package com.tywilly.WillyEngine.entity;

import java.awt.Graphics;

public class Entity implements IEntity{

	protected float xLoc = 0;
	protected float yLoc = 0;
	protected int layer = 0;
	protected int height = 0;
	protected int width = 0;
	
	protected int rotAngle = 0;
	
	
	public Entity(float x,float y,int layer, int width, int height){
		this.xLoc = x;
		this.yLoc = y;
		this.layer = layer;
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
	
	public void setLayer(int layer){
		this.layer = layer;
	}
	
	public int getLayer(){
		return layer;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setHeight(int height){
		this.height = height;
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
