package com.tywilly.WillyEngine.entity.text;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.update.Updateable;


public class DebugInfo extends Text implements Updateable{

	int currTick = 0;
	
	public DebugInfo() {
		super(0, 18, 20, "FPS: " + Display.TPS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		if(currTick >= Display.TPS){
			this.setText("FPS: " + Display.TPS);
			currTick = 0;
		}
		
		currTick++;
		
		
	}

}
