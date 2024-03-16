package com.example.a3_2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.List;

public class BoxView extends StackPane implements Subscriber {



    Canvas myCanvas; // canvas is what you draw on
    GraphicsContext gc; // graphics context is what you "draw with"

    private InteractionModel iModel;

    public BoxView() {
        myCanvas = new Canvas(800, 800);
        gc = myCanvas.getGraphicsContext2D();


        this.getChildren().add(myCanvas);
        myCanvas.setFocusTraversable(true);
        myCanvas.requestFocus();
    }

    public void setupEvents(AppController controller) {

        this.setOnKeyPressed(controller::handleKeyPressed);

    }
    public void setiModel(InteractionModel iModel){
        this.iModel = iModel;
    }
    public void draw(List<Box> boxes) {
        gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());

        for (int i =0;i<boxes.size();i++)
        {

            Box box = boxes.get(i);

            if (box.isCurrent()){
                gc.setFill(Color.RED);
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(4);
            } else if (box.isSelected()) {
                gc.setFill(Color.YELLOW);
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(4);

            } else {
                gc.setFill(Color.LIGHTBLUE);
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(4);
            }
            gc.fillRect(box.getX(), box.getY(), box.getSide(), box.getSide());
            gc.strokeRect(box.getX(), box.getY(), box.getSide(), box.getSide());

        }


    }
    public void modelChanged(List<Box> boxes){

        draw(boxes);
    }


}
