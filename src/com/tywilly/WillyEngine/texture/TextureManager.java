package com.tywilly.WillyEngine.texture;

import java.util.ArrayList;

public class TextureManager {

	static ArrayList<Texture> textures = new ArrayList<Texture>();
	
	public static Texture createTexture(String location){
		Texture text = new Texture(location);
		textures.add(text);
		return text;
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
