package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;


public class MyGdxGame extends ApplicationAdapter
{
    private Texture rocketImage;

    private Sound dropSound;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Rectangle bucket;

    private Rocket rocket;

	@Override
	public void create()
    {
        rocketImage = new Texture(Gdx.files.internal("core/assets/rocket.png"));
		dropSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/drop.wav"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        batch = new SpriteBatch();
        rocket = new Rocket(100, 100);
	}

    private void updateRocketPosition()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            rocket.moveLeft(200 * Gdx.graphics.getDeltaTime());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            rocket.moveRight(200 * Gdx.graphics.getDeltaTime());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            rocket.moveUp(200 * Gdx.graphics.getDeltaTime());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            rocket.moveDown(200 * Gdx.graphics.getDeltaTime());
        }
    }

	@Override
	public void render () {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined); //todo: check what this does

        batch.begin();
        batch.draw(rocketImage, rocket.getX(), rocket.getY(), 46, 80);
        batch.end();

        updateRocketPosition();
	}


    @Override
    public void dispose()
    {
        dropSound.dispose();
        batch.dispose();
    }


}
