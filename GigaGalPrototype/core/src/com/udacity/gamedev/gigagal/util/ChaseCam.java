package com.udacity.gamedev.gigagal.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class ChaseCam {

    private Camera camera;
    private Rectangle levelBounds;
    private GigaGal target;
    private Boolean following;


    public ChaseCam(Camera camera, Rectangle levelBounds, GigaGal target) {
        this.camera = camera;
        this.levelBounds = levelBounds;
        this.target = target;
        following = true;
    }




    public void update(float delta){

        if (following) {
            camera.position.x = target.getPosition().x;
            camera.position.y = target.getPosition().y;

        } else {
            if (Gdx.input.isKeyPressed(Keys.J)) {
                camera.position.x -= delta * Constants.CHASE_CAM_MOVE_SPEED;
            }
            if (Gdx.input.isKeyPressed(Keys.L)) {
                camera.position.x += delta * Constants.CHASE_CAM_MOVE_SPEED;
            }
            if (Gdx.input.isKeyPressed(Keys.I)) {
                camera.position.x += delta * Constants.CHASE_CAM_MOVE_SPEED;
            }
            if (Gdx.input.isKeyPressed(Keys.K)) {
                camera.position.x -= delta * Constants.CHASE_CAM_MOVE_SPEED;
            }
        }
    }
}
