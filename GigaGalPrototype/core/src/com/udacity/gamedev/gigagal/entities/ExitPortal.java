package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;

/**
 * Created by silver on 12/16/15.
 */
public class ExitPortal {

    public Vector2 position;

    public ExitPortal(Vector2 position){
        this.position = position;
    }

    public void render(SpriteBatch batch) {
        TextureRegion region = Assets.instance.exitPortalAssets.exitPortal;
        Utils.drawTextureRegion(batch, region, position, Constants.EXIT_PORTAL_CENTER);
    }
}

