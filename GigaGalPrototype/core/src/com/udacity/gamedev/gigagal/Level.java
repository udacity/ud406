package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.udacity.gamedev.gigagal.entities.Bullet;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.Explosion;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;
import com.udacity.gamedev.gigagal.util.Enums.Direction;

public class Level {

    GigaGal gigaGal;

    Array<Platform> platforms;
    Array<Bullet> bullets;
    Array<Enemy> enemies;
    DelayedRemovalArray<Explosion> explosions;

    public Level() {
        gigaGal = new GigaGal(new Vector2(20, 20), this);
        platforms = new Array<Platform>();
        bullets = new Array<Bullet>();
        enemies = new Array<Enemy>();
        explosions = new DelayedRemovalArray<Explosion>();
        addDebugPlatforms();
    }

    public Array<Bullet> getBullets() {
        return bullets;
    }

    public void update(float delta) {
        gigaGal.update(delta, platforms);

        explosions.begin();

        for (int i = 0; i < explosions.size; i++){
            if (explosions.get(i).isFinished()){
                explosions.removeIndex(i);
            }
        }
        explosions.end();

        spawnExplosion(new Vector2(MathUtils.random(0, 100), MathUtils.random(0, 100)));




        for (Bullet bullet : bullets) {
            bullet.update(delta, enemies);
        }

        for (Enemy enemy : enemies) {
            enemy.update(delta);
        }
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

        for (Bullet bullet : bullets) {
            bullet.render(batch);
        }

        for (Explosion explosion : explosions){
            explosion.render(batch);
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

    public void spawnBullet(Vector2 position, Direction direction){
        bullets.add( new Bullet(position, direction));
    }

    public void spawnExplosion(Vector2 position){
        explosions.add(new Explosion(position));
    }
}
