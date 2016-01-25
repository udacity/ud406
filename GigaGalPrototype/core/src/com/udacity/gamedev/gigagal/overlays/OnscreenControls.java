package com.udacity.gamedev.gigagal.overlays;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;


public class OnscreenControls extends InputAdapter {


    public OnscreenControls(Viewport viewport) {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }


    public void render(SpriteBatch batch) {

        Utils.drawTextureRegion(
                batch,
                Assets.instance.onscreenControlsAssets.moveRight,
                Constants.MOVE_RIGHT_CENTER,
                Constants.BUTTON_CENTER
        );

    }


}
