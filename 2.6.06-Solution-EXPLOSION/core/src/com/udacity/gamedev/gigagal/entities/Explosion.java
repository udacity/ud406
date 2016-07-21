package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;

public class Explosion {

    // TODO: Add a Vector2 position
    private final Vector2 position;

    // TODO: Add a long startTime
    private final long startTime;

    public Explosion(Vector2 position) {
        // TODO: Save the spawn position
        this.position = position;

        // TODO: Save off the start time
        startTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        // TODO: Select and draw the appropriate frame of the explosion animation
        // Remember to use Utils.drawTextureRegion() and Utils.secondsSince()
        Utils.drawTextureRegion(
                batch,
                Assets.instance.explosionAssets.explosion.getKeyFrame(Utils.secondsSince(startTime)),
                position,
                Constants.EXPLOSION_CENTER
        );
    }

    public boolean isFinished() {
        // TODO: Use Animation.isAnimationFinished() to find out if the explosion is done
        final float elapsedTime = Utils.secondsSince(startTime);
        return Assets.instance.explosionAssets.explosion.isAnimationFinished(elapsedTime);
    }
}
