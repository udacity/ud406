package com.udacity.gamedev.gigagal.overlays;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;


public class OnscreenControls extends InputAdapter {

    private final Viewport viewport;
    private Vector2 moveLeftCenter;
    private Vector2 moveRightCenter;
    private Vector2 shootCenter;
    private Vector2 jumpCenter;
    public OnscreenControls(Viewport viewport) {
        this.viewport = viewport;

        moveLeftCenter = new Vector2();
        moveRightCenter = new Vector2();
        shootCenter = new Vector2();
        jumpCenter = new Vector2();

        recalculateButtonPositions();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }


    public void render(SpriteBatch batch) {

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.moveRight,
                moveLeftCenter,
                Constants.BUTTON_CENTER
        );

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.moveLeft,
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

    }

    public void recalculateButtonPositions() {



        moveLeftCenter.set(Constants.BUTTON_SIZE * 3 / 4 , Constants.BUTTON_SIZE);
        moveRightCenter.set(Constants.BUTTON_SIZE * 2, Constants.BUTTON_SIZE * 3/ 4);

        shootCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_SIZE * 2f,
                Constants.BUTTON_SIZE * 3/4
        );

        jumpCenter.set(
                viewport.getWorldWidth() - Constants.BUTTON_SIZE * 3/4,
                Constants.BUTTON_SIZE
        );

    }

}
