package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.udacity.gamedev.gigagal.util.Assets;

public class Enemy  {


    Platform platform;
    float position;
    Direction direction;

    public Enemy(Platform platform){
        this.platform = platform;
        position = platform.left;
        direction = Direction.RIGHT;
    }


    public void update(float delta){

    }


    public void render(SpriteBatch batch){

        batch.draw(Assets.instance.enemyAssets.enemy, position, platform.top);

    }


    enum Direction{
        LEFT, RIGHT
    }

}
