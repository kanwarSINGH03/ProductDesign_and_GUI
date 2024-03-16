package com.example.a4_3;

import java.util.List;

public interface Subscriber {
    public void modelChanged(List<Asteroid> a,List<Star> s);
    public void worldView();

}
