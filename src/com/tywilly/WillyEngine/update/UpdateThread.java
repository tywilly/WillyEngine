package com.tywilly.WillyEngine.update;

import java.util.ArrayList;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.scene.Scene;
import com.tywilly.WillyEngine.scene.SceneManager;

public class UpdateThread extends Thread implements Runnable {

	private boolean isRunning = true;

	private ArrayList<InputAction> inputEvents = new ArrayList<>();
	
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

			Scene updateScene = SceneManager.getCurrentScene();

			synchronized (updateScene) {

				for (int i = 0; i < updateScene.getEntitysList().size(); i++) {

					ArrayList<Entity> layer = updateScene.getLayerList(i);

					for (int x = 0; x < layer.size(); x++) {

						if (x < layer.size()) {

							Entity ent = layer.get(x);

							if (ent instanceof Updateable) {
								((Updateable) ent).update(delta);
							}
							
							//FIND A WAY TO ONLY RUN AN INPUT FOR THE SPECIFIED ENT

						}

					}

				}

			}

			delta = System.currentTimeMillis() - startTime;

		}

	}

	public void queueInputAction(InputAction ia){
		this.inputEvents.add(ia);
	}
	
}
