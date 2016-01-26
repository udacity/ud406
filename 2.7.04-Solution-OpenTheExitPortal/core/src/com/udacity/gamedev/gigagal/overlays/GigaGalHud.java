package com.udacity.gamedev.gigagal.overlays;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GigaGalHud {

    final BitmapFont font;
    private final Viewport viewport;

    public GigaGalHud(Viewport viewport) {
        this.viewport = viewport;

        font = new BitmapFont();
        font.getData().setScale(2);


    }


    public void render(SpriteBatch batch, int lives, int ammo, int score) {


        font.draw(batch, "Testing HUD drawing!", viewport.getWorldWidth()/4, viewport.getWorldHeight()/4);



    }


}
