package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {


    public static final Color BACKGROUND_COLOR = Color.SKY;


    public static final float WORLD_SIZE = 128;



    public static final String STANDING_RIGHT_SPRITE_FILE_NAME = "standing-right.png";
    public static final Vector2 STANDING_RIGHT_EYE_POSITION = new Vector2(11, 16);

    public static final String STANDING_LEFT_SPRITE_FILE_NAME = "standing-left.png";
    public static final Vector2 STANDING_LEFT_EYE_POSITION = new Vector2(13, 16);

    public static final String JUMPING_RIGHT_SPRITE_FILE_NAME = "jumping-right.png";
    public static final Vector2 JUMPING_RIGHT_EYE_POSITION = new Vector2(28, 35);

    public static final String JUMPING_LEFT_SPRITE_FILE_NAME = "jumping-left.png";
    public static final Vector2 JUMPING_LEFT_EYE_POSITION = new Vector2(13, 16);

    public static final String WALKING_RIGHT_SPRITE_FILE_NAME = "walk-2-right.png";
    public static final Vector2 WALKING_RIGHT_EYE_POSITION = new Vector2(13, 16);

    public static final String WALKING_LEFT_SPRITE_FILE_NAME = "walk-2-left.png";
    public static final Vector2 WALKING_LEFT_EYE_POSITION = new Vector2(13, 16);




    public static final float GIGAGAL_HEIGHT = 25.0f;
    public static final float GIGAGAL_EYE_HEIGHT = 16.0f;
    public static final float GIGAGAL_STANCE_WIDTH = 28.0f;
    public static final Vector2 GIGAGAL_GUN_OFFSET = new Vector2(13 ,-7);



    public static final float GIGA_GAL_MOVE_SPEED = WORLD_SIZE / 2;

    public static final float JUMP_SPEED = 1.0f * WORLD_SIZE ;
    public static final float MAX_JUMP_DURATION = .25f;

    public static final float GRAVITY = WORLD_SIZE / 10;
}
