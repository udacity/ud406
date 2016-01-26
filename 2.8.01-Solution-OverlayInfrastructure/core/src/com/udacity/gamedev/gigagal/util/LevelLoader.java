package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
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
import java.util.HashMap;


public class LevelLoader {
    public static final String TAG = LevelLoader.class.toString();
    private static final float PLATFORM_BASE_SIZE = 58f;
    private static HashMap<String, Platform> namedPlatforms;

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
        namedPlatforms = new HashMap<String, Platform>();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(file));

            // Get the objects in the level
            JSONArray jsonArray = (JSONArray) ((JSONObject) jsonObject.get("composite")).get("sImages");

            // We need to load the plaforms first because enemies might need them.
            loadPlatforms(jsonArray, level);
            loadEnemies(jsonArray, level);

            for (Object o : jsonArray) {
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

        } catch(Exception ex) {
            Gdx.app.log(TAG, ex.getMessage());
            Gdx.app.log(TAG, "There was a problem loading the level.");
        }

        // Dispose of named platforms
        namedPlatforms = null;

        return level;
    }

    private static void loadEnemies(JSONArray array, Level level) {
        for (Object o : array) {
            JSONObject item = (JSONObject) o;
            if (item.get("imageName").equals("enemy")) {
                String customVars = null;
                // look for customVars
                if (item.get("customVars") != null) {
                    customVars = (String)item.get("customVars");
                }
                String platformName = customVars.split(":")[1];
                // Find plaform
                Platform namedPlatform = namedPlatforms.get(platformName);
                Gdx.app.log(TAG, platformName);

                if (namedPlatform != null) {
                    level.getEnemies().add(new Enemy(namedPlatform));
                }
            }
        }
    }

    // We need to load things in this approximate order, levels, enemies, everything else
    private static void loadPlatforms(JSONArray array, Level level) {
        for (Object o : array) {
            JSONObject item = (JSONObject) o;
            if (item.get("imageName").equals("platform")) {
                level.getPlatforms().add(loadPlatform(item));
            }
        }
    }


    public static Platform loadPlatform(JSONObject o) {
        Number left = 0.0d, top = 0.0d, scaleX = 1.0d, scaleY = 1.0d;
        String identifier = null;

        if (o.get("x") != null)
            left = (Number)o.get("x");
        if (o.get("y") != null)
            top = (Number)o.get("y");
        if (o.get("scaleX") != null)
            scaleX = (Number)o.get("scaleX");
        if (o.get("scaleY") != null)
            scaleY = (Number)o.get("scaleY");

        if (o.get("itemIdentifier") != null)
            identifier = (String)o.get("itemIdentifier");

        Platform platform = new Platform(left.floatValue(),
                top.floatValue(),
                PLATFORM_BASE_SIZE * scaleX.floatValue(), PLATFORM_BASE_SIZE * scaleY.floatValue());

        if (identifier != null) {
            platform.setIdentifier(identifier);
            namedPlatforms.put(identifier, platform);
        }
        return platform;
    }
}
