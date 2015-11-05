package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.udacity.gamedev.gigagal.util.Assets;

/**
 * Created by silver on 10/26/15.
 */
public class Platform {

    private static final Color PLATFORM_COLOR = Color.BLUE;


    float top;
    float bottom;
    float left;
    float right;


    public Platform(float top, float bottom, float left, float right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public void render(SpriteBatch batch) {

        float width = right - left;
        float height = top - bottom;

        Assets.instance.platformAssets.platformNinePatch.draw(batch, left - 1, bottom - 1, width + 2, height + 2);

    }


}
