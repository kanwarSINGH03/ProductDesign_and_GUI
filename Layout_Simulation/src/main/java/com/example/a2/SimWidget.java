package com.example.a2;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SimWidget {
    protected double minWidth, maxWidth, prefHeight;
    protected double myLeft, myTop, myWidth, myHeight;
    protected Rectangle rectangle;

    private VerticalPosition verticalPosition;

    public enum VerticalPosition {
        TOP, MIDDLE, FILL
    }

    /**
     *
     * @param minWidth minimum width of the widget
     * @param maxWidth maximum width of the widget
     * @param prefHeight preferred height of the widget
     * @param vp vertical constraint of the widget
     */

    public SimWidget(double minWidth, double maxWidth, double prefHeight , VerticalPosition vp)
    {
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.prefHeight = prefHeight;
        this.verticalPosition = vp;

        rectangle = new Rectangle();
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.YELLOW);

//        this.getChildren().add(rectangle);
    }

    /**
     *
     * @return getter for the rectangle instance variable
     */
    public Rectangle getRectangle(){
        return this.rectangle;
    }

    /**
     *
     * @param parcelLeft x position of the parcel from left
     * @param parcelRight x position of the parcel from right
     */

    public void doHorizontalLayout(double parcelLeft, double parcelRight)
    {
        myWidth = Math.max(minWidth, Math.min(maxWidth, parcelRight - parcelLeft));
//        myWidth = parcelRight - parcelLeft;
        myLeft = parcelLeft;

        rectangle.setX(myLeft);
        rectangle.setWidth(myWidth);
    }

    /**
     *
     * @param parcelTop y position of the parcel from top
     * @param parcelBottom y position of the parcel from bottom
     */

    public void doVerticalLayout(double parcelTop, double parcelBottom){

        double parcelHeight = parcelBottom - parcelTop;
        double widgetHeight = Math.min(prefHeight, parcelHeight);

        switch (verticalPosition) {
            case TOP:
                myTop = parcelTop;
                break;
            case MIDDLE:
                myTop = parcelTop + (parcelHeight - widgetHeight) / 2;
                break;
            case FILL:
                myTop = parcelTop;
                widgetHeight = parcelHeight;
                break;
        }

        myHeight = widgetHeight;
        rectangle.setY(myTop);
        rectangle.setHeight(myHeight);

    }

}

