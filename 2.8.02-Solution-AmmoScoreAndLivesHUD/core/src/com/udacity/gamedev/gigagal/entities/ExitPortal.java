package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;

public class ExitPortal {

    public final static String TAG = ExitPortal.class.getName();

    public final Vector2 position;

    private final long startTime;

    public ExitPortal(Vector2 position) {
        this.position = position;
        startTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        final float elapsedTime = Utils.secondsSince(startTime);
        final TextureRegion region = Assets.instance.exitPortalAssets.exitPortal.getKeyFrame(elapsedTime, true);
        Utils.drawTextureRegion(batch, region, position, Constants.EXIT_PORTAL_CENTER);
    }



}

