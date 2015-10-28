package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Constants;

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();

    Vector2 position;
    Vector2 lastFramePosition;
    Vector2 velocity;

    GigaGalSprite standingRight;
    GigaGalSprite standingLeft;
    GigaGalSprite jumpingRight;
    GigaGalSprite jumpingLeft;
    GigaGalSprite walkingRight;
    GigaGalSprite walkingLeft;


    Facing facing;
    JumpState jumpState;
    WalkState walkState;

    long jumpStartTime;

    public GigaGal() {
        position = new Vector2(20, 20);
        lastFramePosition = position;
        velocity = new Vector2();
        standingRight = new GigaGalSprite(Constants.STANDING_RIGHT_SPRITE_FILE_NAME, Constants.STANDING_RIGHT_EYE_POSITION);

        standingLeft = new GigaGalSprite(Constants.STANDING_LEFT_SPRITE_FILE_NAME, Constants.STANDING_LEFT_EYE_POSITION);
        jumpingRight = new GigaGalSprite(Constants.JUMPING_RIGHT_SPRITE_FILE_NAME, Constants.JUMPING_RIGHT_EYE_POSITION);
        jumpingLeft = new GigaGalSprite(Constants.JUMPING_LEFT_SPRITE_FILE_NAME, Constants.JUMPING_LEFT_EYE_POSITION);

        walkingRight = new GigaGalSprite(Constants.WALKING_RIGHT_SPRITE_FILE_NAME, Constants.WALKING_RIGHT_EYE_POSITION);
        walkingLeft = new GigaGalSprite(Constants.WALKING_LEFT_SPRITE_FILE_NAME, Constants.WALKING_LEFT_EYE_POSITION);

        jumpState = JumpState.FALLING;
        facing = Facing.RIGHT;
        walkState = WalkState.STANDING;
    }

    public void update(float delta, Array<Platform> platforms) {
        lastFramePosition = position;

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveLeft(delta);
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveRight(delta);
        } else {
            walkState = WalkState.STANDING;
        }

        if (Gdx.input.isKeyPressed(Keys.Z)) {
            switch (jumpState) {
                case GROUNDED:
                    startJump();
                    break;
                case JUMPING:
                    continueJump();
            }
        } else {
            endJump();
        }

        if (jumpState == JumpState.FALLING) {
//            Gdx.app.log(TAG, "Falling");
            velocity.y -= Constants.GRAVITY;
        }

        position.mulAdd(velocity, delta);

        if (position.y - Constants.GIGAGAL_EYE_HEIGHT < 0) {
            jumpState = JumpState.GROUNDED;
            position.y = Constants.GIGAGAL_EYE_HEIGHT;

        }

        for (Platform platform : platforms){
            if (lastFramePosition.y > platform.top && position.y < platform.top){
                float leftFoot = position.x - Constants.g




            }
        }



    }

    private void moveLeft(float delta) {
        position.x -= delta * Constants.GIGA_GAL_MOVE_SPEED;
        facing = Facing.LEFT;
        walkState = WalkState.WALKING;

    }


    private void moveRight(float delta) {
        position.x += delta * Constants.GIGA_GAL_MOVE_SPEED;
        facing = Facing.RIGHT;
        walkState = WalkState.WALKING;
    }


    private void startJump() {
        jumpState = JumpState.JUMPING;
        velocity.y = Constants.JUMP_SPEED;
        jumpStartTime = TimeUtils.nanoTime();
    }

    private void continueJump() {
        if (jumpState == JumpState.JUMPING) {
            float jumpDuration = MathUtils.nanoToSec * (TimeUtils.nanoTime() - jumpStartTime);
            if (jumpDuration < Constants.MAX_JUMP_DURATION) {
                velocity.y = Constants.JUMP_SPEED;
            } else {
                endJump();
            }
        }
    }

    private void endJump() {
        if (jumpState == JumpState.JUMPING) {
            jumpState = JumpState.FALLING;
        }
    }

    private void fall() {

    }


    public void render(SpriteBatch batch) {


        switch (facing){
            case RIGHT:
                switch (jumpState){
                    case JUMPING:
                    case FALLING:
                        jumpingRight.render(batch, position);
                        break;
                    case GROUNDED:
                        switch (walkState){
                            case STANDING:
                                standingRight.render(batch, position);
                                break;
                            case WALKING:
                                walkingRight.render(batch, position);
                                break;
                        }
                        break;
                }
                break;
            case LEFT:
                switch (jumpState){
                    case JUMPING:
                    case FALLING:
                        jumpingLeft.render(batch, position);
                        break;
                    case GROUNDED:
                        switch (walkState){
                            case STANDING:
                                standingLeft.render(batch, position);
                                break;
                            case WALKING:
                                walkingLeft.render(batch, position);
                                break;
                        }
                        break;
                }
                break;

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

    enum WalkState {
        STANDING,
        WALKING
    }


    class GigaGalSprite {
        Texture texture;
        Vector2 eyePosition;

        public GigaGalSprite(String textureFileName, Vector2 eyePosition) {

            this.texture = new Texture(textureFileName);
            this.eyePosition = eyePosition;
        }


        public void render(SpriteBatch batch, Vector2 position) {
            batch.draw(
                    texture,
                    position.x - eyePosition.x,
                    position.y - eyePosition.y,
                    texture.getWidth(),
                    texture.getHeight()
            );
        }
    }

}
