package com.udacity.gamedev.rectanglecirclecollision;

import com.badlogic.gdx.Game;

public class RectangleCircleCollisionGame extends Game {

    @Override
    public void create() {
        setScreen(new RectangleCircleCollisionScreen());
    }
}
