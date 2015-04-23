package com.tywilly.WillyEngine;

import com.tywilly.WillyEngine.display.Display;

public class Main{
	
	public Main(){
		
		Display.setTitle("WillyEngine");
		Display.createDisplay(750, 500);
		
	}
	
	public static void main(String[] args){
		
		Main main = new Main();
		
	}
	
}
