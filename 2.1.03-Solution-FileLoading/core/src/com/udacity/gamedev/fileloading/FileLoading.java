package com.udacity.gamedev.fileloading;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.apache.commons.codec.binary.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class FileLoading extends ApplicationAdapter {

    public static final String TAG = FileLoading.class.getName();

    private static final Key key = new SecretKeySpec("secretKey1234567".getBytes(), "AES");

    SpriteBatch batch;
    Texture img;

    public static String encrypt(String message) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            if (Gdx.app.getType() == ApplicationType.Android){
                throw new Exception("This demo works only with the desktop backend");
            }
            return Base64.encodeBase64String(encryptedBytes);
        } catch (Exception e) {
            Gdx.app.error(TAG, "Couldn't encrypt message: " + message, e);
        }
        return "Failed";
    }

    public static String decrypt(String encrypted) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            if (Gdx.app.getType() == ApplicationType.Android){
                throw new Exception("This demo works only with the desktop backend");
            }
            byte[] encryptedBytes = Base64.decodeBase64(encrypted);
            return new String(cipher.doFinal(encryptedBytes));
        } catch (Exception e) {
            Gdx.app.error(TAG, "Couldn't decrypt message: " + encrypted, e);
        }
        return "Failed";
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        String encryptedPunchline = encrypt("Very Carefully");
        Gdx.app.log(TAG, encryptedPunchline);

        Gdx.app.log(TAG, "How does GigaGal tie her shoelaces when her arms are cannons?");

        // TODO: Go find the text file in the android/assets directory
        // TODO: Get a FileHandle using Gdx.files.internal()
        FileHandle file = Gdx.files.internal("punchline");

        // TODO: Read the file using FileHandle.readString()
        String encrypted = file.readString();

        // TODO: Decrypt the punchline
        String punchline = decrypt(encrypted);

        // TODO: Log the rest of the joke
        Gdx.app.log(TAG, punchline);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

}

