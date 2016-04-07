package com.udacity.gamedev.gigagal.overlays;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.Explosion;
import com.udacity.gamedev.gigagal.util.Constants;

public class VictoryOverlay {

    public final static String TAG = VictoryOverlay.class.getName();
    public final Viewport viewport;
    final BitmapFont font;
    Array<Explosion> explosions;

    public VictoryOverlay() {
        this.viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(1);
    }

    public void init() {
        explosions = new Array<Explosion>(Constants.EXPLOSION_COUNT);

        // TODO: Fill the explosions array with explosions at random locations within the viewport
        // Also, set the offset of each explosion to a random float from 0 -- Constants.LEVEL_END_DURATION

    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        // TODO: Render the explosions/fireworks

        // TODO: Draw a victory message

    }
}
