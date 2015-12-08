package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Platform {

    // TODO: Add members for the platform top, bottom, left edge, right edge, width, and height

    float top;
    float bottom;
    float left;
    float right;


    public Platform(float left, float top, float width, float height) {
        // TODO: Populate the member variables
        this.top = top;
        this.bottom = top - height;
        this.left = left;
        this.right = left + width;
    }

    public void render(ShapeRenderer renderer) {

        // TODO: Draw a box representing the platform
        float width = right - left;
        float height = top - bottom;

        renderer.setColor(Color.BLUE);
        renderer.rect(left, bottom, width, height);

    }

}
