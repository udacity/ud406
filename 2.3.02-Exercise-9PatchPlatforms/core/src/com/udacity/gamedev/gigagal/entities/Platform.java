package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Platform {

    float top;
    float bottom;
    float left;
    float right;

    public Platform(float left, float top, float width, float height) {
        this.top = top;
        this.bottom = top - height;
        this.left = left;
        this.right = left + width;
    }

    public void render(SpriteBatch batch) {
        float width = right - left;
        float height = top - bottom;

        // TODO: Draw the platform using the NinePatch

    }

}
