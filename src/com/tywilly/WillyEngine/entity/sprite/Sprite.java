package com.tywilly.WillyEngine.entity.sprite;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.texture.Texture;

public class Sprite extends Entity {

	Texture texture;

	public Sprite(int x, int y, int height, int width, Texture texture) {
		super(x, y, height, width);

		this.texture = texture;

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		// g.drawImage(texture.getImage(), this.xLoc, this.yLoc, null);

		

		// g.drawImage(op.filter(texture.getImage(), null), xLoc, yLoc, xLoc +
		// this.width, yLoc + this.height, 0, 0, texture.getImage().getWidth(),
		// texture.getImage().getWidth(), null);

		g.drawImage(texture.getImage(), xLoc, yLoc, xLoc
				+ this.width, yLoc + this.height, 0, 0, texture.getImage()
				.getWidth(), texture.getImage().getWidth(), null);

	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexure(Texture texture) {
		this.texture = texture;
	}

	@Override
	public void setRotation(int angle) {
		// TODO Auto-generated method stub
		super.setRotation(angle);
		
		AffineTransform tx = AffineTransform.getRotateInstance(
				Math.toRadians(rotAngle), xLoc + texture.getImage().getWidth()/2, yLoc + texture.getImage().getHeight()/2);

		AffineTransformOp op = new AffineTransformOp(tx,
				AffineTransformOp.TYPE_BILINEAR);
		
		texture.setImage(op.filter(texture.getImage(), null));
		
		System.out.println(texture.getImage().getHeight());
		
	}

	
	
}
