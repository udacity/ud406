package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;


public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    public GigaGalAssets gigaGalAssets;
    public PlatformAssets platformAssets;
    public BulletAssets bulletAssets;
    public EnemyAssets enemyAssets;
    public ExplosionAssets explosionAssets;
    public PowerupAssets powerupAssets;
    public ExitPortalAssets exitPortalAssets;
    public OnscreenControlsAssets onscreenControlsAssets;

    private AssetManager assetManager;


    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        gigaGalAssets = new GigaGalAssets(atlas);
        platformAssets = new PlatformAssets(atlas);
        bulletAssets = new BulletAssets(atlas);
        enemyAssets = new EnemyAssets(atlas);
        explosionAssets = new ExplosionAssets(atlas);
        powerupAssets = new PowerupAssets(atlas);
        exitPortalAssets = new ExitPortalAssets(atlas);
        onscreenControlsAssets = new OnscreenControlsAssets(atlas);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class GigaGalAssets {

        public final AtlasRegion standingLeft;
        public final AtlasRegion standingRight;
        public final AtlasRegion walkingLeft;
        public final AtlasRegion walkingRight;
        public final AtlasRegion jumpingLeft;
        public final AtlasRegion jumpingRight;

        public final Animation walkingLeftAnimation;
        public final Animation walkingRightAnimation;


        public GigaGalAssets(TextureAtlas atlas) {
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT);
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT);
            walkingLeft = atlas.findRegion(Constants.WALKING_LEFT_2);
            walkingRight = atlas.findRegion(Constants.WALKING_RIGHT_2);

            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT);
            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT);

            Array<AtlasRegion> walkingLeftFrames = new Array<AtlasRegion>();
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_2));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_1));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_2));
            walkingLeftFrames.add(atlas.findRegion(Constants.WALKING_LEFT_3));
            walkingLeftAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingLeftFrames, PlayMode.LOOP);

            Array<AtlasRegion> walkingRightFrames = new Array<AtlasRegion>();
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_1));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(atlas.findRegion(Constants.WALKING_RIGHT_3));
            walkingRightAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingRightFrames, PlayMode.LOOP);
        }
    }

    public class PlatformAssets {

        public final NinePatch platformNinePatch;

        public PlatformAssets(TextureAtlas atlas) {
            AtlasRegion region = atlas.findRegion(Constants.PLATFORM_SPRITE);
            int edge = Constants.PLATFORM_EDGE;
            platformNinePatch = new NinePatch(region, edge, edge, edge, edge);
        }
    }

    public class BulletAssets {

        public final AtlasRegion bullet;

        public BulletAssets(TextureAtlas atlas) {
            bullet = atlas.findRegion(Constants.BULLET_SPRITE);
        }

    }

    public class EnemyAssets {

        public final AtlasRegion enemy;

        public EnemyAssets(TextureAtlas atlas) {
            enemy = atlas.findRegion(Constants.ENEMY_SPRITE);
        }
    }

    public class ExplosionAssets {

        public final Animation explosion;

        public ExplosionAssets(TextureAtlas atlas) {

            Array<AtlasRegion> explosionRegions = new Array<AtlasRegion>();
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION_LARGE));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION_MEDIUM));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION_SMALL));

            explosion = new Animation(Constants.EXPLOSION_DURATION / explosionRegions.size,
                    explosionRegions, PlayMode.NORMAL);
        }
    }

    public class PowerupAssets {
        public final AtlasRegion powerup;

        public PowerupAssets(TextureAtlas atlas) {
            powerup = atlas.findRegion(Constants.POWERUP_SPRITE);
        }
    }

    public class ExitPortalAssets {

        public final Animation exitPortal;

        public ExitPortalAssets(TextureAtlas atlas) {
            final AtlasRegion exitPortal1 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_1);
            final AtlasRegion exitPortal2 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_2);
            final AtlasRegion exitPortal3 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_3);
            final AtlasRegion exitPortal4 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_4);
            final AtlasRegion exitPortal5 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_5);
            final AtlasRegion exitPortal6 = atlas.findRegion(Constants.EXIT_PORTAL_SPRITE_6);

            Array<AtlasRegion> exitPortalFrames = new Array<AtlasRegion>();
            exitPortalFrames.addAll(exitPortal1, exitPortal2, exitPortal3, exitPortal4, exitPortal5, exitPortal6);

            exitPortal = new Animation(Constants.EXIT_PORTAL_FRAME_DURATION, exitPortalFrames);
        }
    }

    public class OnscreenControlsAssets {

        public final AtlasRegion moveRight;
        public final AtlasRegion moveLeft;
        public final AtlasRegion shoot;
        public final AtlasRegion jump;

        public OnscreenControlsAssets(TextureAtlas atlas) {
            moveRight = atlas.findRegion(Constants.MOVE_RIGHT_BUTTON);
            moveLeft = atlas.findRegion(Constants.MOVE_LEFT_BUTTON);
            shoot = atlas.findRegion(Constants.SHOOT_BUTTON);
            jump = atlas.findRegion(Constants.JUMP_BUTTON);
        }


    }

}
