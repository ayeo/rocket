package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter
{
    private Texture rocketImage;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Rocket rocket;
    private Sprite sprite;

    private BitmapFont font;

	@Override
	public void create()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        rocketImage = new Texture(Gdx.files.internal("core/assets/rocket.png"));

        sprite = new Sprite(rocketImage);
        sprite.setSize(40, 22);
        sprite.setOrigin(20, 11);


        rocket = new Rocket(new RocketProperties(200));
        rocket.setPosition(400, 100);

        font = new BitmapFont();
        font.setColor(Color.RED);
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

        rocket.update(Gdx.graphics.getDeltaTime());

        camera.update();
        batch.setProjectionMatrix(camera.combined); //todo: check what this does


        batch.begin();
        sprite.setPosition(rocket.getX(),rocket.getY());
        sprite.setRotation(rocket.getAngle(Gdx.graphics.getDeltaTime()));
        sprite.draw(batch);
        batch.end();

        batch.begin();
        font.draw(batch, "angle " + String.valueOf((int) rocket.getAngle(Gdx.graphics.getDeltaTime())), 10, 450);
        font.draw(batch, "angleSpeed " + String.valueOf((int) rocket.getAngleSpeed()), 10, 430);
        font.draw(batch, "x " + String.valueOf((int) rocket.getX()), 10, 410);
        font.draw(batch, "y " + String.valueOf((int) rocket.getY()), 10, 390);
        font.draw(batch, "speed " + String.valueOf((int) rocket.getSpeed()), 10, 370);
        //font.draw(batch, "delta " + String.valueOf(Gdx.graphics.getDeltaTime()), 10, 350);
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
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            rocket.rotateAnticlockwise();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            rocket.rotateClockwise();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            rocket.increaseVelocity();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            rocket.decreaseVelocity();
        }
    }


}
