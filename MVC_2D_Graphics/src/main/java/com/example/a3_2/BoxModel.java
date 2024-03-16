package com.example.a3_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BoxModel {
    private ArrayList<Subscriber> subs; // list of subscribers
    private ArrayList<Box> boxes; // list of circles

    public BoxModel() {
        subs = new ArrayList<Subscriber>();
        boxes = new ArrayList<Box>();
    }

    public void addBox() {
        Box box = new Box();
        if (boxes.isEmpty()) {
            boxes.add(box);
        } else {
            box.setX(boxes.get(boxes.size() - 1).getX() + 50);
            box.setY(boxes.get(boxes.size() - 1).getY() + 50);
            boxes.add(box);

        }
        notifySubscribers();
    }

    public void addSubscriber(Subscriber sub) {
        // add new subscriber to list of subscribers
        subs.add(sub);
    }

    private void notifySubscribers() {
        // for each subscriber, call the modelChanged method
        subs.forEach(sub -> sub.modelChanged(boxes));
    }

    public ArrayList<Box> getBoxes() {

        return boxes;
    }

    public Box cursorOnBox(int index) {
        // TODO
        notifySubscribers();
        return boxes.get(index);

    }

    public Box selectedBox(int index) {
        notifySubscribers();
        return boxes.get(index);
    }

    public void move(Box selected, String key) {
        switch (key) {
            case "Left":
                selected.setX(selected.getX() - 15);
            case "Right":
                selected.setX(selected.getX() + 15);
            case "Up":
                selected.setY(selected.getY() - 15);
            case "Down":
                selected.setY(selected.getY() + 15);
        }
        notifySubscribers();


    }

    public void resize(Box selected, String key) {
        switch (key) {

            case "U":
                selected.setSide(selected.getSide() + 5);
            case "J":
                selected.setSide(selected.getSide() - 5);

        }
    }

    public Box findNearest(Box CursorOn, String key) {

        List<Box> allBoxes = getBoxes(); // Method to get all boxes
        Box nearestBox = null;


        switch (key) {
            case "Left":
            {

                for (int i=0; i<allBoxes.size();i++) {

                    double diff = CursorOn.getX() - allBoxes.get(0).getX();

                    nearestBox = allBoxes.get(0);
                    if(diff > CursorOn.getX()- allBoxes.get(i).getX())
                    {
                        nearestBox = allBoxes.get(i);

                    }




            }
                break;
            }

            case "Right":

            case "Up":

            case "Down":

        }
        notifySubscribers();
        return nearestBox;


    }

    public void selectAll(){
        boxes.forEach(box -> box.isSelected(true));
    }
}


