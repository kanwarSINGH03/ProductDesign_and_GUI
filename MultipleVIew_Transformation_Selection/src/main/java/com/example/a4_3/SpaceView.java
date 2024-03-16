package com.example.a4_3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class SpaceView extends StackPane implements Subscriber {
    Canvas canvas;   //The canvas
    InteractionModel interactionModel;
    GraphicsContext gc;   //The pen
    Random random = new Random();

    public SpaceView(InteractionModel interactionModel){
        canvas= new Canvas(500,500);   //Setting up the view
        gc = canvas.getGraphicsContext2D();
        this.getChildren().add(canvas);
        this.interactionModel=interactionModel;
        canvas.setOnMouseMoved(event -> {
            double normalizedX = event.getX() / canvas.getWidth();
            double normalizedY = event.getY() / canvas.getHeight();
            interactionModel.updateCursorPosition(normalizedX, normalizedY);
            // Assuming there's a method in interactionModel to update subscribers
            interactionModel.notifyCursorPositionChanged();
        });
    }
    public void draw(List<Asteroid> asteroids,List<Star> stars){
        clearCanvas();

        gc.setFill(Color.WHITE);  //Making stars in the background

        gc.save();
        gc.translate(canvas.getWidth()/2,canvas.getHeight()/2);
        gc.rotate(Math.toDegrees(interactionModel.getWorldRotation()));
        gc.translate(-canvas.getWidth() / 2, -canvas.getHeight() / 2);
        for(Star star:stars){
            double x = star.getX() * canvas.getWidth();
            double y = star.getY()*canvas.getHeight();
            gc.fillOval(x,y,random.nextDouble(2) ,random.nextDouble(2));
        }
        //making asteroid
        gc.setFill(Color.GRAY);
        for (Asteroid asteroid: asteroids){
            double wrappedX = ((asteroid.getX() + 1) % 1) * canvas.getWidth();
            double wrappedY = ((asteroid.getY() + 1) % 1) * canvas.getHeight();
            gc.save();
            gc.translate(wrappedX , wrappedY );
            gc.rotate(Math.toDegrees(asteroid.getAngle()));
            double[] polygonX = asteroid.getRandX();
            double[] polygonY = asteroid.getRandY();
            double[] xPoints = new double[polygonX.length];
            double[] yPoints = new double[polygonY.length];
            for (int i = 0; i < polygonX.length; i++) {
                xPoints[i] = polygonX[i] * canvas.getWidth();
                yPoints[i] = polygonY[i] * canvas.getHeight();
            }
            gc.fillPolygon(xPoints, yPoints, xPoints.length);
            gc.restore();
        }
        gc.restore();
    }
    private void drawStars(){

    }

    private void clearCanvas()
    {
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight()); //making black background
    }

    private void drawAsteroids(){

    }

    public void modelChanged(List<Asteroid> a, List<Star> s){
        draw(a,s);
    }
    public void worldView(){

    }
}
