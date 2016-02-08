package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Enums.Direction;
import com.udacity.gamedev.gigagal.util.Utils;


public class Enemy {

    private final Platform platform;
    public Vector2 position;
    private Direction direction;

    // TODO: Add start time


    public Enemy(Platform platform) {
        this.platform = platform;
        direction = Direction.RIGHT;
        position = new Vector2(platform.left, platform.top + Constants.ENEMY_CENTER.y);

        // TODO: Set start time

    }

    public void update(float delta) {
        switch (direction) {
            case LEFT:
                position.x -= Constants.ENEMY_MOVEMENT_SPEED * delta;
                break;
            case RIGHT:
                position.x += Constants.ENEMY_MOVEMENT_SPEED * delta;
        }

        if (position.x < platform.left) {
            position.x = platform.left;
            direction = Direction.RIGHT;
        } else if (position.x > platform.right) {
            position.x = platform.right;
            direction = Direction.LEFT;
        }


        // TODO: Figure out where in the bob cycle we're at
        // bobMultiplier = 1 + sin(2 PI elapsedTime / period)



        // TODO: Set the enemy vertical position
        // y = platformTop + enemyCenter + bobAmplitude * bobMultiplier


    }

    public void render(SpriteBatch batch) {
        final TextureRegion region = Assets.instance.enemyAssets.enemy;
        Utils.drawTextureRegion(batch, region, position, Constants.ENEMY_CENTER);
    }
}
