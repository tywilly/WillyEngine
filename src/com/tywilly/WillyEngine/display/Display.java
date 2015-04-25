package com.tywilly.WillyEngine.display;

import java.awt.Rectangle;

import javax.swing.JFrame;

import com.tywilly.WillyEngine.graphics.Renderer;

public class Display{

	private JFrame frame = new JFrame();
	private Renderer renderer = new Renderer();
	
	public Display(String title, int width, int height){
		
		frame.setTitle(title);
		frame.setBounds(new Rectangle(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(renderer);
		
		frame.setVisible(true);
		
	}
	
	
	public static Display createDisplay(int width, int height){
		return new Display("WillyEngine", width, height);
	}
	
	public Renderer getRenderer(){
		return renderer;
	}
	
	public void setTitle(String title){
		frame.setTitle(title);
	}
	
	public int getWidth(){
		return frame.getWidth();
	}
	
	public int getHeight(){
		return frame.getHeight();
	}
	
}
