package com.tywilly.WillyEngine.scene;

import java.util.ArrayList;

import com.tywilly.WillyEngine.entity.Entity;

public abstract class Scene {

	public ArrayList<Entity> ents = new ArrayList<Entity>();
	
	public abstract void onCreate();
	
	public void addEntity(Entity ent){
		ents.add(ent);
	}
	
	public void removeEntity(Entity ent){
		ents.remove(ent);
	}
	
}
