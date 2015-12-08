package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();

    Vector2 position;
    Vector2 lastFramePosition;
    Vector2 velocity;

    Facing facing;
    JumpState jumpState;

    long jumpStartTime;

    public GigaGal() {
        position = new Vector2(20, 20);
        lastFramePosition = new Vector2(position);
        velocity = new Vector2();
        jumpState = JumpState.FALLING;
        facing = Facing.RIGHT;
    }

    public void update(float delta) {
        lastFramePosition.set(position);
        velocity.y -= Constants.GRAVITY;
        position.mulAdd(velocity, delta);

        if (jumpState != JumpState.JUMPING) {
            jumpState = JumpState.FALLING;

            if (position.y - Constants.GIGAGAL_EYE_HEIGHT < 0) {
                jumpState = JumpState.GROUNDED;
                position.y = Constants.GIGAGAL_EYE_HEIGHT;
                velocity.y = 0;
            }

        }

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveLeft(delta);
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveRight(delta);
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
    }

    private void moveLeft(float delta) {
        facing = Facing.LEFT;
        position.x -= delta * Constants.GIGAGAL_MOVE_SPEED;
    }

    private void moveRight(float delta) {
        facing = Facing.RIGHT;
        position.x += delta * Constants.GIGAGAL_MOVE_SPEED;
    }

    private void startJump() {
        jumpState = JumpState.JUMPING;
        jumpStartTime = TimeUtils.nanoTime();
        continueJump();
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

    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.gigaGalAssets.standingRight;

        // TODO: Select the correct region based on facing and jumpState
        if (facing == Facing.RIGHT && jumpState != JumpState.GROUNDED) {
            region = Assets.instance.gigaGalAssets.jumpingRight;
        } else if (facing == Facing.RIGHT) {
            region = Assets.instance.gigaGalAssets.standingRight;
        } else if (facing == Facing.LEFT && jumpState != JumpState.GROUNDED) {
            region = Assets.instance.gigaGalAssets.jumpingLeft;
        } else if (facing == Facing.LEFT) {
            region = Assets.instance.gigaGalAssets.standingLeft;
        }

        batch.draw(
                region.getTexture(),
                position.x - Constants.GIGAGAL_EYE_POSITION.x,
                position.y - Constants.GIGAGAL_EYE_POSITION.y,
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
