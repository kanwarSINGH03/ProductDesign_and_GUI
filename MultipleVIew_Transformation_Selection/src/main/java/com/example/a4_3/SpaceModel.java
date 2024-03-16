package com.example.a4_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceModel {
    private PublishSubscribe publishSubscribe;
    private Random random;
    private List<Asteroid> asteroidList;
    private List<Star> starList;
    public SpaceModel(PublishSubscribe publishSubscribe){
        this.asteroidList = new ArrayList<>();
        this.starList=new ArrayList<>();
        this.random = new Random();
        this.publishSubscribe=publishSubscribe;
    }

    public List<Asteroid> getAsteroidList() {
        return asteroidList;
    }

    public List<Star> getStarList() {
        return starList;
    }
    public void Stars(){
        for(int i=0;i<100;i++){
            double x = random.nextDouble();
            double y = random.nextDouble();
            starList.add(new Star(x,y));
        }
        publishSubscribe.notifySubscribers(asteroidList,starList);
    }
    public void Asteroid(){
        for(int i=0;i<10;i++){
            double x = random.nextDouble();
            double y = random.nextDouble();
            double r = random.nextDouble()*0.05 + 0.03;
            asteroidList.add(new Asteroid(x,y,r));
        }
        publishSubscribe.notifySubscribers(asteroidList,starList);
    }
    public void moveAsteroids() {
        for (Asteroid asteroid : asteroidList) {
            asteroid.updatePosition();
        }
        publishSubscribe.notifySubscribers(asteroidList, starList);
    }

    public void spinAsteroids() {
        for (Asteroid asteroid : asteroidList) {
            asteroid.rotate();
            }
        publishSubscribe.notifySubscribers(asteroidList, starList);
        }


}
