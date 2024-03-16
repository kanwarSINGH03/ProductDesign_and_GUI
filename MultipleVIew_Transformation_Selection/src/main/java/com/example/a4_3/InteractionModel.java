package com.example.a4_3;

public class InteractionModel {
    private double worldRotation = 0.0;
    private double cursorX=0.5;
    private double cursorY=0.5;
    PublishSubscribe publishSubscribe;
    private boolean asteroidMovementEnabled = true;
    private boolean asteroidSpinEnabled = true;
    private double rotationSpeed = 0.0;
    public InteractionModel(PublishSubscribe publishSubscribe){
        this.publishSubscribe=publishSubscribe;
    }
    public void incrementWorldRotation(double angle) {
        worldRotation += angle;
        worldRotation = worldRotation % (2 * Math.PI);
        publishSubscribe.notifySubscribers();
    }
    public void updateCursorPosition(double x, double y) {
        cursorX = x;
        cursorY = y;
        // Notify subscribers about the cursor position update
        publishSubscribe.notifySubscribers();
    }
    public double getWorldRotation() {
        return worldRotation;
    }

    public void setCursorX(double cursorX) {
        this.cursorX = cursorX;
    }

    public double getCursorX() {
        return cursorX;
    }
    public void notifyCursorPositionChanged() {
        publishSubscribe.notifySubscribers();
    }

    public void setCursorY(double cursorY) {
        this.cursorY = cursorY;
    }

    public double getCursorY() {
        return cursorY;
    }
    // Add setters for enabling/disabling asteroid movement and spin
    public void setAsteroidMovementEnabled(boolean enabled) {
        asteroidMovementEnabled = enabled;
        publishSubscribe.notifySubscribers();
    }

    public boolean isAsteroidMovementEnabled() {
        return asteroidMovementEnabled;
    }

    public void setAsteroidSpinEnabled(boolean enabled) {
        asteroidSpinEnabled = enabled;
        publishSubscribe.notifySubscribers();
    }

    public boolean isAsteroidSpinEnabled()
    {
        return asteroidSpinEnabled;
    }

    // Set rotation speed
    public void setRotationSpeed(double speed) {
        rotationSpeed = speed;
        publishSubscribe.notifySubscribers();
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

}

