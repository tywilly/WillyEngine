package com.tywilly.WillyEngine.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.scene.Scene;
import com.tywilly.WillyEngine.scene.SceneManager;

public class Renderer extends JPanel {
	
	private long startTime;
	
	private static int fps = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9130516796784211244L;

	public Renderer() {

		// InputListener in = new InputListener();
		//
		// this.addKeyListener(in);
		// this.addMouseListener(in);
		// this.addMouseMotionListener(in);

	}

	public static int getFPS(){
		return fps;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		// super.paintComponent(g);

		startTime = System.currentTimeMillis();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Scene renderScene = SceneManager.getCurrentScene();
		
		synchronized (renderScene) {
			for (int i = 0; i < renderScene.getEntitysList()
					.size(); i++) {

				ArrayList<Entity> layer = renderScene.getLayerList(i);

				for (int x = 0; x < layer.size(); x++) {

					Entity ent = layer.get(x);

					ent.paint(g);

				}

			}
		}
		
		startTime = System.currentTimeMillis() - startTime;
		
		Renderer.fps = (int) (1000/startTime);
		
		//repaint();

	}
}
