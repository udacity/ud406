package com.udacity.gamedev.gigagal.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;


public class OnscreenControls extends InputAdapter {

    public static final String TAG = OnscreenControls.class.getName();

    public final Viewport viewport;
    public GigaGal gigaGal;
    private Vector2 moveLeftCenter;
    private Vector2 moveRightCenter;
    private Vector2 shootCenter;
    private Vector2 jumpCenter;
    private int moveLeftPointer;
    private int moveRightPointer;
    private int jumpPointer;

    public OnscreenControls() {
        this.viewport = new ExtendViewport(
                Constants.ONSCREEN_CONTROLS_VIEWPORT_SIZE,
                Constants.ONSCREEN_CONTROLS_VIEWPORT_SIZE);


        moveLeftCenter = new Vector2();
        moveRightCenter = new Vector2();
        shootCenter = new Vector2();
        jumpCenter = new Vector2();

        recalculateButtonPositions();
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector2 viewportPosition = viewport.unproject(new Vector2(screenX, screenY));

        if (viewportPosition.dst(shootCenter) < Constants.BUTTON_RAIDUS) {

            // TODO: Call shoot() on GigaGal

        } else if (viewportPosition.dst(jumpCenter) < Constants.BUTTON_RAIDUS) {

            // TODO: Save the jumpPointer and set gigaGal.jumpButtonPressed = true

        } else if (viewportPosition.dst(moveLeftCenter) < Constants.BUTTON_RAIDUS) {

            // TODO: Save the moveLeftPointer, and set gigaGal.leftButtonPressed = true

        } else if (viewportPosition.dst(moveRightCenter) < Constants.BUTTON_RAIDUS) {

            // TODO: Save the moveRightPointer, and set gigaGal.rightButtonPressed = true

        }

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 viewportPosition = viewport.unproject(new Vector2(screenX, screenY));

        if (pointer == moveLeftPointer && viewportPosition.dst(moveRightCenter) < Constants.BUTTON_RAIDUS) {

            // TODO: Handle the case where the left button touch has been dragged to the right button
            // Inform GigaGal that the left button is no longer pressed

            // Inform GigaGal that the right button is now pressed

            // Zero moveLeftPointer

            // Save moveRightPointer

        }

        if (pointer == moveRightPointer && viewportPosition.dst(moveLeftCenter) < Constants.BUTTON_RAIDUS) {

            // TODO: Handle the case where the right button touch has been dragged to the left button

        }

        return super.touchDragged(screenX, screenY, pointer);
    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        if (!Gdx.input.isTouched(jumpPointer)) {
            gigaGal.jumpButtonPressed = false;
            jumpPointer = 0;
        }

        // TODO: If the moveLeftPointer is no longer touched, inform GigaGal and zero moveLeftPointer

        // TODO: Do the same for moveRightPointer

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.moveLeft,
                moveLeftCenter,
                Constants.BUTTON_CENTER
        );

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.moveRight,
                moveRightCenter,
                Constants.BUTTON_CENTER
        );

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.shoot,
                shootCenter,
                Constants.BUTTON_CENTER
        );

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.jump,
                jumpCenter,
                Constants.BUTTON_CENTER
        );
        batch.end();
    }

    public void recalculateButtonPositions() {
        moveLeftCenter.set(Constants.BUTTON_RAIDUS * 3 / 4, Constants.BUTTON_RAIDUS);
        moveRightCenter.set(Constants.BUTTON_RAIDUS * 2, Constants.BUTTON_RAIDUS * 3 / 4);
        shootCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_RAIDUS * 2f,
                Constants.BUTTON_RAIDUS * 3 / 4
        );
        jumpCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_RAIDUS * 3 / 4,
                Constants.BUTTON_RAIDUS
        );
    }
}
