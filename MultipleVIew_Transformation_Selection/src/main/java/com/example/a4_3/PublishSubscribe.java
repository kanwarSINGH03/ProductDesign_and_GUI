package com.example.a4_3;


import java.util.ArrayList;
import java.util.List;

public class PublishSubscribe {
    private List<Subscriber> subscribers;

    public PublishSubscribe() {
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }


    public void notifySubscribers(List<Asteroid> asteroids,List<Star> stars)
    {
        for (Subscriber subscriber : subscribers) {
            subscriber.modelChanged(asteroids,stars);
        }
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.worldView();
        }
    }

}
