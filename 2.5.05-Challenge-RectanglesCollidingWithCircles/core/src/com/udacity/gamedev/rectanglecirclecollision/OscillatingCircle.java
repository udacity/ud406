package com.udacity.gamedev.rectanglecirclecollision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;


public class OscillatingCircle {

    public float originX, originY;
    public float radius;
    public float angle;
    public float magnitude, period;

    public OscillatingCircle(float originX, float originY, float radius, float angle, float magnitude, float period) {
        this.originX = originX;
        this.originY = originY;
        this.radius = radius;
        this.angle = angle;
        this.magnitude = magnitude;
        this.period = period;
    }

    public Circle getCurrentCircle(float elapsedTime) {
        float x = originX + magnitude * MathUtils.cos(angle) * MathUtils.sin(MathUtils.PI2 * elapsedTime / period);
        float y = originY + magnitude * MathUtils.sin(angle) * MathUtils.sin(MathUtils.PI2 * elapsedTime / period);
        return new Circle(x, y, radius);
    }
}
