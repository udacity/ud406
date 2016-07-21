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

        if (viewportPosition.dst(shootCenter) < Constants.BUTTON_RADIUS) {
            gigaGal.shoot();
        } else if (viewportPosition.dst(jumpCenter) < Constants.BUTTON_RADIUS) {
            jumpPointer = pointer;
            gigaGal.jumpButtonPressed = true;
        } else if (viewportPosition.dst(moveLeftCenter) < Constants.BUTTON_RADIUS) {
            moveLeftPointer = pointer;
            gigaGal.leftButtonPressed = true;
        } else if (viewportPosition.dst(moveRightCenter) < Constants.BUTTON_RADIUS) {
            moveRightPointer = pointer;
            gigaGal.rightButtonPressed = true;
        }

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 viewportPosition = viewport.unproject(new Vector2(screenX, screenY));

        if (pointer == moveLeftPointer && viewportPosition.dst(moveRightCenter) < Constants.BUTTON_RADIUS) {
            gigaGal.leftButtonPressed = false;
            moveLeftPointer = 0;

            moveRightPointer = pointer;
            gigaGal.rightButtonPressed = true;
        }

        if (pointer == moveRightPointer && viewportPosition.dst(moveLeftCenter) < Constants.BUTTON_RADIUS) {
            gigaGal.rightButtonPressed = false;
            moveRightPointer = 0;

            moveLeftPointer = pointer;
            gigaGal.leftButtonPressed = true;
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

        if (!Gdx.input.isTouched(moveLeftPointer)) {
            gigaGal.leftButtonPressed = false;
            moveLeftPointer = 0;
        }

        if (!Gdx.input.isTouched(moveRightPointer)) {
            gigaGal.rightButtonPressed = false;
            moveRightPointer = 0;
        }

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


        moveLeftCenter.set(Constants.BUTTON_RADIUS * 3 / 4, Constants.BUTTON_RADIUS);
        moveRightCenter.set(Constants.BUTTON_RADIUS * 2, Constants.BUTTON_RADIUS * 3 / 4);

        shootCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_RADIUS * 2f,
                Constants.BUTTON_RADIUS * 3 / 4
        );

        jumpCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_RADIUS * 3 / 4,
                Constants.BUTTON_RADIUS
        );

    }

}
