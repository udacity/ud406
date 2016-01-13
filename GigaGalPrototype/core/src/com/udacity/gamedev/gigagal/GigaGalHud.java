package com.udacity.gamedev.gigagal;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GigaGalHud {

    BitmapFont font;
    private Viewport viewport;

    public GigaGalHud(Viewport viewport) {
        this.viewport = viewport;

        font = new BitmapFont();
//        font.getData().setScale(10);


    }


    public void render(SpriteBatch batch) {

        font.draw(batch, "I'm totally drawing some shit", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);

    }


}
