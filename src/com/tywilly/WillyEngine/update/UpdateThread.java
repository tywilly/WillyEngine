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

	public UpdateThread() {
		this.setName("Update Thread");
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

					if (x < layer.size()) {

						Entity ent = layer.get(x);

						if (ent instanceof Updateable) {
							((Updateable) ent).update(delta);
						}

					}

				}

			}

			delta = System.currentTimeMillis() - startTime;
			
		}

	}

}
