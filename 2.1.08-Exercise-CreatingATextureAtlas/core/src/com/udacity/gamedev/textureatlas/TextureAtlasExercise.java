package com.udacity.gamedev.textureatlas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureAtlasExercise extends ApplicationAdapter implements AssetErrorListener {

    public static final String TAG = TextureAtlasExercise.class.getName();

    private static final String ATLAS = "images/gigagal.pack.atlas";
    private static final String STANDING_RIGHT = "standing-right";

    // TODO: Add an AssetManager


    SpriteBatch batch;

    // TODO: Add an AtlasRegion to hold the standing right sprite


    @Override
    public void create() {
        batch = new SpriteBatch();

        // TODO: Initialize your AssetManager


        // TODO: Set this as the AssetManager's error listener


        // TODO: tell the AssetManager to load the TextureAtlas with name ATLAS


        // TODO: Call finishLoading() on your AssetManager


        // TODO: Get the TextureAtlas from the asset manager


        // TODO: Populate your AtlasRegion using findRegion() on your Atlas

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();


        // TODO: Draw the standing right AtlasRegion
        // Hint, you need to use the somewhat horrific version of draw with signature:
        // draw (Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX,
        // float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY)

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

    }
}
