package com.udacity.gamedev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManagerDemo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float stateTime = 0f;
	TextureRegion currentFrame, currentFrameRight;
	Animation walkLeft, walkRight;

	@Override
	public void create () {
		AssetManager am = new AssetManager();
		Assets.instance.init(am);
		am.finishLoading();
		walkLeft = Assets.instance.getAnimation("walkLeft");
		walkRight = Assets.instance.getAnimation("walkRight");

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = walkLeft.getKeyFrame(stateTime, true);
		currentFrameRight = walkRight.getKeyFrame(stateTime, true);
		batch.begin();
		batch.draw(currentFrame, 100, 100);
		batch.draw(currentFrameRight, 200,200);
		batch.end();
	}
}
