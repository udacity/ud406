package com.udacity.gamedev.rectanglecirclecollision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class RectangleCircleCollisionScreen extends ScreenAdapter {


    private static final float WORLD_SIZE = 100f;
    private static final int circleSegments = 64;

    private final long startTime;
    private ShapeRenderer shapeRenderer;
    private FitViewport viewport;

    private Array<Rectangle> rectangles;
    private Array<OscillatingCircle> circles;


    public RectangleCircleCollisionScreen() {
        startTime = TimeUtils.nanoTime();
        shapeRenderer = new ShapeRenderer();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);

        rectangles = new Array<Rectangle>(new Rectangle[]{
                new Rectangle(40, 40, 20, 20), // Middle
                new Rectangle(10, 40, 10, 20), // Left
                new Rectangle(70, 45, 20, 10) // Right
        });

        circles = new Array<OscillatingCircle>(new OscillatingCircle[]{
                new OscillatingCircle(50, 65, 7, 0, 40, 3), // High horizontal
                new OscillatingCircle(50, 35, 7, 0, 40, 3.1f), // Low horizontal
                new OscillatingCircle(50, 50, 3, MathUtils.PI / 4, 40, 5f), // Diagonal
                new OscillatingCircle(25, 50, 5, 0, 11, 7f), // Middle horizontal
        });
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        float elapsedTime = MathUtils.nanoToSec * TimeUtils.timeSinceNanos(startTime);

        viewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1);

        for (Rectangle rectangle : rectangles) {
            shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }

        for (OscillatingCircle oscillatingCircle : circles) {
            Circle circle = oscillatingCircle.getCurrentCircle(elapsedTime);

            boolean colliding = false;
            for (Rectangle rectangle : rectangles) {
                if (areColliding(rectangle, circle)) {
                    colliding = true;
                    break;
                }
            }

            if (colliding) {
                shapeRenderer.setColor(1, 0, 0, 1);
            } else {
                shapeRenderer.setColor(0, 1, 0, 1);
            }

            shapeRenderer.circle(circle.x, circle.y, circle.radius, circleSegments);


        }

        shapeRenderer.end();


    }

    private boolean areColliding(Rectangle rectangle, Circle circle) {

        // TODO: Complete this function!

        boolean containsACorner = circle.contains(rectangle.x, rectangle.y) || // Bottom left
                circle.contains(rectangle.x + rectangle.width, rectangle.y) || // Bottom right
                circle.contains(rectangle.x + rectangle.width, rectangle.y + rectangle.height) || // Top Right
                circle.contains(rectangle.x, rectangle.y + rectangle.height); // Top left

        boolean inHorizontalInterval = rectangle.x < circle.x && circle.x < rectangle.x + rectangle.width;
        boolean inVerticalInterval = rectangle.y < circle.y && circle.y < rectangle.y + rectangle.height;

        boolean inHorizontalNeighborhood = rectangle.x - circle.radius < circle.x && circle.x < rectangle.x + rectangle.width + circle.radius;
        boolean inVerticalNeighborhood = rectangle.y - circle.radius < circle.y && circle.y < rectangle.y + rectangle.height + circle.radius;

        boolean touchingAnEdge = inHorizontalInterval && inVerticalNeighborhood ||
                inHorizontalNeighborhood && inVerticalInterval;

        return containsACorner || touchingAnEdge;
    }

}
