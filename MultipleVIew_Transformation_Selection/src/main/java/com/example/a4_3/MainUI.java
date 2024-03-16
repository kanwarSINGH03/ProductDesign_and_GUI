package com.example.a4_3;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainUI extends HBox {
    public MainUI(){
        PublishSubscribe publishSubscribe = new PublishSubscribe();
        InteractionModel interactionModel = new InteractionModel(publishSubscribe);
        SpaceView mainView = new SpaceView(interactionModel); // Main view
        MiniView miniView = new MiniView(interactionModel); // Miniature view
        ControlPanelView controlPanelView = new ControlPanelView(interactionModel);
        SpaceModel model = new SpaceModel(publishSubscribe);
        CursorView cursorView = new CursorView(interactionModel,model);
        SpaceController controller = new SpaceController(interactionModel);

        model.Asteroid();
        model.Stars();

        // Subscribe both views to the publish-subscribe system
        publishSubscribe.addSubscriber(mainView);
        publishSubscribe.addSubscriber(miniView);
        publishSubscribe.addSubscriber(cursorView);
        controller.setModel(model);

        VBox leftPanel = new VBox(miniView,cursorView,controlPanelView);


        // Add the left panel and the main view to the HBox
        this.getChildren().addAll(leftPanel, mainView);
        this.setStyle("-fx-base: #191919; -fx-background-color: #191919");

        // Initial update to the views
        mainView.modelChanged(model.getAsteroidList(), model.getStarList());
        miniView.modelChanged(model.getAsteroidList(), model.getStarList());
        cursorView.modelChanged(model.getAsteroidList(),model.getStarList());

        // Animation timer to drive the game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                controller.handleAnimationTick();
            }
        };
        timer.start();
    }
}
