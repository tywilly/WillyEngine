package com.tywilly.WillyEngine;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.update.UpdateThread;

public class Engine {

	public static Display display;
	
	private static UpdateThread updateThread;
	
	public Engine(Display display){
		
		Engine.display = display;
		
		updateThread = new UpdateThread();
		
	}
	
	public void start(){
		
		updateThread.start();
		
	}
	
	public static UpdateThread getUpdateThread(){
		return updateThread;
	}
	
}
