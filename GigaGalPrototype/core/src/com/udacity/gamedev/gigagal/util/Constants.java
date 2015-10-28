package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by silver on 10/14/15.
 */
public class Constants {


    public static final Color BACKGROUND_COLOR = Color.SKY;


    public static final float WORLD_SIZE = 128;



    public static final float STANDING_FACING_RIGHT_SPRITE_LEFT_MARGIN = 0.0f;
    public static final float STANDING_FACING_RIGHT_SPRITE_BOTTOM_MARGIN = 0.0f;

    public static final float STANDING_FACING_LEFT_SPRITE_LEFT_MARGIN = 2.0f;
    public static final float STANDING_FACING_LEFT_SPRITE_BOTTOM_MARGIN = 0.0f;




    public static final float GIGA_GAL_STANDING_HEIGHT = 28.0f;



    public static final float GIGA_GAL_MOVE_SPEED = WORLD_SIZE / 2;

    public static final float JUMP_SPEED = 1.0f * WORLD_SIZE ;
    public static final float MAX_JUMP_DURATION = .25f;

    public static final float GRAVITY = WORLD_SIZE / 10;
}
