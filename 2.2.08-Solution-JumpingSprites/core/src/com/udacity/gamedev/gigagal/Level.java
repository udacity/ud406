package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class Level {

    GigaGal gigaGal;

    public Level() {
        gigaGal = new GigaGal();
    }

    public void update(float delta) {
        gigaGal.update(delta);
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        gigaGal.render(batch);
        batch.end();
    }

}
