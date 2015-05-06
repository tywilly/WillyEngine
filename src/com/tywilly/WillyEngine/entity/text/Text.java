package com.tywilly.WillyEngine.entity.text;

import java.awt.Font;
import java.awt.Graphics;

import com.tywilly.WillyEngine.entity.Entity;

public class Text extends Entity{

	String text = "";
	
	Font font = new Font("arial", Font.PLAIN, 12);
	
	public Text(int x, int y, int size, String text) {
		super(x, y, 0, 0);
		
		this.text = text;
	
		font = font.deriveFont(font.getStyle(), size);
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setFont(font);
		
		g.drawString(text, xLoc, yLoc);
		
	}
	
	/**
	 * Set the style of text.
	 * @param style style of text to set. Derived from Font class.
	 */
	public void setStyle(int style){
		font = font.deriveFont(style, font.getSize());
	}
	
	
	/**
	 * Set the text.
	 * @param newText String
	 */
	public void setText(String newText){
		text = newText;
	}
	
	/**
	 * Get the current text.
	 * @return String
	 */
	public String getText(){
		return text;
	}
	
}
