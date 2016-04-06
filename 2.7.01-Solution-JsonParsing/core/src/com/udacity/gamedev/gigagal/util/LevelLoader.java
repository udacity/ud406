package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.Level;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;

public class LevelLoader {

    public static final String TAG = LevelLoader.class.toString();

    public static Level load(String levelName, Viewport viewport) {

        Level level = new Level(viewport);

        // TODO: Construct the path to the level file
        // Use the LEVEL_DIR constant, File.separator, the level name, and LEVEL_FILE_EXTENSION
        String path = Constants.LEVEL_DIR + File.separator + levelName + "." + Constants.LEVEL_FILE_EXTENSION;


        try {

            // TODO: Get the level FileHandle object using Gdx.files.internal
            FileHandle file = Gdx.files.internal(path);

            // TODO: Create a new JSONParser
            JSONParser parser = new JSONParser();

            // TODO: get the root JSONObject by parsing the level file
            // Use file.reader() to pass a file reader into parse() on the parser, then cast the result to a JSONObject
            JSONObject rootJsonObject = (JSONObject) parser.parse(file.reader());

            // TODO: Log rootJsonObject.keySet().toString() to see the keys available in this JSONObject
            Gdx.app.log(TAG, rootJsonObject.keySet().toString());

            // TODO: Get the 'composite' object within the rootJsonObject
            JSONObject composite = (JSONObject) rootJsonObject.get(Constants.LEVEL_COMPOSITE);

            // TODO: Log the keys available in the composite object
            Gdx.app.log(TAG, composite.keySet().toString());

            // TODO: Get the JSONArray behind the LEVEL_9PATCHES key
            JSONArray platforms = (JSONArray) composite.get(Constants.LEVEL_9PATCHES);

            // TODO: Get the first platform in the array
            JSONObject firstPlatform = (JSONObject) platforms.get(0);

            // TODO: Log the keys available in the platform object
            Gdx.app.log(TAG, firstPlatform.keySet().toString());


        } catch (Exception ex) {

            // TODO: If there's an error, log the message using ex.getMessage()
            // Be sure to log the error at the appropriate log level
            Gdx.app.error(TAG, ex.getMessage());

            // TODO: Then log the error message defined in LEVEL_ERROR_MESSAGE
            Gdx.app.error(TAG, Constants.LEVEL_ERROR_MESSAGE);
        }

        return level;
    }

}
