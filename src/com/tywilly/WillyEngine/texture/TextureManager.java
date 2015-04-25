package com.tywilly.WillyEngine.texture;

import java.util.ArrayList;

public class TextureManager {

	ArrayList<Texture> textures = new ArrayList<Texture>();
	
	public void addTexture(Texture text){
		textures.add(text);
	}
	
	public Texture getTexture(String location){
		
		for(int i=0;i<textures.size();i++){
			if(textures.get(i).getLocation().equals(location)){
				return textures.get(i);
			}
		}
		
		return null;
		
	}
	
}
