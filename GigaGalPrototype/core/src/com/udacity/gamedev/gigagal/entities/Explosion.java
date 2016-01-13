package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;

public class Explosion {

    private final Vector2 position;
    private final long startTime;

    public Explosion(Vector2 position) {
        this.position = position;
        startTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        Utils.drawTextureRegion(
                batch,
                Assets.instance.explosionAssets.explosion.getKeyFrame(Utils.secondsSince(startTime)),
                position.x - Constants.EXPLOSION_CENTER.x,
                position.y - Constants.EXPLOSION_CENTER.y
        );
    }

    public boolean isFinished() {
        final float elapsedTime = Utils.secondsSince(startTime);
        return Assets.instance.explosionAssets.explosion.isAnimationFinished(elapsedTime);
    }
}
