package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();

    Vector2 position;

    public GigaGal() {
        position = new Vector2(20, Constants.GIGAGAL_EYE_HEIGHT);
    }

    public void update(float delta) {

        // TODO: Use Gdx.input.isKeyPressed() to check if the left arrow key is pressed
        // TODO: If so, call moveLeft()


        // TODO: Do the same with the right ArrowKey

    }

    private void moveLeft(float delta) {
        // TODO: Move GigaGal left by delta * movement speed

    }

    private void moveRight(float delta) {
        // TODO: Same for moving GigaGal right

    }

    public void render(SpriteBatch batch) {

        TextureRegion region = Assets.instance.gigaGalAssets.standingRight;

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
}
