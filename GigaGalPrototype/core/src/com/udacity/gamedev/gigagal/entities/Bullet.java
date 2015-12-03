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

    final Direction direction;
    public Vector2 position;
    public boolean active;

    Level level;

    public Bullet(Level level, Vector2 position, Direction direction) {
        this.level = level;
        this.position = position;
        this.direction = direction;
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

        for (Enemy enemy : level.enemies){

            if (position.dst(enemy.position) < Constants.ENEMY_RADIUS){
                level.spawnExplosion(position);
                active = false;
                enemy.health -= 1;
            }
        }

        if (position.x < level.viewport.getScreenX() ||
                position.y > level.viewport.getScreenX() + level.viewport.getWorldWidth()) {
            active = false;
        }
    }


    public void render(SpriteBatch batch) {

        TextureRegion region = Assets.instance.bulletAssets.bullet;

        Utils.drawTextureRegion(batch, region, position, Constants.BULLET_CENTER);


    }


}
