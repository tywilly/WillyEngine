package com.tywilly.WillyEngine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.SceneManager;

public class InputListener implements KeyListener, MouseListener, MouseMotionListener{
	
	
	InputAction action;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		action = new InputAction(ActionType.MOUSE_DOWN, e.getX(), e.getY(), e.getButton() == MouseEvent.BUTTON1 ? '1' : '2');
		actionEvent(action);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		action = new InputAction(ActionType.MOUSE_UP, e.getX(), e.getY(), e.getButton() == MouseEvent.BUTTON1 ? '1' : '2');
		actionEvent(action);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		action = new InputAction(ActionType.KEYBOARD_DOWN, arg0.getKeyChar());
		actionEvent(action);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		action = new InputAction(ActionType.KEYBOARD_UP, arg0.getKeyChar());
		actionEvent(action);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private void actionEvent(InputAction action){
		
		for(int i=0;i<SceneManager.getCurrentScene().ents.size();i++){
			
			Entity ent = SceneManager.getCurrentScene().ents.get(i);
			
			if(ent instanceof Input){
				((Input) ent).onInput(action);
			}
			
		}
		
	}
	
}
