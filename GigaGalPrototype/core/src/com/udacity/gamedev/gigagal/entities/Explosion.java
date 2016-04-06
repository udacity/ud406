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
    public float offset = 0;

    public Explosion(Vector2 position) {
        this.position = position;
        startTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        if (!isFinished() && !yetToStart()) {
            Utils.drawTextureRegion(
                    batch,
                    Assets.instance.explosionAssets.explosion.getKeyFrame(Utils.secondsSince(startTime) - offset),
                    position.x - Constants.EXPLOSION_CENTER.x,
                    position.y - Constants.EXPLOSION_CENTER.y
            );
        }
    }

    public boolean yetToStart(){
        return Utils.secondsSince(startTime) - offset < 0;
    }

    public boolean isFinished() {
        float elapsedTime = Utils.secondsSince(startTime) - offset;
        return Assets.instance.explosionAssets.explosion.isAnimationFinished(elapsedTime);
    }
}
