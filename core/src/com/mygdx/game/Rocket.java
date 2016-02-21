package com.mygdx.game;

public class Rocket
{
    private int x;

    private int y;

    private double velocity;

    private double angle;

    public Rocket(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void moveLeft(float value)
    {
        this.x -= value;
    }

    public void moveRight(float value)
    {
        this.x += value;
    }

    public void moveDown(float value)
    {
        this.y -= value;
    }

    public void moveUp(float value)
    {
        this.y += value;
    }

    public void rotateClockwise()
    {
        this.angle -= 1;
    }

    public void rotateAnticlockwise()
    {
        this.angle += 1;
    }

    public double getAngle()
    {
        return this.angle;
    }
}
