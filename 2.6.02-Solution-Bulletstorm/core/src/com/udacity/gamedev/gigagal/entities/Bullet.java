package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Enums.Direction;
import com.udacity.gamedev.gigagal.util.Utils;

public class Bullet {

    // TODO: Add a Direction
    private final Direction direction;

    // TODO: Add a position
    private Vector2 position;

    public Bullet(Vector2 position, Direction direction) {

        // TODO: Set position and direction
        this.position = position;
        this.direction = direction;

    }

    public void update(float delta) {

        // TODO: Move the bullet the correct amount in the correction direction

        switch (direction) {
            case LEFT:
                position.x -= delta * Constants.BULLET_MOVE_SPEED;
                break;
            case RIGHT:
                position.x += delta * Constants.BULLET_MOVE_SPEED;
                break;
        }

    }

    public void render(SpriteBatch batch) {
        // TODO: Complete render function

        TextureRegion region = Assets.instance.bulletAssets.bullet;
        Utils.drawTextureRegion(batch, region, position, Constants.BULLET_CENTER);
    }
}
