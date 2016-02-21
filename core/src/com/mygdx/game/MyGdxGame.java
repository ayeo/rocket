package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter
{
    private Texture rocketImage;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Rocket rocket;
    private Sprite sprite;

	@Override
	public void create()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        rocketImage = new Texture(Gdx.files.internal("core/assets/rocket.png"));

        sprite = new Sprite(rocketImage);
        sprite.setSize(46, 80);
        sprite.setOrigin(23, 40);

        rocket = new Rocket(100, 100);
	}

	@Override
	public void render()
    {
        updateRocketPosition();
        drawScene();
	}

    private void drawScene()
    {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined); //todo: check what this does

        batch.begin();
        sprite.setPosition(rocket.getX(),rocket.getY());
        sprite.setRotation((float) rocket.getAngle());
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose()
    {
        rocketImage.dispose();
        batch.dispose();
    }


    private void updateRocketPosition()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.W))
        {
            rocket.rotateClockwise();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.E))
        {
            rocket.rotateAnticlockwise();
        }

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


}
