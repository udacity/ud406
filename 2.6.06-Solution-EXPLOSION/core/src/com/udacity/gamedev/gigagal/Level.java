package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.Bullet;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.Explosion;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;
import com.udacity.gamedev.gigagal.util.Enums.Direction;

public class Level {

    public static final String TAG = Level.class.getName();

    private Viewport viewport;

    private GigaGal gigaGal;
    private Array<Platform> platforms;
    private DelayedRemovalArray<Enemy> enemies;
    private DelayedRemovalArray<Bullet> bullets;

    // TODO: Add a DelayedRemovalArray of Explosions
    private DelayedRemovalArray<Explosion> explosions;

    public Level(Viewport viewport) {
        this.viewport = viewport;
        initializeDebugLevel();
    }

    public void update(float delta) {
        // Update GigaGal
        gigaGal.update(delta, platforms);

        // Update Bullets
        bullets.begin();
        for (Bullet bullet : bullets) {
            bullet.update(delta);
            if (!bullet.active) {
                bullets.removeValue(bullet, false);
            }
        }
        bullets.end();

        // Update Enemies
        enemies.begin();
        for (int i = 0; i < enemies.size; i++) {
            Enemy enemy = enemies.get(i);
            enemy.update(delta);
            if (enemy.health < 1) {
                // TODO: Spawn an explosion at the enemy position
                spawnExplosion(enemy.position);
                enemies.removeIndex(i);
            }
        }
        enemies.end();

        // TODO: Remove any explosions that are finished
        explosions.begin();
        for (int i = 0; i < explosions.size; i++) {
            if (explosions.get(i).isFinished()) {
                explosions.removeIndex(i);
            }
        }
        explosions.end();

    }

    public void render(SpriteBatch batch) {

        for (Platform platform : platforms) {
            platform.render(batch);
        }


        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }

        gigaGal.render(batch);

        for (Bullet bullet : bullets) {
            bullet.render(batch);
        }

        // TODO: Render the explosions
        for (Explosion explosion : explosions) {
            explosion.render(batch);
        }

    }

    private void initializeDebugLevel() {

        gigaGal = new GigaGal(new Vector2(15, 40), this);

        platforms = new Array<Platform>();
        bullets = new DelayedRemovalArray<Bullet>();
        enemies = new DelayedRemovalArray<Enemy>();

        // TODO: Initialize explosions collection
        explosions = new DelayedRemovalArray<Explosion>();

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
        bullets.add(new Bullet(this, position, direction));
    }

    public void spawnExplosion(Vector2 position) {
        // TODO: Add a new explosion at the specified position
        explosions.add(new Explosion(position));
    }
}
