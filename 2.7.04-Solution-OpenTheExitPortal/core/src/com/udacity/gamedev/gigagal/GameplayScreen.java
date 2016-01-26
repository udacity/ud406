package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.ChaseCam;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.overlays.GigaGalHud;
import com.udacity.gamedev.gigagal.overlays.OnscreenControls;


public class GameplayScreen extends ScreenAdapter {

    public static final String TAG = GameplayScreen.class.getName();

    ExtendViewport gameplayViewport;
    Level level;
    ChaseCam chaseCam;

    ExtendViewport hudViewport;
    GigaGalHud hud;

    ExtendViewport onscreenControlsViewport;
    OnscreenControls onscreenControls;

    SpriteBatch batch;


    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.instance.init(am);

        batch = new SpriteBatch();
        gameplayViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        level = new Level(gameplayViewport);
        //        level = LevelLoader.load("levels/intro_level.json", gameplayViewport);
        chaseCam = new ChaseCam(gameplayViewport.getCamera(), level.getGigaGal());

        hudViewport = new ExtendViewport(Constants.HUD_VIEWPORT_SIZE, Constants.HUD_VIEWPORT_SIZE);
        hud = new GigaGalHud(hudViewport);

        onscreenControlsViewport = new ExtendViewport(
                Constants.ONSCREEN_CONTROLS_VIEWPORT_SIZE,
                Constants.ONSCREEN_CONTROLS_VIEWPORT_SIZE);


        onscreenControls = new OnscreenControls(onscreenControlsViewport);
    }

    @Override
    public void resize(int width, int height) {
        gameplayViewport.update(width, height, true);
        hudViewport.update(width, height, true);
        onscreenControlsViewport.update(width, height, true);
        onscreenControls.recalculateButtonPositions();
    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
    }

    @Override
    public void render(float delta) {
        level.update(delta);
        chaseCam.update(delta);
        gameplayViewport.apply();
        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                Constants.BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(gameplayViewport.getCamera().combined);
        batch.begin();
        level.render(batch);

        batch.end();


//        hudViewport.apply();
//        batch.setProjectionMatrix(hudViewport.getCamera().combined);
//        batch.begin();
//        hud.render(batch, level.getGigaGal().getLives(),  level.getGigaGal().getAmmo(), 100);
//        batch.end();

//        onscreenControlsViewport.apply();
//        batch.setProjectionMatrix(onscreenControlsViewport.getCamera().combined);
//        batch.begin();
//        onscreenControls.render(batch);
//        batch.end();

    }

    public void levelComplete() {

    }
}
