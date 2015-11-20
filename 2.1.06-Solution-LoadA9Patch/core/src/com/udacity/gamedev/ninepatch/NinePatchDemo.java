package com.udacity.gamedev.ninepatch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class NinePatchDemo extends ApplicationAdapter {

    private static final float WORLD_SIZE = 100;
    private static final int EDGE = 8;
    private static final float TEST_SIZE_1 = 20;
    private static final float TEST_SIZE_2 = 40;

    SpriteBatch batch;
    FitViewport viewport;

    Texture platformTexture;
    NinePatch platformNinePatch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);

        platformTexture = new Texture("platform.png");

        platformNinePatch = new NinePatch(platformTexture, EDGE, EDGE, EDGE, EDGE);
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

        batch.draw(platformTexture,
                WORLD_SIZE * 1 / 4 - TEST_SIZE_1 / 2, WORLD_SIZE * 1 / 4 - TEST_SIZE_1 / 2,
                TEST_SIZE_1, TEST_SIZE_1);
        batch.draw(platformTexture,
                WORLD_SIZE * 3 / 4 - TEST_SIZE_2 / 2, WORLD_SIZE * 1 / 4 - TEST_SIZE_2 / 2,
                TEST_SIZE_2, TEST_SIZE_2);


        platformNinePatch.draw(batch,
                WORLD_SIZE * 1 / 4 - TEST_SIZE_1 / 2, WORLD_SIZE * 3 / 4 - TEST_SIZE_1 / 2,
                TEST_SIZE_1, TEST_SIZE_1);
        platformNinePatch.draw(batch,
                WORLD_SIZE * 3 / 4 - TEST_SIZE_2 / 2, WORLD_SIZE * 3 / 4 - TEST_SIZE_2 / 2,
                TEST_SIZE_2, TEST_SIZE_2);

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
