package com.tywilly.WillyEngine.input;



public class InputAction{
	
	ActionType action;
	int mouseX;
	int mouseY;
	char keyCode;
	int keyNum;
	
	public InputAction(ActionType action,char keyCode, int keyNum){
		this.action = action;
		this.mouseX = 0;
		this.mouseY = 0;
		this.keyCode = keyCode;
		this.keyNum = keyNum;
	}
	
	public InputAction(ActionType action, int mouseX, int mouseY, char keyCode){
		this.action = action;
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		this.keyCode = keyCode;
	}
	
	/**
	 * Get the type of action. Refer to ActionType Enum for actions.
	 * @return ActionType
	 */
	public ActionType getAction(){
		return action;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
	public char getKeyCode(){
		return keyCode;
	}
	
	public int getKeyNum(){
		return keyNum;
	}
	
	public enum ActionType{
		MOUSE_DOWN, MOUSE_UP,KEYBOARD_DOWN, KEYBOARD_UP
	}
	
}
