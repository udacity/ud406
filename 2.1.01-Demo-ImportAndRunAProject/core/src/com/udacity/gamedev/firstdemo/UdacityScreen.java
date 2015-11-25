package com.udacity.gamedev.firstdemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class UdacityScreen extends InputAdapter implements Screen {

    private static final Color UDACITY_ORANGE = new Color(228.0f / 225.0f, 127.0f / 225.0f, 57.0f / 225.0f, 1.0f);
    private static final float LOGO_WIDTH = 200.0f;
    SpriteBatch batch;
    Texture logo;
    ParticleEffectPool touchEffectPool;
    Array<PooledEffect> effects = new Array<PooledEffect>();
    private float logoHeight;

    @Override
    public void show() {
        batch = new SpriteBatch();
        // TODO: Scavenger hunt! Where does this logo live?
        logo = new Texture("udacity_logo_white.png");
        logoHeight = logo.getHeight() * LOGO_WIDTH / logo.getWidth();

        ParticleEffect touchEffect = new ParticleEffect();
        // TODO: Same question. Where does UdacityEmitter.p live? How are we loading it?
        touchEffect.load(Gdx.files.internal("UdacityEmitter.p"), Gdx.files.internal(""));
        touchEffect.setEmittersCleanUpBlendFunction(false);
        touchEffectPool = new ParticleEffectPool(touchEffect, 1, 2);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        clearScreen(UDACITY_ORANGE);
        batch.begin();
        // TODO: Investigate the .draw() method on SpriteBatch
        batch.draw(logo,
                (Gdx.graphics.getWidth() - LOGO_WIDTH) / 2,
                (Gdx.graphics.getHeight() - logoHeight) / 2,
                LOGO_WIDTH,
                logoHeight);
        // TODO: Why are we iterating backwards?
        for (int i = effects.size - 1; i >= 0; i--) {
            PooledEffect effect = effects.get(i);
            effect.draw(batch, delta);
            if (effect.isComplete()) {
                effect.free();
                effects.removeIndex(i);
            }
        }
        batch.end();
    }

    private void clearScreen(Color color) {
        // TODO: Investigate this Gdx.gl thing
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void spawnParticleEffect(int x, int y) {
        PooledEffect effect = touchEffectPool.obtain();
        effect.setPosition(x, Gdx.graphics.getHeight() - y);
        effects.add(effect);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        spawnParticleEffect(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        spawnParticleEffect(screenX, screenY);
        return false;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        batch.dispose();
        logo.dispose();
        for (int i = effects.size - 1; i >= 0; i--)
            effects.get(i).free();
        effects.clear();
    }

    @Override
    public void dispose() {

    }
}
