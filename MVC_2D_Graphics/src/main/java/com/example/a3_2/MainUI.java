package com.example.a3_2;

import javafx.scene.layout.StackPane;

public class MainUI extends StackPane {



    public MainUI() {
        // create MVC components
        AppController controller = new AppController();
        BoxView view = new BoxView();
        BoxModel model = new BoxModel();
        InteractionModel iModel = new InteractionModel();

        // link MVC together

        view.setupEvents(controller);
        iModel.setView(view);
        view.setiModel(iModel);
        controller.setModel(model);
        controller.setIModel(iModel);
        model.addSubscriber(view);


        this.getChildren().add(view);
    }
}
