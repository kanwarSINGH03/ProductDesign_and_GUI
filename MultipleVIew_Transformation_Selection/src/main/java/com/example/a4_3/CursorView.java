package com.example.a4_3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class CursorView extends StackPane implements Subscriber  {

    Canvas canvas;
    GraphicsContext gc;
    InteractionModel interactionModel;
    double zoomFactor = 2.0; // Assuming the main view is 1X, this is 2X zoom.
    double cursorX = 0.5; // Default cursor position in the middle of the view
    double cursorY = 0.5; // Default cursor position in the middle of the view
    Random random = new Random();
    SpaceModel model;

    public CursorView(InteractionModel interactionModel,SpaceModel model) {
        this.interactionModel = interactionModel;
        this.model = model;
        canvas = new Canvas(150, 150); // Same size as the MiniView
        gc = canvas.getGraphicsContext2D();
        this.getChildren().add(canvas);
        this.setOnMouseMoved(event -> {
            double normalizedX = event.getX() / this.getWidth();
            double normalizedY = event.getY() / this.getHeight();
            interactionModel.updateCursorPosition(normalizedX, normalizedY);
        });
    }

    public void updateViewWithCursor() {
        // Use the interactionModel's cursorX and cursorY to adjust the view
        cursorX = interactionModel.getCursorX();
        cursorY = interactionModel.getCursorY();
        // Call draw with the current asteroid list and star list.
        draw(model.getAsteroidList(), model.getStarList());
    }

    public void draw(List<Asteroid> asteroids, List<Star> stars) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Black background

        double viewportWidth = canvas.getWidth() / zoomFactor;
        double viewportHeight = canvas.getHeight() / zoomFactor;
        double viewportX = cursorX - viewportWidth / 2;
        double viewportY = cursorY - viewportHeight / 2;

        // Adjust the viewport to ensure it doesn't go out of bounds
        viewportX = Math.max(0, Math.min(viewportX, 1 - viewportWidth));
        viewportY = Math.max(0, Math.min(viewportY, 1 - viewportHeight));

        // Draw stars
        gc.setFill(Color.WHITE);
        for (Star star : stars) {
            double x = (star.getX() * canvas.getWidth() - viewportX) * zoomFactor;
            double y = (star.getY() * canvas.getHeight() - viewportY) * zoomFactor;
            gc.fillOval(x, y,random.nextDouble(2) * zoomFactor, random.nextDouble(2) * zoomFactor); // Adjust star size according to zoom
        }

        // Draw asteroids
        gc.setFill(Color.GRAY);
        for (Asteroid asteroid : asteroids) {
            double x = (asteroid.getX() * canvas.getWidth() - viewportX) * zoomFactor;
            double y = (asteroid.getY() * canvas.getHeight() - viewportY) * zoomFactor;

            gc.save();
            gc.translate(x, y);
            gc.rotate(Math.toDegrees(asteroid.getAngle()));

            double[] polygonX = asteroid.getRandX();
            double[] polygonY = asteroid.getRandY();
            double[] xPoints = new double[polygonX.length];
            double[] yPoints = new double[polygonY.length];
            for (int i = 0; i < polygonX.length; i++) {
                xPoints[i] = polygonX[i] * canvas.getWidth()*zoomFactor*zoomFactor; // Adjust asteroid points according to zoom
                yPoints[i] = polygonY[i] * canvas.getHeight()*zoomFactor*zoomFactor; // Adjust asteroid points according to zoom
            }
            gc.fillPolygon(xPoints, yPoints, xPoints.length);
            gc.restore();
        }
    }

    public void modelChanged(List<Asteroid> a, List<Star> s) {

    }

    public void worldView() {
        updateViewWithCursor();
    }
}
