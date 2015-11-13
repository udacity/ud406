package com.udacity.gamedev.fileloading;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * http://www.code2learn.com/2011/06/encryption-and-decryption-of-data-using.html
 */

public class FileLoading extends ApplicationAdapter {

    public static final String TAG = FileLoading.class.getName();

    private static final byte[] keyValue =
            new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
                    'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    private static final String ALGORITHM = "AES";
    private static final Key key = new SecretKeySpec(keyValue, ALGORITHM);

    SpriteBatch batch;
    Texture img;

    public static String encrypt(String message) {
        try {
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(message.getBytes());
            return new BASE64Encoder().encode(encVal);
        } catch (Exception e){
            Gdx.app.error(TAG, "Couldn't encrypt message: " + message, e);
        }
        return "Failed";
    }

    public static String decrypt(String encrypted) {
        try {
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedValue = new BASE64Decoder().decodeBuffer(encrypted);
            byte[] decValue = c.doFinal(decodedValue);
            return new String(decValue);
        } catch (Exception e){
            Gdx.app.error(TAG, "Couldn't decrypt message: " + encrypted, e);
        }
        return "Failed";
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");


        String encryptedPunchline = encrypt("Very Carefully");


        Gdx.app.log(TAG, "How does GigaGal tie her shoe laces when her arms are cannons?");

        // TODO: Go find the text file in the android/assets directory
        // TODO: Get a FileHandle using Gdx.files.internal()
        FileHandle file =  Gdx.files.internal("aRandomFile");

//        // TODO: Read the file using FileHandle.readString()
        String encrypted = file.readString();

        // TODO: Decrypt the punchline
        String punchline = decrypt(encrypted);

        // TODO: Log the rest of the joke

//        Gdx.app.log(TAG, file.readString());


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

