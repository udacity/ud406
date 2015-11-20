package com.udacity.gamedev.textureatlas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class TextureAtlasExercise extends ApplicationAdapter implements AssetErrorListener {

    public static final String TAG = TextureAtlasExercise.class.getName();

    private static final String ATLAS = "images/gigagal.pack.atlas";
    private static final String STANDING_RIGHT = "standing-right";

    private AssetManager assetManager;

    SpriteBatch batch;
    Texture img;

    AtlasRegion standingRight;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        assetManager = new AssetManager();
        assetManager.setErrorListener(this);
        assetManager.load(ATLAS, TextureAtlas.class);
        assetManager.finishLoading();
        TextureAtlas atlas = assetManager.get(ATLAS);


        standingRight = atlas.findRegion(STANDING_RIGHT);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        //
        batch.draw(standingRight.getTexture(), 0, 0);



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
        assetManager.dispose();
    }
}
