package com.udacity.gamedev.gigagal.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.Platform;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Utils;


public class GameOverOverlay {

    public final Viewport viewport;
    final BitmapFont font;
    Array<Enemy> enemies;
    long startTime;

    public GameOverOverlay() {
        this.viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(1);
    }

    public void init() {
        startTime = TimeUtils.nanoTime();

        enemies = new Array<Enemy>(Constants.ENEMY_COUNT);

        for (int i = 0; i < Constants.ENEMY_COUNT; i++) {

            Platform fakePlatform = new Platform(
                    MathUtils.random(viewport.getWorldWidth()),
                    MathUtils.random(-Constants.ENEMY_CENTER.y/2, viewport.getWorldHeight()
                    ), 0, 0);

            Enemy enemy = new Enemy(fakePlatform);

            enemies.add(enemy);


        }

    }

    public void render(SpriteBatch batch) {

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        float timeElapsed = Utils.secondsSince(startTime);
        int enemiesToShow = (int) (Constants.ENEMY_COUNT * (timeElapsed / Constants.LEVEL_END_DURATION));

        for (int i = 0; i < enemiesToShow; i++){
            Enemy enemy = enemies.get(i);
            enemy.update(0);
            enemy.render(batch);
        }


        font.draw(batch, Constants.GAME_OVER_MESSAGE, viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2.5f, 0, Align.center, false);

        batch.end();

    }
}
