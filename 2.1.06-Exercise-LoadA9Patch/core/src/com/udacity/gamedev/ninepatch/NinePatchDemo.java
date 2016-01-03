package com.udacity.gamedev.ninepatch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class NinePatchDemo extends ApplicationAdapter {

    private static final float WORLD_SIZE = 100;
    private static final int EDGE = 8;
    private static final float TEST_SIZE_1 = 20;
    private static final float TEST_SIZE_2 = 40;

    SpriteBatch batch;
    FitViewport viewport;

    // TODO: Add a Texture for the raw platform image

    // TODO: Add a NinePatch

    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);

        // TODO: Load the platform texture (Look for the file in android/assets)


        // TODO: Initialize the NinePatch using the texture and the EDGE constant

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        viewport.apply();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        // TODO: Draw the platform texture at TEST_SIZE_1

        // TODO: Draw the platform texture at TEST_SIZE_2

        // TODO: Draw the nine patch at TEST_SIZE_1

        // TODO: Draw the nine patch at TEST_SIZE_2

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        // TODO: Dispose of the texture


    }
}
