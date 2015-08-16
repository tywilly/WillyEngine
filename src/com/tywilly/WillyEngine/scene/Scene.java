package com.tywilly.WillyEngine.scene;

import java.util.ArrayList;

import com.tywilly.WillyEngine.entity.Entity;

public abstract class Scene {

	private ArrayList<ArrayList<Entity>> layers = new ArrayList<ArrayList<Entity>>();
	private boolean isLoaded = false;
	
	public Scene(){
		layers.add(new ArrayList<Entity>());
	}
	
	public void onCreateSuper(){
		onCreate();
		isLoaded = true;
		System.out.println("Create!");
	}
	
	protected abstract void onCreate();
	
	public void addEntity(Entity ent){
		
		if(layers.size() < ent.getLayer() + 1){
			
			for(int i=0;i<ent.getLayer();i++){
				layers.add(new ArrayList<Entity>());
			}
			
		}
		
		layers.get(ent.getLayer()).add(ent);
		
	}
	
	public void removeEntity(Entity ent){
		layers.get(ent.getLayer()).remove(ent);
	}
	
	public ArrayList<Entity> getLayerList(int layer){
		return layers.get(layer);
	}
	
	public ArrayList<ArrayList<Entity>> getEntitysList(){
		return layers;
	}
	
	public boolean isLoaded(){
		return isLoaded;
	}
	
}
