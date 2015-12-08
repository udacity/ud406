package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class Level {

    GigaGal gigaGal;

    // TODO: Add an Array of Platforms


    public Level() {
        gigaGal = new GigaGal();

        // TODO: Initialize the platform array


        // TODO: Add a test platform

    }

    public void update(float delta) {
        gigaGal.update(delta);
    }

    public void render(SpriteBatch batch, ShapeRenderer renderer) {

        renderer.begin(ShapeType.Filled);
        // TODO: Render all platforms in the platform array

        renderer.end();

        batch.begin();
        gigaGal.render(batch);
        batch.end();
    }

}
