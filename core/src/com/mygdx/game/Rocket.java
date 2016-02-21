package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket
{
    private RocketProperties properties;

    private float x = 0;

    private float y = 0;

    private float velocity = 0;

    private float angle = 90;

    private float angleSpeed = 0;

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
        angleSpeed--;

        if (angleSpeed < -100)
        {
            angleSpeed = -100;
        }
    }

    public void rotateAnticlockwise()
    {
        angleSpeed++;

        if (angleSpeed > 100)
        {
            angleSpeed = 100;
        }
    }

    public float getAngle(float delta)
    {
        angle += delta * angleSpeed;

        if (angle > 360)
        {
            angle -= 360;
        }

        if (angle < 0)
        {
            angle += 360;
        }

        return angle;
    }

    public float getAngleSpeed()
    {
        return angleSpeed;
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
        this.x += Math.cos(Math.toRadians(this.getAngle(delta))) * delta * this.velocity;
        this.y += Math.sin(Math.toRadians(this.getAngle(delta))) * delta * this.velocity;
    }

    public float getSpeed()
    {
        return this.velocity;
    }
}
