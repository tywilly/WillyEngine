package com.tywilly.WillyEngine.display;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.tywilly.WillyEngine.graphics.RenderThread;
import com.tywilly.WillyEngine.graphics.Renderer;
import com.tywilly.WillyEngine.input.InputListener;

public class Display{

	private JFrame frame = new JFrame();
	private RenderThread renderThread = new RenderThread(new Renderer());
	
	public static int TPS = 0;
	
	public Display(String title, int width, int height){
		
		frame.setTitle(title);
		frame.setBounds(new Rectangle(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setLocation(((int)screen.getWidth()/2) - (width/2), ((int)screen.getHeight()/2) - (height/2));
		
		frame.add(renderThread.getRenderer());
		
		renderThread.start();
		
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
		return renderThread.getRenderer();
	}
	
	public RenderThread getRenderThread(){
		return renderThread;
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
