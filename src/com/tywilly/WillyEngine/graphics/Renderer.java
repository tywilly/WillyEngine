package com.tywilly.WillyEngine.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.entity.IEntity;
import com.tywilly.WillyEngine.input.InputListener;
import com.tywilly.WillyEngine.update.Updateable;


public class Renderer extends JPanel{
	
	int x = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9130516796784211244L;
	
	public ArrayList<IEntity> ents = new ArrayList<IEntity>();
	
	public Renderer(){
		
		InputListener in = new InputListener();
		
		this.addKeyListener(in);
		this.addMouseListener(in);
		this.addMouseMotionListener(in);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paintComponent(g);
	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Display.SCREEN_WIDTH, Display.SCREEN_HEIGHT);
		
		for(int i=0;i<ents.size();i++){
			IEntity ent = ents.get(i);
			
			
			if(ent instanceof Updateable){
			    ((Updateable) ent).update();
			}
			
			ent.paint(g);
			
		}
		
	}
	
}
