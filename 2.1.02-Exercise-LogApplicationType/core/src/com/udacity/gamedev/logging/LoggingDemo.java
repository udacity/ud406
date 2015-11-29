package com.udacity.gamedev.logging;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoggingDemo extends ApplicationAdapter {

    // TODO: Give your ApplicationListener a log TAG


    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        // TODO: Use Gdx.app to find what ApplicationType we're running
        // TODO: Use Gdx.app to log the result

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    // TODO: Run the Desktop app and find your log message
    // TODO: Run the Android app and find your log message
}
