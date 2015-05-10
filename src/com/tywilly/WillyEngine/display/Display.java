package com.tywilly.WillyEngine.display;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.tywilly.WillyEngine.graphics.Renderer;
import com.tywilly.WillyEngine.input.InputListener;

public class Display{

	private JFrame frame = new JFrame();
	private Renderer renderer = new Renderer();
	
	public static int TPS = 0;
	
	public Display(String title, int width, int height){
		
		frame.setTitle(title);
		frame.setBounds(new Rectangle(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setLocation(((int)screen.getWidth()/2) - (width/2), ((int)screen.getHeight()/2) - (height/2));
		
		frame.add(renderer);
		
		InputListener in = new InputListener();
		
		frame.addKeyListener(in);
		frame.addMouseListener(in);
		frame.addMouseMotionListener(in);
		
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
