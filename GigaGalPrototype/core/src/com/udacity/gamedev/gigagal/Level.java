package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.entities.Bullet;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.ExitPortal;
import com.udacity.gamedev.gigagal.entities.Explosion;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;
import com.udacity.gamedev.gigagal.entities.Powerup;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Enums.Direction;

public class Level {

    public static final String TAG = Level.class.getName();
    public boolean gameOver;
    public boolean victory;
    public Viewport viewport;
    public int score;
    private GigaGal gigaGal;
    private ExitPortal exitPortal;
    private Array<Platform> platforms;
    private DelayedRemovalArray<Enemy> enemies;
    private DelayedRemovalArray<Bullet> bullets;
    private DelayedRemovalArray<Explosion> explosions;
    private DelayedRemovalArray<Powerup> powerups;

    public Level() {
        viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        gigaGal = new GigaGal(new Vector2(50, 50), this);
        platforms = new Array<Platform>();
        enemies = new DelayedRemovalArray<Enemy>();
        bullets = new DelayedRemovalArray<Bullet>();
        explosions = new DelayedRemovalArray<Explosion>();
        powerups = new DelayedRemovalArray<Powerup>();
        exitPortal = new ExitPortal(new Vector2(200, 200));

        gameOver = false;
        victory = false;
        score = 0;


    }

    public static Level debugLevel() {
        Level level = new Level();
        level.initializeDebugLevel();
        return level;
    }

    public void update(float delta) {


        if (gigaGal.getLives() < 0) {
            gameOver = true;
        } else if (gigaGal.getPosition().dst(exitPortal.position) < Constants.EXIT_PORTAL_RADIUS) {
            victory = true;
        }

        if (!gameOver && !victory) {

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
                    spawnExplosion(enemy.position);
                    enemies.removeIndex(i);
                    score += Constants.ENEMY_KILL_SCORE;
                }
            }
            enemies.end();

            // Update Explosions
            explosions.begin();
            for (int i = 0; i < explosions.size; i++) {
                if (explosions.get(i).isFinished()) {
                    explosions.removeIndex(i);
                }
            }
            explosions.end();
        }

    }

    public void render(SpriteBatch batch) {

        viewport.apply();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        for (Platform platform : platforms) {
            platform.render(batch);
        }

        exitPortal.render(batch);

        for (Powerup powerup : powerups) {
            powerup.render(batch);
        }

        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }
        gigaGal.render(batch);

        for (Bullet bullet : bullets) {
            bullet.render(batch);
        }

        for (Explosion explosion : explosions) {
            explosion.render(batch);
        }

        batch.end();
    }

    private void initializeDebugLevel() {

        gigaGal = new GigaGal(new Vector2(15, 40), this);

        exitPortal = new ExitPortal(new Vector2(150, 150));

        platforms = new Array<Platform>();
        bullets = new DelayedRemovalArray<Bullet>();
        enemies = new DelayedRemovalArray<Enemy>();
        explosions = new DelayedRemovalArray<Explosion>();
        powerups = new DelayedRemovalArray<Powerup>();


        platforms.add(new Platform(15, 100, 30, 20));

        Platform enemyPlatform = new Platform(75, 90, 100, 65);

        enemies.add(new Enemy(enemyPlatform));

        platforms.add(enemyPlatform);
        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));

        powerups.add(new Powerup(new Vector2(20, 110)));
    }


    public Array<Platform> getPlatforms() {
        return platforms;
    }

    public DelayedRemovalArray<Enemy> getEnemies() {
        return enemies;
    }

    public DelayedRemovalArray<Powerup> getPowerups() {
        return powerups;
    }

    public ExitPortal getExitPortal() {
        return exitPortal;
    }

    public void setExitPortal(ExitPortal exitPortal) {
        this.exitPortal = exitPortal;
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
        explosions.add(new Explosion(position));
    }
}
