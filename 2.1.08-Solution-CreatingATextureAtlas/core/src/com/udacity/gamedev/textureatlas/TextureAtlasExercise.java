package com.udacity.gamedev.textureatlas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class TextureAtlasExercise extends ApplicationAdapter implements AssetErrorListener {

    public static final String TAG = TextureAtlasExercise.class.getName();

    private static final String ATLAS = "images/gigagal.pack.atlas";
    private static final String STANDING_RIGHT = "standing-right";

    // TODO: Add an AssetManager
    private AssetManager assetManager;

    SpriteBatch batch;

    // TODO: Add an AtlasRegion to hold the standing right sprite
    AtlasRegion standingRight;

    @Override
    public void create() {
        batch = new SpriteBatch();

        // TODO: Initialize your AssetManager
        assetManager = new AssetManager();

        // TODO: Set this as the AssetManager's error listener
        assetManager.setErrorListener(this);

        // TODO: tell the AssetManager to load the TextureAtlas with name ATLAS
        assetManager.load(ATLAS, TextureAtlas.class);

        // TODO: Call finishLoading() on your AssetManager
        assetManager.finishLoading();

        // TODO: Get the TextureAtlas from the asset manager
        TextureAtlas atlas = assetManager.get(ATLAS);

        // TODO: Populate your AtlasRegion using findRegion() on your Atlas
        standingRight = atlas.findRegion(STANDING_RIGHT);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        // Don't do this! This results in drawing the entire texture atlas, not just the region you're interested in
        // batch.draw(standingRight.getTexture(), 0, 0);


        // TODO: Draw the standing right AtlasRegion
        // Hint, you need to use the somewhat horrific version of draw with signature:
        // draw (Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX,
        // float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY)
        batch.draw(
                standingRight.getTexture(),
                0,
                0,
                0,
                0,
                standingRight.getRegionWidth(),
                standingRight.getRegionHeight(),
                1,
                1,
                0,
                standingRight.getRegionX(),
                standingRight.getRegionY(),
                standingRight.getRegionWidth(),
                standingRight.getRegionHeight(),
                false,
                false);
        batch.end();
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        batch.dispose();
        // TODO: Dispose of the AssetManager
        assetManager.dispose();
    }
}
