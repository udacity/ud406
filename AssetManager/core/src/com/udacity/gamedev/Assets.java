package com.udacity.gamedev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by james on 10/30/15.
 */
public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();

    public static final Assets instance = new Assets();

    // Location of description file for texture atlas
    public static final String GAME_OBJECTS = "images/gigagal.pack.atlas";

    private AssetManager assetManager;

    private ArrayMap<String, AtlasRegion> regions;
    private ArrayMap<String, BitmapFont> fonts;
    private ArrayMap<String, Animation> animations;


    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(GAME_OBJECTS, TextureAtlas.class);
        assetManager.finishLoading();
        Gdx.app.debug(TAG, "Loaded " + assetManager.getAssetNames().size + " assets");

        // Load atlas
        TextureAtlas atlas = assetManager.get(GAME_OBJECTS);

        // enable texture filtering
        for (Texture texture : atlas.getTextures()) {
            texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        }

        // Load regions into hashmap
        regions = new ArrayMap<String, AtlasRegion>();
        for (AtlasRegion region : atlas.getRegions()) {
            regions.put(region.name, region);
        }

        // Load fonts
        // Assumes a fonts folder in assets
        fonts = new ArrayMap<String, BitmapFont>();
        BitmapFont font;
        FileHandle[] fontFiles = Gdx.files.internal("fonts").list();
        for (FileHandle file : fontFiles) {
            font = new BitmapFont(file, true);
            font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
            fonts.put(file.name(), font);
        }

        // Load animations
        // Assumes animations have the format as follows:
        // animation-identifer-number.ext

        // What I'd give for a Groovy find or collect
        // Not the most elegant but the best I can do without upping
        // the source version in all the files, lambdas are Java8 only
        ArrayList<String> left = new ArrayList<String>();
        for (String key : regions.keys().toArray()) {
            if (key.startsWith("animation-walkLeft"))
                left.add(key);
        }
        ArrayList<String> right = new ArrayList<String>();
        for (String key : regions.keys().toArray()) {
            if (key.startsWith("animation-walkRight"))
                right.add(key);
        }

        animations = new ArrayMap<String, Animation>();
        float duration = 0.225f;
        animations.put("walkLeft", processAnimation(duration, left));
        animations.put("walkRight", processAnimation(duration, right));
    }

    private Animation processAnimation(float duration, Iterable<String> iterable) {
        Array<AtlasRegion> frames = new Array<AtlasRegion>();
        for (Iterator<String> iterator = iterable.iterator(); iterator.hasNext(); ) {
            String name = iterator.next();
            frames.add(get(name));
        }

        Animation animation = new Animation(duration, frames);
        return animation;
    }

    public AtlasRegion get(String name) {
        return regions.get(name);
    }

    public BitmapFont getFont(String fontName) {
        return fonts.get(fontName);
    }

    public Animation getAnimation(String name) {
        return animations.get(name);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception) throwable);

    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
