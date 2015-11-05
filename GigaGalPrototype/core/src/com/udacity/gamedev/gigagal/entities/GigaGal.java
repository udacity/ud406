package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.udacity.gamedev.gigagal.util.Assets;
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
    long walkStartTime;

    long jumpStartTime;

    public GigaGal() {
        position = new Vector2(20, 20);
        lastFramePosition = new Vector2(position);
        velocity = new Vector2();

        jumpState = JumpState.FALLING;
        facing = Facing.RIGHT;
        walkState = WalkState.STANDING;
    }

    public void update(float delta, Array<Platform> platforms) {
        lastFramePosition.set(position);

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


        velocity.y -= Constants.GRAVITY;

        position.mulAdd(velocity, delta);


        if (jumpState != JumpState.JUMPING) {
            jumpState = JumpState.FALLING;

            if (position.y - Constants.GIGAGAL_EYE_HEIGHT < 0) {
                jumpState = JumpState.GROUNDED;
                position.y = Constants.GIGAGAL_EYE_HEIGHT;
                velocity.y = 0;

            }

            for (Platform platform : platforms) {

                if (lastFramePosition.y - Constants.GIGAGAL_EYE_HEIGHT >= platform.top && position.y - Constants.GIGAGAL_EYE_HEIGHT < platform.top) {

                    float leftFoot = position.x - Constants.GIGAGAL_STANCE_WIDTH / 2;
                    float rightFoot = position.x + Constants.GIGAGAL_STANCE_WIDTH / 2;

                    boolean leftFootIn = (platform.left < leftFoot && platform.right > leftFoot);
                    boolean rightFootIn = (platform.left < rightFoot && platform.right > rightFoot);
                    boolean straddle = (platform.left > leftFoot && platform.right < rightFoot);


                    if (leftFootIn || rightFootIn || straddle) {



                        jumpState = JumpState.GROUNDED;
                        velocity.y = 0;
                        position.y = platform.top + Constants.GIGAGAL_EYE_HEIGHT;
                    }



                }
            }




        }


    }

    private void moveLeft(float delta) {
        if (walkState != WalkState.WALKING) {
            walkStartTime = TimeUtils.nanoTime();
        }
        facing = Facing.LEFT;
        walkState = WalkState.WALKING;
        position.x -= delta * Constants.GIGA_GAL_MOVE_SPEED;
    }


    private void moveRight(float delta) {
        if (walkState != WalkState.WALKING) {
            walkStartTime = TimeUtils.nanoTime();
        }
        facing = Facing.RIGHT;
        walkState = WalkState.WALKING;
        position.x += delta * Constants.GIGA_GAL_MOVE_SPEED;
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

    private void fall() {

    }


    public void render(SpriteBatch batch) {


        TextureRegion region = Assets.instance.gigaGalAssets.standingRight;

        switch (facing) {
            case RIGHT:
                switch (jumpState) {
                    case JUMPING:
                    case FALLING:
                        region = Assets.instance.gigaGalAssets.jumpingRight;
                        break;
                    case GROUNDED:
                        switch (walkState) {
                            case STANDING:
                                region = Assets.instance.gigaGalAssets.standingRight;
                                break;
                            case WALKING:
                                float walkTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkStartTime);
                                region = Assets.instance.gigaGalAssets.walkingRightAnimation.getKeyFrame(walkTimeSeconds);
                                break;
                        }
                        break;
                }
                break;
            case LEFT:
                switch (jumpState) {
                    case JUMPING:
                    case FALLING:
                        region = Assets.instance.gigaGalAssets.jumpingLeft;
                        break;
                    case GROUNDED:
                        switch (walkState) {
                            case STANDING:
                                region = Assets.instance.gigaGalAssets.standingLeft;
                                break;
                            case WALKING:
                                float walkTimeSeconds = MathUtils.nanoToSec * (TimeUtils.nanoTime() - walkStartTime);
                                region = Assets.instance.gigaGalAssets.walkingLeftAnimation.getKeyFrame(walkTimeSeconds);
                                break;
                        }
                        break;
                }
                break;

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

    private void renderGigaGal(SpriteBatch batch, Vector2 position, Texture texture) {
        batch.draw(
                texture,
                position.x - Constants.GIGAGAL_EYE_POSITION.x,
                position.y - Constants.GIGAGAL_EYE_POSITION.y,
                texture.getWidth(),
                texture.getHeight()
        );
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
