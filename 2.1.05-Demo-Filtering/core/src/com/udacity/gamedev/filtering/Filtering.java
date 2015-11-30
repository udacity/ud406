package com.udacity.gamedev.filtering;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


// TODO: Check it out!
public class Filtering extends ApplicationAdapter {

    private static final float SCALE = 6.0f;

    SpriteBatch batch;

    Texture nearest;
    Texture linear;

    ScreenViewport viewport;

    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new ScreenViewport();
        nearest = new Texture("standing-right.png");
        linear = new Texture("standing-right.png");
        linear.setFilter(TextureFilter.Linear, TextureFilter.Linear);
    }

    @Override
    public void render() {
        viewport.apply();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        renderTextureCentered(batch, nearest, viewport.getWorldWidth() * 1.5f / 6, viewport.getWorldHeight() * 1 / 2, SCALE);
        renderTextureCentered(batch, nearest, viewport.getWorldWidth() * 3 / 6, viewport.getWorldHeight() * 1 / 2, 1.0f);
        renderTextureCentered(batch, linear, viewport.getWorldWidth() * 4.5f / 6, viewport.getWorldHeight() * 1 / 2, SCALE);
        batch.end();
    }

    private void renderTextureCentered(SpriteBatch batch, Texture texture, float x, float y, float scale) {
        float scaledWidth = texture.getWidth() * scale;
        float scaledHeight = texture.getHeight() * scale;
        batch.draw(texture, x - scaledWidth / 2, y - scaledHeight / 2, scaledWidth, scaledHeight);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
