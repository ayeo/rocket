package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket
{
    private RocketProperties properties;

    private float x = 0;

    private float y = 0;

    private float velocity = 0;

    private float angle = 90;

    public Rocket(RocketProperties properties)
    {
        this.properties = properties;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public void rotateClockwise()
    {
        angle -= 1;

        if (angle < 0)
        {
            angle += 360;
        }
    }

    public void rotateAnticlockwise()
    {
        this.angle += 1;

        if (angle > 360)
        {
            angle -= 360;
        }
    }

    public float getAngle()
    {
        return this.angle;
    }

    public void increaseVelocity()
    {
        this.velocity += 1;

        if (this.velocity > properties.getVMax())
        {
            this.velocity = properties.getVMax();
        }
    }

    public void decreaseVelocity()
    {
        this.velocity -= 1;

        if (this.velocity < 0)
        {
            this.velocity = 0;
        }
    }

    public void update(float delta)
    {
        Vector2 direction = new Vector2();
        direction.x = (float) Math.cos(Math.toRadians(this.getAngle()));
        direction.y = (float) Math.sin(Math.toRadians(this.getAngle()));

        this.x += direction.x * delta * this.velocity;
        this.y += direction.y * delta * this.velocity;
    }

    public float getSpeed()
    {
        return this.velocity;
    }
}
