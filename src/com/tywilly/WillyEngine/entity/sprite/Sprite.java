package com.tywilly.WillyEngine.entity.sprite;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.texture.Texture;

public class Sprite extends Entity
{

    Texture texture;

    BufferedImage drawImg;

    public Sprite(int x, int y, int height, int width, Texture texture)
    {
        super(x, y, height, width);

        this.texture = texture;

    }

    @Override
    public void paint(Graphics g)
    {
        // TODO Auto-generated method stub

        if (drawImg == null && texture.isLoaded())
        {
            drawImg = texture.getImage();
        }

        // g.drawImage(texture.getImage(), this.xLoc, this.yLoc, null);

        // g.drawImage(op.filter(texture.getImage(), null), xLoc, yLoc, xLoc +
        // this.width, yLoc + this.height, 0, 0, texture.getImage().getWidth(),
        // texture.getImage().getWidth(), null);

        g.drawImage(drawImg, xLoc, yLoc, xLoc + this.width, yLoc + this.height,
                0, 0, drawImg.getWidth(), drawImg.getWidth(), null);

    }

    public Texture getTexture()
    {
        return texture;
    }

    public void setTexure(Texture texture)
    {
        this.texture = texture;

        this.drawImg = null;

    }

    @Override
    public void setRotation(int angle)
    {
        // TODO Auto-generated method stub
        super.setRotation(angle);

        AffineTransform tx = AffineTransform.getRotateInstance(
                Math.toRadians(rotAngle), texture.getImage().getWidth() / 2,
                texture.getImage().getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_BILINEAR);

        drawImg = op.filter(texture.getImage(), null);
    }

}
