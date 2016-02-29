package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.Level;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.ExitPortal;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;
import com.udacity.gamedev.gigagal.entities.Powerup;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Comparator;

public class LevelLoader {

    public static final String TAG = LevelLoader.class.toString();

    public static Level load(String path, Viewport viewport) {
        Level level = new Level();
        level.setViewport(viewport);

        File file = Gdx.files.internal(path).file();
        JSONParser parser = new JSONParser();

        try {
            JSONObject rootJsonObject = (JSONObject) parser.parse(new FileReader(file));

            JSONObject composite = (JSONObject) rootJsonObject.get(Constants.LEVEL_COMPOSITE);

            JSONArray platforms = (JSONArray) composite.get(Constants.LEVEL_9PATCHES);
            loadPlatforms(platforms, level);

            JSONArray nonPlatformObjects = (JSONArray) composite.get(Constants.LEVEL_IMAGES);
            loadNonPlatformEntities(level, nonPlatformObjects);

        } catch (Exception ex) {
            Gdx.app.log(TAG, ex.getMessage());
            Gdx.app.log(TAG, Constants.LEVEL_ERROR_MESSAGE);
        }

        return level;
    }

    private static void loadPlatforms(JSONArray array, Level level) {

        Array<Platform> platformArray = new Array<Platform>();

        for (Object object : array) {
            final JSONObject platformObject = (JSONObject) object;

            final float x = ((Number) platformObject.get(Constants.LEVEL_X_KEY)).floatValue();
            final float y = ((Number) platformObject.get(Constants.LEVEL_Y_KEY)).floatValue();
            final float width = ((Number) platformObject.get(Constants.LEVEL_WIDTH_KEY)).floatValue();
            final float height = ((Number) platformObject.get(Constants.LEVEL_HEIGHT_KEY)).floatValue();

            final Platform platform = new Platform(x, y + height, width, height);
            platformArray.add(platform);

            final String identifier = (String) platformObject.get(Constants.LEVEL_IDENTIFIER_KEY);
            if (identifier != null && identifier.equals(Constants.LEVEL_ENEMY_TAG)) {
                final Enemy enemy = new Enemy(platform);
                level.getEnemies().add(enemy);
            }
        }

        platformArray.sort(new Comparator<Platform>() {
            @Override
            public int compare(Platform o1, Platform o2) {
                if (o1.top < o2.top) {
                    return 1;
                } else if (o1.top > o2.top) {
                    return -1;
                }
                return 0;
            }
        });

        level.getPlatforms().addAll(platformArray);
    }

    private static void loadNonPlatformEntities(Level level, JSONArray nonPlatformObjects) {
        for (Object o : nonPlatformObjects) {
            JSONObject item = (JSONObject) o;

            final float x = ((Number) item.get(Constants.LEVEL_X_KEY)).floatValue();
            final float y = ((Number) item.get(Constants.LEVEL_Y_KEY)).floatValue();
            final Vector2 imagePosition = new Vector2(x, y);


            if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.POWERUP_SPRITE)) {
                final Vector2 powerupPosition = imagePosition.add(Constants.POWERUP_CENTER);
                Gdx.app.log(TAG, "Loaded a powerup at " + powerupPosition);
                level.getPowerups().add(new Powerup(powerupPosition));
            } else if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.STANDING_RIGHT)) {
                final Vector2 gigaGalPosition = imagePosition.add(Constants.GIGAGAL_EYE_POSITION);
                Gdx.app.log(TAG, "Loaded GigaGal at " + gigaGalPosition);
                level.setGigaGal(new GigaGal(gigaGalPosition, level));
            } else if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.EXIT_PORTAL_SPRITE_1)) {
                final Vector2 exitPortalPosition = imagePosition.add(Constants.EXIT_PORTAL_CENTER);
                Gdx.app.log(TAG, "Loaded the exit portal at " + exitPortalPosition);
                level.setExitPortal(new ExitPortal(exitPortalPosition));
            }
        }
    }
}
