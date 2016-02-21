package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Rocket
{
    private float x;

    private float y;

    private double velocity = 1;

    private float angle = 0;

    public Rocket(int x, int y)
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
        this.angle -= 2;
    }

    public void rotateAnticlockwise()
    {
        this.angle += 2;
    }

    public float getAngle()
    {
        return this.angle;
    }

    public void increaseVelocity()
    {
        this.velocity += 5;

        if (this.velocity > 550)
        {
            this.velocity = 550;
        }
    }

    public void decreaseVelocity()
    {
        this.velocity -= 5;

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

    public double getSpeed()
    {
        return this.velocity;
    }
}
