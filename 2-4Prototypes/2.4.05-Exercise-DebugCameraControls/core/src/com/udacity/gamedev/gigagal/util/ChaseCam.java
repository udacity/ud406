package com.udacity.gamedev.gigagal.util;


import com.badlogic.gdx.graphics.Camera;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class ChaseCam {

    private Camera camera;
    private GigaGal target;

    // TODO: Add following flag


    public ChaseCam(Camera camera, GigaGal target) {
        this.camera = camera;
        this.target = target;

        // TODO: Initialize following flag

    }

    // TODO: Accept a float time delta
    public void update() {

        // TODO: Toggle the following flag when spacebar is pressed


        // TODO: If following, update the camera's position to match the target
        camera.position.x = target.position.x;
        camera.position.y = target.position.y;


        // TODO: If not following, check if Gdx.input.isKeyPressed(Keys.A)


        // TODO: If so, move the camera in the -x direction by delta * camera move speed


        // TODO: Move the camera right if D is pressed


        // TODO: Move the camera up if W is pressed


        // TODO: Move the camera down if S is pressed


    }
}
