package com.udacity.gamedev.gigagal.util;


import com.badlogic.gdx.graphics.Camera;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class ChaseCam {

    // TODO: Add a Camera member variable
    private Camera camera;

    // TODO: Add a GigaGal to target
    private GigaGal target;


    // TODO: Accept and initialize the camera and GigaGal instance
    public ChaseCam(Camera camera, GigaGal target) {
        this.camera = camera;
        this.target = target;
    }


    // TODO: Set the camera's position to GigaGal's position
    // Note that the camera's position is a Vector3, while GigaGal's position is a Vector2
    public void update() {
        camera.position.x = target.position.x;
        camera.position.y = target.position.y;
    }
}
