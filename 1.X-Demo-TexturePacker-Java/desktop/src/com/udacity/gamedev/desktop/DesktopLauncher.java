package com.udacity.gamedev.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.udacity.gamedev.TexturePackerDemo;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;



public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// Runs every time the desktop flavor is run.
		TexturePacker.process("image-sprites", "images", "gigagal.pack");

		new LwjglApplication(new TexturePackerDemo(), config);
	}
}
