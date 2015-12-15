package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    GigaGal gigaGal;
    Array<Platform> platforms;

    public Level() {
        platforms = new Array<Platform>();
        initDebugLevel();
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

    private void initDebugLevel() {
        platforms.add(new Platform(15, 100, 30, 20));
        platforms.add(new Platform(75, 90, 100, 65));
        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));

        gigaGal = new GigaGal(new Vector2(15, 40));

    }
}
