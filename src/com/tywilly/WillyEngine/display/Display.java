package com.tywilly.WillyEngine.display;

import java.awt.Rectangle;

import javax.swing.JFrame;

import com.tywilly.WillyEngine.graphics.Renderer;

public class Display extends Thread implements Runnable{

	private static JFrame frame = new JFrame();
	private static Renderer r = new Renderer();
	
	public static int SCREEN_WIDTH = 0;
	public static int SCREEN_HEIGHT = 0;
	
	private static Display dis;
	
	private boolean isRunning = true;
	
	public static void setTitle(String title){
		frame.setTitle(title);
	}
	
	public static void createDisplay(int width, int height){
		
		SCREEN_HEIGHT = height;
		SCREEN_WIDTH = width;
		
		frame.setBounds(new Rectangle(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(r);
		
		frame.setVisible(true);
		
		
		dis = new Display();
		dis.start();
		
	}
	
	public void run(){
		while(isRunning){
			
			
			
			r.repaint();
		}
	}
	
}
