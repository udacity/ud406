package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.Level;
import com.udacity.gamedev.gigagal.entities.Platform;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class LevelLoader {

    public static final String TAG = LevelLoader.class.toString();

    public static Level load(String levelName, Viewport viewport) {

        String path = Constants.LEVEL_DIR + File.separator + levelName + "." + Constants.LEVEL_FILE_EXTENSION;
        Level level = new Level(viewport);

        File file = Gdx.files.internal(path).file();
        JSONParser parser = new JSONParser();

        try {
            JSONObject rootJsonObject = (JSONObject) parser.parse(new FileReader(file));

            JSONObject composite = (JSONObject) rootJsonObject.get(Constants.LEVEL_COMPOSITE);

            JSONArray platforms = (JSONArray) composite.get(Constants.LEVEL_9PATCHES);
            loadPlatforms(platforms, level);


        } catch (Exception ex) {
            Gdx.app.error(TAG, ex.getMessage());
            Gdx.app.error(TAG, Constants.LEVEL_ERROR_MESSAGE);
        }

        return level;
    }

    private static void loadPlatforms(JSONArray array, Level level) {

        Array<Platform> platformArray = new Array<Platform>();

        for (Object object : array) {
            final JSONObject platformObject = (JSONObject) object;


            final float x = ((Number) platformObject.get(Constants.LEVEL_X_KEY)).floatValue();

            // TODO: Get the y position of the platform
            // Use the LEVEL_Y_KEY constant we defined
            // Not that this is the BOTTOM of the platform, not the top


            // TODO: Get the platform width


            // TODO: Get the platform height


            // TODO: Optional, log the location and dimensions of the platform


            // TODO: Make a new platform with the dimensions we loaded
            // Remember that the y position we loaded is the platform bottom, not top


            // TODO: Add the platform to the platformArray


            // TODO: Get the platform identifier
            // Use the LEVEL_IDENTIFIER_KEY constant


            // TODO: Check if the platform identifier equals the LEVEL_ENEMY_TAG


            // TODO: If so, create a new enemy on the platform


            // TODO: Add that enemy to the list of enemies in the level


        }

        // TODO: Sort the platform array by descending position of the top of the platform
        // We're doing this so lower platforms aren't hidden by higher platforms
        // This one is tough. Check out the solution project if you run into trouble

        // TODO: Add all the platforms from platformArray to the level

    }
}
