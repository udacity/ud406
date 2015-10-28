package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Constants;

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();

    Vector2 position;
    Vector2 velocity;
    Texture standingRight;
    Texture standingLeft;

    Facing facing;
    JumpState jumpState;
    long jumpStartTime;

    public GigaGal(){
        position = new Vector2();
        velocity = new Vector2();
        standingRight = new Texture("standingRight.png");
        standingLeft = new Texture("standingLeft.png");

        jumpState = JumpState.GROUNDED;
        facing = Facing.RIGHT;
    }

    public void update(float delta){
        if (Gdx.input.isKeyPressed(Keys.LEFT)){
            moveLeft(delta);
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)){
            moveRight(delta);
        }

        if (Gdx.input.isKeyPressed(Keys.Z)){
            switch (jumpState){
                case GROUNDED:
                    startJump();
                    break;
                case JUMPING:
                    continueJump();
            }
        } else {
            endJump();
        }

        if (jumpState == JumpState.FALLING){
//            Gdx.app.log(TAG, "Falling");
            velocity.y -= Constants.GRAVITY;
        }

        position.mulAdd(velocity, delta);

        if (position.y < 0){
            jumpState = JumpState.GROUNDED;
            position.y = 0;

        }

    }

    private void moveLeft(float delta){
        position.x -= delta * Constants.GIGA_GAL_MOVE_SPEED;
        facing = Facing.LEFT;

    }


    private void moveRight(float delta){
        position.x += delta * Constants.GIGA_GAL_MOVE_SPEED;
        facing = Facing.RIGHT;
    }



    private void startJump(){
        jumpState = JumpState.JUMPING;
        velocity.y = Constants.JUMP_SPEED;
        jumpStartTime = TimeUtils.nanoTime();
    }

    private void continueJump(){
        if (jumpState == JumpState.JUMPING) {
            float jumpDuration = MathUtils.nanoToSec * (TimeUtils.nanoTime() - jumpStartTime);
            if (jumpDuration < Constants.MAX_JUMP_DURATION) {
                velocity.y = Constants.JUMP_SPEED;
            } else {
                endJump();
            }
        }
    }

    private void endJump(){
        if (jumpState == JumpState.JUMPING){
            jumpState = JumpState.FALLING;
        }
    }

    private void fall(){

    }




    public void render(SpriteBatch batch){

        switch (facing){
            case RIGHT:
                batch.draw(
                        standingRight,
                        position.x - Constants.STANDING_FACING_RIGHT_SPRITE_LEFT_MARGIN,
                        position.y - Constants.STANDING_FACING_RIGHT_SPRITE_BOTTOM_MARGIN,
                        standingRight.getWidth(),
                        standingRight.getHeight()
                );
                break;
            case LEFT:
                batch.draw(
                        standingLeft,
                        position.x - Constants.STANDING_FACING_LEFT_SPRITE_LEFT_MARGIN,
                        position.y - Constants.STANDING_FACING_LEFT_SPRITE_BOTTOM_MARGIN,
                        standingLeft.getWidth(),
                        standingLeft.getHeight()
                );

        }


    }





    enum JumpState {
        JUMPING,
        FALLING,
        GROUNDED
    }

    enum Facing {
        LEFT,
        RIGHT
    }

}
