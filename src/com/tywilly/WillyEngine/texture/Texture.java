package com.tywilly.WillyEngine.texture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {

	String location = "";
	
	BufferedImage img;
	
	public Texture(String location){
		this.location = location;
	}
	
	public void loadIntoMemery(){
		try {
			img = ImageIO.read(new File(location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(){
		return img;
	}
	
	public String getLocation(){
		return location;
	}
	
}
