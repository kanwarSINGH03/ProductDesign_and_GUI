package com.example.a4_3;

public class SpaceController {
    private InteractionModel interactionModel;
    private SpaceModel model;

    public void setModel(SpaceModel model){
        this.model=model;
    }
    public SpaceController(InteractionModel interactionModel){
        this.interactionModel=interactionModel;
    }


    public void handleAnimationTick() {
        if (interactionModel.isAsteroidMovementEnabled())
        {
          model.moveAsteroids();
          model.moveAsteroids();
        }
        if (interactionModel.isAsteroidSpinEnabled())
        {
          model.spinAsteroids();}
        interactionModel.incrementWorldRotation(Math.toRadians(interactionModel.getRotationSpeed()));
    }

}
