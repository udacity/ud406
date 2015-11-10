package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
        gigaGal.update(delta);
    }

    public void render(SpriteBatch batch, ShapeRenderer renderer) {

        renderer.begin(ShapeType.Filled);
        for (Platform platform : platforms) {
            platform.render(renderer);
        }
        renderer.end();

        batch.begin();
        gigaGal.render(batch);
        batch.end();
    }

}
