package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final Color BACKGROUND_COLOR = Color.SKY;

    public static final float WORLD_SIZE = 128;
    public static final String TEXTURE_ATLAS = "images/gigagal.pack.atlas";

    public static final String STANDING_RIGHT = "standing-right";
    public static final String STANDING_LEFT = "standing-left";

    public static final Vector2 GIGAGAL_EYE_POSITION = new Vector2(16, 24);
    public static final float GIGAGAL_EYE_HEIGHT = 16.0f;

    public static final float GIGAGAL_MOVE_SPEED = WORLD_SIZE / 2;

    // TODO: Add constant for GigaGal's jump speed
    // Something around 250 works well.
    public static final float JUMP_SPEED = 250;

    // TODO: Add constant for GigaGal's max jump duration
    // Meaning how long you can hold the jump key to continue to jump higher. 0.15 seconds works well
    public static final float MAX_JUMP_DURATION = .15f;

    // TODO: Add constant for acceleration due to gravity
    // Something like 1000 works well.
    public static final float GRAVITY = 1000;
}
