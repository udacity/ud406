package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    GigaGal gigaGal;
    Array<Platform> platforms;

    public Level() {
        gigaGal = new GigaGal();
        platforms = new Array<Platform>();

        platforms.add(new Platform(70, 30, 20, 20));
    }

    public void update(float delta) {
        gigaGal.update(delta, platforms);
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        for (Platform platform : platforms) {
            platform.render(batch);
        }
        gigaGal.render(batch);
        batch.end();
    }

}
