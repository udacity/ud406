package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {

    // World/Camera
    public static final Color BACKGROUND_COLOR = Color.SKY;
    public static final float WORLD_SIZE = 160;
    public static final float KILL_PLANE = -100;
    public static final float GRAVITY = 10;
    public static final float CHASE_CAM_MOVE_SPEED = WORLD_SIZE;

    public static final String TEXTURE_ATLAS = "images/gigagal.pack.atlas";


    // GigaGal
    public static final Vector2 GIGAGAL_EYE_POSITION = new Vector2(16, 24);
    public static final float GIGAGAL_EYE_HEIGHT = 16.0f;
    public static final float GIGAGAL_STANCE_WIDTH = 21.0f;

    // TODO: Add constant for offset between GigaGal's eye position, and the barrel of her cannon
    // Looks to be about (12, -7) to me
    public static final Vector2 GIGAGAL_CANNON_OFFSET = new Vector2(12, -7);
    public static final float GIGAGAL_HEIGHT = 23.0f;
    public static final float GIGAGAL_MOVE_SPEED = 100;

    public static final float JUMP_SPEED = 200;
    public static final Vector2 KNOCKBACK_VELOCITY = new Vector2(200, 200);
    public static final float MAX_JUMP_DURATION = .1f;

    public static final String STANDING_RIGHT = "standing-right";
    public static final String STANDING_LEFT = "standing-left";
    public static final String JUMPING_RIGHT = "jumping-right";
    public static final String JUMPING_LEFT = "jumping-left";
    public static final String WALKING_RIGHT_1 = "walk-1-right";
    public static final String WALKING_LEFT_1 = "walk-1-left";
    public static final String WALKING_RIGHT_2 = "walk-2-right";
    public static final String WALKING_LEFT_2 = "walk-2-left";
    public static final String WALKING_RIGHT_3 = "walk-3-right";
    public static final String WALKING_LEFT_3 = "walk-3-left";
    public static final float WALK_LOOP_DURATION = 0.25f;

    // Platform
    public static final String PLATFORM_SPRITE = "platform";
    public static final int PLATFORM_EDGE = 8;

    // Enemy
    public static final String ENEMY_SPRITE = "enemy";
    public static final Vector2 ENEMY_CENTER = new Vector2(14, 22);
    public static final float ENEMY_MOVEMENT_SPEED = 10;
    public static final float ENEMY_BOB_AMPLITUDE = 2;
    public static final float ENEMY_BOB_PERIOD = 3.0f;
    public static final float ENEMY_COLLISION_RADIUS = 15;

    // Bullet
    public static final String BULLET_SPRITE = "bullet";
    public static final float BULLET_MOVE_SPEED = 150;
    public static final Vector2 BULLET_CENTER = new Vector2(3, 2);


    // Explosion
    public static final String EXPLOSION_LARGE = "explosion-large";
    public static final String EXPLOSION_MEDIUM = "explosion-medium";
    public static final String EXPLOSION_SMALL = "explosion-small";
    public static final Vector2 EXPLOSION_CENTER = new Vector2(8, 8);
    public static final float EXPLOSION_DURATION = 0.5f;

    // Powerup
    public static final String POWERUP_SPRITE = "powerup";

}
