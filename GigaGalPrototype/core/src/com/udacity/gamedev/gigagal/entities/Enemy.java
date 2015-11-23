package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;

/**
 * Created by silver on 11/20/15.
 */
public class Enemy {


    Vector2 position;

    Platform platform;

    public Enemy(Platform platform) {
        this.platform = platform;
    }

    public void update(float delta){

    }

    public void render(SpriteBatch batch){

        TextureRegion region = Assets.instance.enemyAssets.enemy;

        batch.draw(
                region.getTexture(),
                position.x - Constants.ENEMY_CENTER.x,
                position.y - Constants.ENEMY_CENTER.y,
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
