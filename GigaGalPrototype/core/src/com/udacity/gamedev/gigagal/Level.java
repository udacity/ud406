package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    GigaGal gigaGal;
    Array<Platform> platforms;

    public Level(){
        gigaGal = new GigaGal();
        platforms = new Array<Platform>();
        addDebugPlatforms();
    }

    public void update(float delta){
        gigaGal.update(delta, platforms);

    }

    public void render(SpriteBatch batch, ShapeRenderer renderer, Viewport viewport){
        batch.begin();
        for (Platform platform : platforms){
            platform.render(batch);
        }
        gigaGal.render(batch);
        batch.end();
    }

    private void addDebugPlatforms(){
        platforms.add(new Platform(20, 11, 20, 40));
        platforms.add(new Platform(40, 10, 50, 80));
        platforms.add(new Platform(75, 20, 90, 200));
    }
}
