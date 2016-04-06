package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
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
import java.util.Comparator;

public class LevelLoader {

    public static final String TAG = LevelLoader.class.toString();

    public static Level load(String levelName, Viewport viewport) {

        String path = Constants.LEVEL_DIR + File.separator + levelName + "." + Constants.LEVEL_FILE_EXTENSION;
        Level level = new Level(viewport);

        FileHandle file = Gdx.files.internal(path);
        JSONParser parser = new JSONParser();

        try {
            JSONObject rootJsonObject = (JSONObject) parser.parse(file.reader());

            JSONObject composite = (JSONObject) rootJsonObject.get(Constants.LEVEL_COMPOSITE);

            JSONArray platforms = (JSONArray) composite.get(Constants.LEVEL_9PATCHES);
            loadPlatforms(platforms, level);

            // TODO: Get the non-platform level objects from composite (using the Constants.LEVEL_IMAGES key)
            JSONArray nonPlatformObjects = (JSONArray) composite.get(Constants.LEVEL_IMAGES);

            // TODO: Call loadNonPlatformEntities()
            loadNonPlatformEntities(level, nonPlatformObjects);

        } catch (Exception ex) {
            Gdx.app.error(TAG, ex.getMessage());
            Gdx.app.error(TAG, Constants.LEVEL_ERROR_MESSAGE);
        }

        return level;
    }

    private static float safeGetFloat(JSONObject object, String key) {
        Number number = (Number) object.get(key);
        return (number == null) ? 0 : number.floatValue();
    }

    private static void loadPlatforms(JSONArray array, Level level) {

        Array<Platform> platformArray = new Array<Platform>();

        for (Object object : array) {
            final JSONObject platformObject = (JSONObject) object;

            final float x = safeGetFloat(platformObject, Constants.LEVEL_X_KEY);
            final float y = safeGetFloat(platformObject, Constants.LEVEL_Y_KEY);
            final float width = ((Number) platformObject.get(Constants.LEVEL_WIDTH_KEY)).floatValue();
            final float height = ((Number) platformObject.get(Constants.LEVEL_HEIGHT_KEY)).floatValue();

            Gdx.app.log(TAG,
                    "Loaded a platform at x = " + x + " y = " + (y + height) + " w = " + width + " h = " + height);

            final Platform platform = new Platform(x, y + height, width, height);
            platformArray.add(platform);

            final String identifier = (String) platformObject.get(Constants.LEVEL_IDENTIFIER_KEY);
            if (identifier != null && identifier.equals(Constants.LEVEL_ENEMY_TAG)) {
                Gdx.app.log(TAG, "Loaded an enemy on that platform");
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

            // First we need to cast the object to a JSONObject
            JSONObject item = (JSONObject) o;

            // TODO: Get the lower left corner of the object
            // Remember to use safeGetFloat()
            Vector2 lowerLeftCorner = new Vector2();

            final float x = safeGetFloat(item, Constants.LEVEL_X_KEY);
            final float y = safeGetFloat(item, Constants.LEVEL_Y_KEY);

            lowerLeftCorner = new Vector2(x, y);

            // Check if this object is GigaGal
            if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.STANDING_RIGHT)) {

                // If so, add GigaGal's eye position to find her spawn position
                final Vector2 gigaGalPosition = lowerLeftCorner.add(Constants.GIGAGAL_EYE_POSITION);
                Gdx.app.log(TAG, "Loaded GigaGal at " + gigaGalPosition);

                // Add our new GigaGal to the level
                level.setGigaGal(new GigaGal(gigaGalPosition, level));
            }

            // TODO: Go through the same process to load the Exit Portal
            else if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.EXIT_PORTAL_SPRITE_1)) {
                final Vector2 exitPortalPosition = lowerLeftCorner.add(Constants.EXIT_PORTAL_CENTER);
                Gdx.app.log(TAG, "Loaded the exit portal at " + exitPortalPosition);
                level.setExitPortal(new ExitPortal(exitPortalPosition));
            }

            // TODO: Load the Powerups
            else if (item.get(Constants.LEVEL_IMAGENAME_KEY).equals(Constants.POWERUP_SPRITE)) {
                final Vector2 powerupPosition = lowerLeftCorner.add(Constants.POWERUP_CENTER);
                Gdx.app.log(TAG, "Loaded a powerup at " + powerupPosition);
                level.getPowerups().add(new Powerup(powerupPosition));
            }
        }
    }
}
