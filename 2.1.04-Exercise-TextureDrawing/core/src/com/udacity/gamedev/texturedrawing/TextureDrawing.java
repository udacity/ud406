package com.udacity.gamedev.texturedrawing;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class TextureDrawing extends ApplicationAdapter {

    private static final Color UDACITY_ORANGE = new Color(228.0f/225.0f, 127.0f/225.0f, 57.0f/225.0f, 1.0f);
    private static final float WORLD_SIZE = 100.0f;
    private static final float LOGO_SIZE = 0.5f * WORLD_SIZE;

    ExtendViewport viewport;

    // TODO: Declare a SpriteBatch


    // TODO: Declare a Texture for the Udacity Logo


    @Override
    public void create() {
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);

        // TODO: Initialize the SpriteBatch


        // TODO: Load the Udacity logo Texture (look in android/assets)

    }

    @Override
    public void render() {
        viewport.apply();
        Gdx.gl.glClearColor(UDACITY_ORANGE.r, UDACITY_ORANGE.g, UDACITY_ORANGE.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Set the SpriteBatch's projection matrix


        // TODO: Begin the sprite batch


        // TODO: First just draw the udacity logo at LOGO_SIZE in the bottom left of the screen


        // TODO: Then try centering the logo


        // TODO: End the sprite batch

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
