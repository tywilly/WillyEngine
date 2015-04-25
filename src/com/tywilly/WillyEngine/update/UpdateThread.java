package com.tywilly.WillyEngine.update;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.graphics.Renderer;
import com.tywilly.WillyEngine.scene.SceneManager;

public class UpdateThread extends Thread implements Runnable {

	private boolean isRunning = true;
	
	private long startTime = 0;
	private long delta = 0;
	
	private int tps = 0;
	
	Renderer renderer;
	
	public UpdateThread(Display display) {
		// TODO Auto-generated constructor stub
		
		this.renderer = display.getRenderer();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (isRunning) {

			startTime = System.currentTimeMillis();

			for (int i = 0; i < SceneManager.getCurrentScene().ents.size(); i++) {

				Entity ent = SceneManager.getCurrentScene().ents.get(i);

				if (ent instanceof Updateable) {
					((Updateable) ent).update(delta);
				}

			}

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			delta = System.currentTimeMillis() - startTime;

			renderer.repaint();

		}

	}

}
