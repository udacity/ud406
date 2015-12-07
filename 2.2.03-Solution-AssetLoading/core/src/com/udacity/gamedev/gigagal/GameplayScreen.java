package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;


public class GameplayScreen extends ScreenAdapter {

    public static final String TAG = GameplayScreen.class.getName();

    // TODO: Add a SpriteBatch
    SpriteBatch batch;

    // TODO: Add an ExtendViewport
    ExtendViewport viewport;

    @Override
    public void show() {

        // TODO: Initialize the Assets instance
        Assets.instance.init();

        // TODO: Initalize the SpriteBatch
        batch = new SpriteBatch();

        // TODO: Initialize the viewport
        viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
    }

    @Override
    public void resize(int width, int height) {
        // TODO: Update the viewport
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        // TODO: Dispose of the Assets instance
        Assets.instance.dispose();

        // TODO: Dispose of the SpriteBatch
        batch.dispose();
    }

    @Override
    public void render(float delta) {

        // TODO: Apply the viewport
        viewport.apply();

        // TODO: Clear the screen to the BACKGROUND_COLOR
        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                Constants.BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        // TODO: Set the SpriteBatch's projection matrix
        batch.setProjectionMatrix(viewport.getCamera().combined);

        // TODO: Begin the SpriteBatch
        batch.begin();

        // TODO: Draw the standing right AtlasRegion
        TextureRegion region = Assets.instance.gigaGalAssets.standingRight;

        batch.draw(
                region.getTexture(),
                50,
                50,
                0,
                0,
                region.getRegionWidth(),
                region.getRegionHeight(),
                1,
                1,
                0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false,
                false);

        // TODO: End the SpriteBatch
        batch.end();
    }
}
