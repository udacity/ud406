package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

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

    public void render(ShapeRenderer renderer){
        renderer.set(ShapeType.Filled);
        renderer.setColor(PLATFORM_COLOR);

        renderer.rect(left, bottom, right - left, top - bottom);

    }


}
