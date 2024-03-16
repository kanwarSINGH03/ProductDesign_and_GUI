package com.example.a3_2;

public class InteractionModel {
    private Box current;
    private BoxView view;

    private Box selected;

    public InteractionModel() {
        current = null;
        selected = null;
    }

    public void setView(BoxView view){
        this.view = view;
    }
    public void Current(Box box) {
        current = box;
        current.isCurrent(true);
    }

    public Box getCurrent() {
        return current;
    }

    public void unCurr() {
        current = null;
    }

    public void select(Box box) {
        selected = box;
        selected.isSelected(true);
    }

    public Box getSelected() {
        return selected;
    }

    public void unSelect() {
        selected = null;
    }

}
