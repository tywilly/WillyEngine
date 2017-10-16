package com.tywilly.WillyEngine.scene;

import java.util.ArrayList;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.Entity;

public abstract class Scene {

	private ArrayList<ArrayList<Entity>> layers = new ArrayList<ArrayList<Entity>>();
	private boolean isLoaded = false;

	private boolean renderThread = false;

	public Scene() {
		layers.add(new ArrayList<Entity>());
	}

	public void onCreateSuper() {
		onCreate();
		isLoaded = true;
		System.out.println("Create!");
	}

	protected abstract void onCreate();

	public synchronized void addEntity(Entity ent) {

		if (layers.size() < ent.getLayer() + 1) {

			for (int i = 0; i < ent.getLayer(); i++) {
				layers.add(new ArrayList<Entity>());
			}

		}

		layers.get(ent.getLayer()).add(ent);

	}

	public synchronized void removeEntity(Entity ent) {
		layers.get(ent.getLayer()).remove(ent);
	}

	public synchronized ArrayList<Entity> getLayerList(int layer) {
		return layers.get(layer);
	}

	public synchronized ArrayList<ArrayList<Entity>> getEntitysList() {

		if(renderThread && Thread.currentThread().equals(Engine.getUpdateThread())){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(!renderThread && Thread.currentThread().equals(Engine.display.getRenderThread())){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			System.out.println(Thread.currentThread().getName());
			return layers;
		} finally {
			renderThread = !renderThread;
			notifyAll();
		}
	}

	public boolean isLoaded() {
		return isLoaded;
	}

}
