package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Explosion {

    // TODO: Add a Vector2 position


    // TODO: Add a long startTime


    public Explosion(Vector2 position) {
        // TODO: Save the spawn position


        // TODO: Save off the start time

    }

    public void render(SpriteBatch batch) {
        // TODO: Select and draw the appropriate frame of the explosion animation
        // Remember to use Utils.drawTextureRegion() and Utils.secondsSince()

    }

    public boolean isFinished() {
        // TODO: Use Animation.isAnimationFinished() to find out if the explosion is done

        return false;
    }
}
