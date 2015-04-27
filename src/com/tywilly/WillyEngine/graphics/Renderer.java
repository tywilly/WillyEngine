package com.tywilly.WillyEngine.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.tywilly.WillyEngine.entity.IEntity;
import com.tywilly.WillyEngine.scene.SceneManager;


public class Renderer extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9130516796784211244L;
	
	public Renderer(){
		
//		InputListener in = new InputListener();
//		
//		this.addKeyListener(in);
//		this.addMouseListener(in);
//		this.addMouseMotionListener(in);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paintComponent(g);
	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(int i=0;i<SceneManager.getCurrentScene().ents.size();i++){
			IEntity ent = SceneManager.getCurrentScene().ents.get(i);
			
			ent.paint(g);
			
		}
		
	}
	
	
	
}
