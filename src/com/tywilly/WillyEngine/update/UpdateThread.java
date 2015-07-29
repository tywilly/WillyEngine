package com.tywilly.WillyEngine.update;

import java.util.ArrayList;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.graphics.Renderer;
import com.tywilly.WillyEngine.scene.SceneManager;

public class UpdateThread extends Thread implements Runnable {

	private boolean isRunning = true;

	private long startTime = 0;
	private long delta = 0;

	private long tpsStartTime = System.currentTimeMillis();
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

			for (int i = 0; i < SceneManager.getCurrentScene().getEntitysList()
					.size(); i++) {

				ArrayList<Entity> layer = SceneManager.getCurrentScene()
						.getLayerList(i);

				for (int x = 0; x < layer.size(); x++) {

					Entity ent = layer.get(x);

					if (ent instanceof Updateable) {
						((Updateable) ent).update(delta);
					}

				}

			}

			try {

				long sleepTime = Math.min(1000, Math.max(
						16 - (System.currentTimeMillis() - startTime), 0));

				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			delta = System.currentTimeMillis() - startTime;

			// renderer.repaint();

			if (System.currentTimeMillis() - tpsStartTime >= 1000) {
				Display.TPS = tps;
				tps = 0;
				tpsStartTime = System.currentTimeMillis();
			}

			tps++;

		}

	}

}
