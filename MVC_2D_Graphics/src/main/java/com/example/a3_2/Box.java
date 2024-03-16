package com.example.a3_2;

public class Box {

    private double x;
    private double y;

    private double side;

    private boolean isCurrent = false;

    private boolean isSelected = false;

    public Box()
    {
        this.x = 100;
        this.y = 100;
        this.side = 100;
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getSide(){
        return this.side;
    }
    public void setSide(double side){this.side = side;}

    public void setX(double x) {
         this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void isCurrent(boolean bool) {
       this.isCurrent = bool;
    }

    public boolean isCurrent(){
        return this.isCurrent;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void isSelected(boolean bool) {

        this.isSelected = bool;
    }




}
