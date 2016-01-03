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
        addDebugPlatforms();
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

    /**
     * TODO: Add more platforms to create a fun jumping challenge!
     *
     * Note that you'll want to add the platforms in the order you want them drawn. That'll
     * generally mean you want the platforms at the top of the screen to be rendered before the ones
     * lower down.
     */
    private void addDebugPlatforms() {
       
    }
}
