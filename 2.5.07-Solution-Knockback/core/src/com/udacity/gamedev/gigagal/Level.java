package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    public static final String TAG = Level.class.getName();

    public Viewport viewport;

    public GigaGal gigaGal;
    public Array<Platform> platforms;
    public DelayedRemovalArray<Enemy> enemies;

    public Level(Viewport viewport) {
        this.viewport = viewport;
        initializeDebugLevel();
    }

    public void update(float delta) {

        // Update GigaGal
        gigaGal.update(delta, platforms);

        // Update Enemies
        enemies.begin();
        for (int i = 0; i < enemies.size; i++) {
            Enemy enemy = enemies.get(i);
            enemy.update(delta);
        }
        enemies.end();

    }

    public void render(SpriteBatch batch) {
        batch.begin();
        for (Platform platform : platforms) {
            platform.render(batch);
        }

        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }

        gigaGal.render(batch);

        batch.end();
    }

    private void initializeDebugLevel() {

        gigaGal = new GigaGal(new Vector2(15, 40), this);

        platforms = new Array<Platform>();

        enemies = new DelayedRemovalArray<Enemy>();

        platforms.add(new Platform(15, 100, 30, 20));

        Platform enemyPlatform = new Platform(75, 90, 100, 65);
        enemies.add(new Enemy(enemyPlatform));
        platforms.add(enemyPlatform);

        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));

    }
}
