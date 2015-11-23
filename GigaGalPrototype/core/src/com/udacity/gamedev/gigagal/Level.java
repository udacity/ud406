package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.Bullet;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    GigaGal gigaGal;
    Array<Platform> platforms;
    Array<Bullet> bullets;
    Array<Enemy> enemies;

    public Level() {
        gigaGal = new GigaGal(new Vector2(20, 20), this);
        platforms = new Array<Platform>();
        bullets = new Array<Bullet>();
        enemies = new Array<Enemy>();
        addDebugPlatforms();
    }

    public Array<Bullet> getBullets() {
        return bullets;
    }

    public void update(float delta) {
        gigaGal.update(delta, platforms);
        for (Bullet bullet : bullets) {
            bullet.update(delta);
        }
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        for (Platform platform : platforms) {
            platform.render(batch);
        }
        gigaGal.render(batch);

        for (Bullet bullet : bullets) {
            bullet.render(batch);
        }

        batch.end();
    }

    private void addDebugPlatforms() {
        platforms.add(new Platform(15, 100, 30, 20));

        Platform enemyPlatform = new Platform(75, 90, 100, 65);

        enemies.add(new Enemy(enemyPlatform));

        platforms.add(enemyPlatform);
        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));



    }
}
