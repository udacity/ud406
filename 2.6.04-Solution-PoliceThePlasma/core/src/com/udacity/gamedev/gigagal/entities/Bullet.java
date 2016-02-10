package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.Level;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Enums.Direction;
import com.udacity.gamedev.gigagal.util.Utils;

public class Bullet {

    private final Direction direction;
    private final Level level;

    // TODO: Add boolean active flag
    public boolean active;

    private Vector2 position;

    public Bullet(Level level, Vector2 position, Direction direction) {
        this.level = level;
        this.position = position;
        this.direction = direction;

        // TODO: Set active to true
        active = true;
    }

    public void update(float delta) {
        switch (direction) {
            case LEFT:
                position.x -= delta * Constants.BULLET_MOVE_SPEED;
                break;
            case RIGHT:
                position.x += delta * Constants.BULLET_MOVE_SPEED;
                break;
        }

        // TODO: Get the world width from the level's viewport
        final float worldWidth = level.getViewport().getWorldWidth();

        // TODO: Get the level's viewport's camera's horizontal position
        final float cameraX = level.getViewport().getCamera().position.x;

        // TODO: If the bullet is offscreen, set active = false
        if (position.x < cameraX - worldWidth / 2 || position.x > cameraX + worldWidth / 2) {
            active = false;
        }
    }

    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.bulletAssets.bullet;
        Utils.drawTextureRegion(batch, region, position, Constants.BULLET_CENTER);
    }
}
