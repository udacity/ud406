package com.udacity.gamedev.rectanglecirclecollision.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.udacity.gamedev.rectanglecirclecollision.RectangleCircleCollisionGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new RectangleCircleCollisionGame(), config);
	}
}
