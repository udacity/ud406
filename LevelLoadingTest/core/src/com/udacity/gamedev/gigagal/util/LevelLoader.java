package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.udacity.gamedev.gigagal.Level;
import com.udacity.gamedev.gigagal.entities.Platform;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by james on 1/5/16.
 */
public class LevelLoader {
    public static final String TAG = LevelLoader.class.toString();
    private static final float platformBaseHeight = 50f;
    private static final float platformBaseWidth = 50f;

    public static Level load(String path) {
        Level level = new Level();
        File file = Gdx.files.internal(path).file();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(file));

            // Get the objects in the level
            JSONArray jsonArray = (JSONArray) ((JSONObject) jsonObject.get("composite")).get("sImages");
            for (Object o : jsonArray) {
                JSONObject item = (JSONObject) o;
                if (item.get("imageName").equals("platform")) {
                    level.getPlatforms().add(loadPlatform(item));
                }
            }

        } catch(Exception ex) {
            Gdx.app.log(TAG, "There was a problem loading the level.");
        }
        return level;
    }


    public static Platform loadPlatform(JSONObject o) {
        Number left = 0.0d, top = 0.0d, scaleX = 1.0d, scaleY = 1.0d;

        if (o.get("x") != null)
            left = (Number)o.get("x");
        if (o.get("y") != null)
            top = (Number)o.get("y");
        if (o.get("scaleX") != null)
            scaleX = (Number)o.get("scaleX");
        if (o.get("scaleY") != null)
            scaleY = (Number)o.get("scaleY");

        Platform platform = new Platform(left.floatValue() * 50f,
                top.floatValue() * 50f,
                platformBaseWidth * scaleX.floatValue(), platformBaseHeight * scaleY.floatValue());
        return platform;
    }
}
