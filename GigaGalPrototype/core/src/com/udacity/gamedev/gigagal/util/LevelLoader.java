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
        Level level = LevelLoader.load(path);
        level.setViewport(viewport);
        return level;
    }

    public static Level load(String path) {
        Level level = new Level();
        File file = Gdx.files.internal(path).file();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;


        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(file));

            // Get the objects in the level
            JSONArray nonPlatformObjects = (JSONArray) ((JSONObject) jsonObject.get("composite")).get("sImages");

            JSONArray platforms = (JSONArray) ((JSONObject) jsonObject.get("composite")).get("sImage9patchs");

            // We need to load the plaforms first because enemies might need them.
            loadPlatforms(platforms, level);


            for (Object o : nonPlatformObjects) {
                JSONObject item = (JSONObject) o;

                if (item.get("imageName").equals("powerup")) {
                    float x = 0.0f, y = 0.0f;

                    //
                    if (item.get("x") != null)
                        x = ((Number)item.get("x")).floatValue();
                    if (item.get("y") != null)
                        y = ((Number)item.get("y")).floatValue();

                    level.getPowerups().add(new Powerup(new Vector2(x, y)));
                }

                if (item.get("imageName").equals("exit-portal")) {
                  Number x = 0f, y = 0f;
                  if (item.get("x") != null)
                      x = (Number)item.get("x");
                  if (item.get("y") != null)
                      y = (Number)item.get("y");
                    ExitPortal exitPortal = new ExitPortal(new Vector2(x.floatValue(), y.floatValue()));
                    level.setExitPortal(exitPortal);

                }

                // Load GigaGal
                if (item.get("imageName").equals("standing-right")) {
                  Number x = 0f, y = 0f;
                  if (item.get("x") != null)
                      x = (Number)item.get("x");
                  if (item.get("y") != null)
                      y = (Number)item.get("y");
                      // Additional y value is so that GG falls onto the starting spawn point.
                      GigaGal gigaGal = new GigaGal(new Vector2(x.floatValue(), y.floatValue()+ 25), level);
                      level.setGigaGal(gigaGal);

                }

            }

        } catch (Exception ex) {
            Gdx.app.log(TAG, ex.getMessage());
            Gdx.app.log(TAG, "There was a problem loading the level.");
        }

        return level;
    }


    // We need to load things in this approximate order, levels, enemies, everything else
    private static void loadPlatforms(JSONArray array, Level level) {

        Array<Platform> platformArray = new Array<Platform>();

        for (Object object : array) {
            final JSONObject platformObject = (JSONObject) object;

            // TODO: Make constants for these keys
            final float x = ((Number) platformObject.get("x")).floatValue();
            final float y = ((Number) platformObject.get("y")).floatValue();
            final float width = ((Number) platformObject.get("width")).floatValue();
            final float height = ((Number) platformObject.get("height")).floatValue();


            final Platform platform = new Platform(x, y + height, width, height);

            platformArray.add(platform);

            Gdx.app.log(TAG, "Loaded a platform at x = " + x);


            final String identifier = (String) platformObject.get("itemIdentifier");


            if (identifier != null && identifier.equals("Enemy")) {
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


//    public static Platform loadPlatform(JSONObject o) {
//        Number left = 0.0d, top = 0.0d, scaleX = 1.0d, scaleY = 1.0d;
//        String identifier = null;
//
//        if (o.get("x") != null)
//            left = (Number) o.get("x");
//        if (o.get("y") != null)
//            top = (Number) o.get("y");
//        if (o.get("scaleX") != null)
//            scaleX = (Number) o.get("scaleX");
//        if (o.get("scaleY") != null)
//            scaleY = (Number) o.get("scaleY");
//
//        if (o.get("itemIdentifier") != null)
//            identifier = (String) o.get("itemIdentifier");
//
//        Platform platform = new Platform(left.floatValue(),
//                top.floatValue(),
//                PLATFORM_BASE_SIZE * scaleX.floatValue(), PLATFORM_BASE_SIZE * scaleY.floatValue());
//
//        if (identifier != null) {
//            platform.setIdentifier(identifier);
//            namedPlatforms.put(identifier, platform);
//        }
//        return platform;
//    }
}
