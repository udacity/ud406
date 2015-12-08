package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final Color BACKGROUND_COLOR = Color.SKY;

    public static final float WORLD_SIZE = 128;
    public static final String TEXTURE_ATLAS = "images/gigagal.pack.atlas";

    public static final String STANDING_RIGHT = "standing-right";
    public static final String STANDING_LEFT = "standing-left";

    // TODO: Add constants for the jumping-right and jumping-left sprites
    public static final String JUMPING_RIGHT = "jumping-right";
    public static final String JUMPING_LEFT = "jumping-left";

    public static final Vector2 GIGAGAL_EYE_POSITION = new Vector2(16, 24);
    public static final float GIGAGAL_EYE_HEIGHT = 16.0f;

    public static final float GIGAGAL_MOVE_SPEED = WORLD_SIZE / 2;

    public static final float JUMP_SPEED = 1.5f * WORLD_SIZE;
    public static final float MAX_JUMP_DURATION = .1f;

    public static final float GRAVITY = WORLD_SIZE / 10;
}
