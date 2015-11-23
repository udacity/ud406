package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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

    public void render(ShapeRenderer renderer) {
        float width = right - left;
        float height = top - bottom;

        renderer.setColor(Color.BLUE);
        renderer.rect(left, bottom, width, height);

    }

}
