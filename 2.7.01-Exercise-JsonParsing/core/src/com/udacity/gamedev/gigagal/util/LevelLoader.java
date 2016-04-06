package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.Level;

public class LevelLoader {

    public static final String TAG = LevelLoader.class.toString();

    public static Level load(String levelName, Viewport viewport) {

        Level level = new Level(viewport);

        // TODO: Construct the path to the level file
        // Use the LEVEL_DIR constant, File.separator, the level name, and LEVEL_FILE_EXTENSION


        try {

            // TODO: Get the level FileHandle object using Gdx.files.internal


            // TODO: Create a new JSONParser


            // TODO: get the root JSONObject by parsing the level file
            // Use file.reader() to pass a file reader into parse() on the parser, then cast the result to a JSONObject


            // TODO: Log rootJsonObject.keySet().toString() to see the keys available in this JSONObject


            // TODO: Get the 'composite' object within the rootJsonObject


            // TODO: Log the keys available in the composite object


            // TODO: Get the JSONArray behind the LEVEL_9PATCHES key


            // TODO: Get the first platform in the array


            // TODO: Log the keys available in the platform object



        } catch (Exception ex) {

            // TODO: If there's an error, log the message using ex.getMessage()
            // Be sure to log the error at the appropriate log level


            // TODO: Then log the error message defined in LEVEL_ERROR_MESSAGE

        }

        return level;
    }

}
