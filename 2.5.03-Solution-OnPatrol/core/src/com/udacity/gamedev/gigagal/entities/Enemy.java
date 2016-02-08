package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Enums.Direction;
import com.udacity.gamedev.gigagal.util.Utils;


public class Enemy {

    private final Platform platform;
    public Vector2 position;

    // TODO: Add a Direction
    private Direction direction;
    final long startTime;

    public Enemy(Platform platform) {
        this.platform = platform;

        // TODO: Initialize direction (to RIGHT)
        direction = Direction.RIGHT;
        position = new Vector2(platform.left, platform.top + Constants.ENEMY_CENTER.y);
        startTime = TimeUtils.nanoTime();
    }

    public void update(float delta) {

        // TODO: Move the enemy left/right the appropriate amount
        // Using the delta time and the newly created enemy movement speed constant

        switch (direction) {
            case LEFT:
                position.x -= Constants.ENEMY_MOVEMENT_SPEED * delta;
                break;
            case RIGHT:
                position.x += Constants.ENEMY_MOVEMENT_SPEED * delta;
        }

        // TODO: If the enemy is off the left side of the platform, set the enemy moving back to the right
        // Should also probably put the enemy back on the edge of the platform

        // TODO: If the enemy if off the right side of the platform, set the enemy moving back to the left
        if (position.x < platform.left) {
            position.x = platform.left;
            direction = Direction.RIGHT;
        } else if (position.x > platform.right) {
            position.x = platform.right;
            direction = Direction.LEFT;
        }

    }

    public void render(SpriteBatch batch) {
        final TextureRegion region = Assets.instance.enemyAssets.enemy;
        Utils.drawTextureRegion(batch, region, position, Constants.ENEMY_CENTER);
    }
}
