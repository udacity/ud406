package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Enums.Direction;

public class Bullet {

    Vector2 position;

    Vector2 velocity;

    final Direction direction;

    public Bullet(Vector2 position, Direction direction) {
        this.position = position;
        this.direction = direction;

        if (direction == Direction.RIGHT){
            velocity = new Vector2(Constants.BULLET_MOVE_SPEED, 0);
        } else {
            velocity = new Vector2(-Constants.BULLET_MOVE_SPEED, 0);
        }

    }

    public void update(float delta, Array<Enemy> enemies){

        position.mulAdd(velocity, delta);

//        for (Enemy enemy : enemies){
//
//
//
//            if (position)
//        }


    }


    public void render(SpriteBatch batch){

        TextureRegion region = Assets.instance.bulletAssets.bullet;
        batch.draw(
                region.getTexture(),
                position.x - Constants.BULLET_CENTER.x,
                position.y - Constants.BULLET_CENTER.y,
                0,
                0,
                region.getRegionWidth(),
                region.getRegionHeight(),
                1,
                1,
                0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false,
                false);

    }


}
