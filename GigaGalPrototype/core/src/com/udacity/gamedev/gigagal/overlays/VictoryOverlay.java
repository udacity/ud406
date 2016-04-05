package com.udacity.gamedev.gigagal.overlays;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.util.Constants;

public class VictoryOverlay {

    public final static String TAG = VictoryOverlay.class.getName();

    final BitmapFont font;
    public final Viewport viewport;

    public VictoryOverlay() {
        this.viewport = new ExtendViewport(Constants.HUD_VIEWPORT_SIZE, Constants.HUD_VIEWPORT_SIZE);

        font = new BitmapFont();
        font.getData().setScale(1);
    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        Gdx.app.log(TAG, "Drawing victory screen");

        font.draw(batch, "You are the winrar!", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);

        batch.end();

    }
}
