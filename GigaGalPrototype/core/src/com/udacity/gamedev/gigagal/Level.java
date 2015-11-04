package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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

        renderer.begin(ShapeType.Filled);
        for (Platform platform : platforms){
            platform.render(renderer);
        }
        renderer.end();

        batch.begin();
        gigaGal.render(batch);
        batch.end();


    }


    private void addDebugPlatforms(){
        platforms.add(new Platform(20, 10, 20, 40));
    }

}
