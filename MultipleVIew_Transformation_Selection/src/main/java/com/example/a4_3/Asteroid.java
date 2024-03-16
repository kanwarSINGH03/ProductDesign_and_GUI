package com.example.a4_3;

import java.util.Random;

public class Asteroid {
    private double x;
    private double y;
    private double angle;
    private double xVelocity;
    private double yVelocity;
    private double aVelocity;
    private double radius;
    private double[] randXPoints;
    private double[] randYPoints;
    private final Random random = new Random();

    public Asteroid(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.angle = random.nextDouble() * 2 * Math.PI;
        this.xVelocity = random.nextDouble() * 0.001 - 0.5;
        this.yVelocity = random.nextDouble() * 0.001 - 0.5;
        this.aVelocity = random.nextDouble() * 0.001 - 0.005;
        generateRandomPolygon();
    }

    public void updatePosition() {
        x = (x + xVelocity + 1) % 1;
        y = (y + yVelocity + 1) % 1;
    }

    public void rotate() {
        angle = (angle + aVelocity + 2 * Math.PI) % (2 * Math.PI);
    }

    private void generateRandomPolygon() {
        int sections = 4 + random.nextInt(5);
        randXPoints = new double[sections];
        randYPoints = new double[sections];
        for (int i = 0; i < sections; i++) {
            double angle = 2 * Math.PI * i / sections;
            double rad = radius * (0.15 + random.nextDouble() * 1.2);
            randXPoints[i]=(rad * Math.cos(angle));
            randYPoints[i]=(rad * Math.sin(angle));
        }
    }

    public double[] getRandX() {
        return randXPoints;
    }

    public double[] getRandY() {
        return randYPoints;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAngle() {
        return angle;
    }

    public double getAVelocity() {
        return aVelocity;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setAVelocity(double aVelocity) {
        this.aVelocity = aVelocity;
    }


    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
}


