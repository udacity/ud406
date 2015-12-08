package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();
    Vector2 position;
    Facing facing;

    // TODO: Add a Vector2 for GigaGal's velocity


    // TODO: Add a JumpState


    // TODO: Add a long for jumpStartTime


    public GigaGal() {
        position = new Vector2(20, 20);
        facing = Facing.RIGHT;

        // TODO: Initialize velocity


        // TODO: Initialize JumpState (probably to FALLING)

    }

    public void update(float delta) {

        // TODO: Accelerate GigaGal down
        // Multiple delta by the acceleration due to gravity and subtract it from GG's vertical velocity


        // TODO: Apply GigaGal's velocity to her position
        // Vector2.mulAdd() is very convenient.


        // TODO: If GigaGal isn't JUMPING, make her now FALLING


        // TODO: Check if GigaGal has landed on the ground
        // Remember that position keeps track of GigaGal's eye position, not her feet.
        // If she has indeed landed, change her jumpState to GROUNDED, set her vertical velocity to 0,
        // and make sure her feet aren't sticking into the floor.



        if (Gdx.input.isKeyPressed(Keys.Z)) {
            // TODO: Handle jump key
            // Add a switch statement. If the jump key is pressed and GG is GROUNDED, then startJump()
            // If she's JUMPING, then continueJump()
            // If she's falling, then don't do anything

        } else {
            // TODO: If the jump key wasn't pressed, endJump()

        }

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveLeft(delta);
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveRight(delta);
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
        // TODO: Set jumpState to JUMPING

        // TODO: Set the jump start time
        // Using TimeUtils.nanoTime()

        // TODO: Call continueJump()

    }

    private void continueJump() {
        // TODO: First, check if we're JUMPING, if not, just return

            // TODO: Find out how long we've been jumping

            // TODO: If we have been jumping for less than the max jump duration, set GG's vertical speed to the jump speed constant
            // TODO: Else, call endJump()

    }

    private void endJump() {
        // TODO: If we're JUMPING, now we're FALLING

    }

    public void render(SpriteBatch batch) {

        TextureRegion region;

        if (facing == Facing.RIGHT) {
            region = Assets.instance.gigaGalAssets.standingRight;
        } else {
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

    // TODO: Do this first! Add a JumpState enum containing JUMPING, FALLING, and GROUNDED


    enum Facing {
        LEFT,
        RIGHT
    }
}
