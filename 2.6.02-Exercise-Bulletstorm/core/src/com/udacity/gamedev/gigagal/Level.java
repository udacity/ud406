package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;
import com.udacity.gamedev.gigagal.util.Enums.Direction;

public class Level {

    public static final String TAG = Level.class.getName();

    private Viewport viewport;

    private GigaGal gigaGal;
    private Array<Platform> platforms;
    private DelayedRemovalArray<Enemy> enemies;

    // TODO: Add a DelayedRemovalArray of bullets


    public Level(Viewport viewport) {
        this.viewport = viewport;
        initializeDebugLevel();
    }

    public void update(float delta) {
        // Update GigaGal
        gigaGal.update(delta, platforms);

        // BULLET STORM!

        // TODO: Spawn a bullet in a random direction, at a random position
        // At a position within some reasonable rectangle
        // You'll want to complete the spawnBullet() method below first


        // TODO: Update the bullets


        // Update Enemies
        for (int i = 0; i < enemies.size; i++) {
            Enemy enemy = enemies.get(i);
            enemy.update(delta);
        }
    }

    public void render(SpriteBatch batch) {

        for (Platform platform : platforms) {
            platform.render(batch);
        }


        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }

        gigaGal.render(batch);

        // TODO: Render the bullets

    }

    private void initializeDebugLevel() {

        gigaGal = new GigaGal(new Vector2(15, 40), this);

        platforms = new Array<Platform>();

        // TODO: Initialize bullets array


        enemies = new DelayedRemovalArray<Enemy>();

        platforms.add(new Platform(15, 100, 30, 20));

        Platform enemyPlatform = new Platform(75, 90, 100, 65);
        enemies.add(new Enemy(enemyPlatform));

        platforms.add(enemyPlatform);
        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));

    }

    public Array<Platform> getPlatforms() {
        return platforms;
    }

    public DelayedRemovalArray<Enemy> getEnemies() {
        return enemies;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public GigaGal getGigaGal() {
        return gigaGal;
    }

    public void setGigaGal(GigaGal gigaGal) {
        this.gigaGal = gigaGal;
    }

    public void spawnBullet(Vector2 position, Direction direction) {
        // TODO: Complete this method for adding new bullets to the bullets array

    }


}
