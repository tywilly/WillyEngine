package com.tywilly.WillyEngine.graphics;

import com.tywilly.WillyEngine.display.Display;

public class RenderThread extends Thread {

	private Renderer render;

	private long tpsStartTime = System.currentTimeMillis();
	private int tps = 0;

	public RenderThread(Renderer render) {
		this.render = render;
		this.setName("Render Thread");
	}

	@Override
	public void run() {

		while (true) {

			render.repaint();

			if (System.currentTimeMillis() - tpsStartTime >= 1000) {
				Display.TPS = tps;
				tps = 0;
				tpsStartTime = System.currentTimeMillis();
			}

			tps++;

		}

	}

	public Renderer getRenderer() {
		return render;
	}

}
