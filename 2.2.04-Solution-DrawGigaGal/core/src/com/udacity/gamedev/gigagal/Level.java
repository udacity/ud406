package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class Level {

    // TODO: Add a GigaGal member variable
    GigaGal gigaGal;

    public Level() {
        // TODO: Initialize GigaGal
        gigaGal = new GigaGal();
    }

    public void update(float delta) {
        // TODO: Update GigaGal
        gigaGal.update(delta);
    }

    public void render(SpriteBatch batch) {
        // TODO: Render GigaGal
        gigaGal.render(batch);
    }

}
