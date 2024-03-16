package com.example.a2;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class LinearLayout {

    private ArrayList<SimWidget> sim_list = new ArrayList<>();
    private Rectangle layout_container;

    /**
     * Linear layout constructor
     */
    public LinearLayout() {

        layout_container = new Rectangle();
        layout_container.setStroke(Color.PURPLE);
        layout_container.setFill(Color.ORANGE);


    }

    /**
     *
     * @param width width of the linear layout widget
     * @param height width of the linear layout widget
     */
    public void  doLayout(double width, double height)
    {       //Part 1
//       double currentX = 0; // horizontal position where next child will be placed
////       double container_width =0;
//      double maxHeight = 0; // to track maximum height among the children
//
//        for (SimWidget sw : sim_list) {
//
//                sw.myLeft = currentX;
//                sw.myTop = 0;
//                sw.myWidth = sw.minWidth; // using minWidth for width
//                sw.myHeight = sw.prefHeight; // using prefHeight for height
//
//                // Update widget's Rectangle position and size
//                sw.rectangle.setX(sw.myLeft);
//                sw.rectangle.setY(sw.myTop);
//                sw.rectangle.setWidth(sw.myWidth);
//                sw.rectangle.setHeight(sw.myHeight);
//
//                currentX += sw.minWidth; // move to the next position for the subsequent widget
////                container_width+=sw.maxWidth;
//
//                if (sw.myHeight > maxHeight) {
//                    maxHeight = sw.myHeight;
//                }
//
////            System.out.println(sw.myLeft);
//            }
//
//        layout_container.setWidth(currentX);
//       layout_container.setHeight(maxHeight);

        doHorizontalLayout(0,width);
        doVerticalLayout(0,height);



        }


    /**
     *
     * @param child adds a given child to the simwidget arraylist
     */
    public void addChild(SimWidget child) {

        sim_list.add(child);

    }

    /**
     *
     * @return returns the simwidget list
     */
    public ArrayList<SimWidget> getSim_list (){
        return sim_list;
    }

    /**
     *
     * @return returns the rectangle of linear layout
     */

    public Rectangle getLayout_container(){
        return this.layout_container;
    }

    /**
     *
     * @return calculates the variable intrinsic size that is the total minimum width of all the simwidgets
     */
    public double calculateVIS() {
        double totalWidth = 0;
        for (SimWidget sw : sim_list)
        {
            totalWidth += sw.minWidth;
        }
        return totalWidth;
    }
    /**
     *
     * @param parcelLeft x position of the parcel from left
     * @param parcelRight x position of the parcel from right
     */

    public void doHorizontalLayout(double parcelLeft, double parcelRight) {
        double availableSpace = parcelRight - parcelLeft;
        double totalMinWidth = calculateVIS();
        double extraSpace = availableSpace - totalMinWidth;

        double currentX = parcelLeft;

        for (SimWidget sw : sim_list)
        {
            double childWidthAllocated = sw.minWidth + (sw.minWidth / totalMinWidth) * extraSpace;
            childWidthAllocated = Math.min(childWidthAllocated, sw.maxWidth);

            sw.doHorizontalLayout(currentX, currentX + childWidthAllocated);
            currentX += childWidthAllocated;
        }

        layout_container.setWidth(parcelRight);

    }
    /**
     *
     * @param parcelTop y position of the parcel from top
     * @param parcelBottom y position of the parcel from bottom
     */
    public void doVerticalLayout(double parcelTop, double parcelBottom) {
        for (SimWidget sw : sim_list) {
            sw.doVerticalLayout(parcelTop, parcelBottom);
        }
        layout_container.setHeight(parcelBottom);

    }






}
