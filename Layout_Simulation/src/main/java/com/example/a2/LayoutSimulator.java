package com.example.a2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LayoutSimulator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        LayoutView root = new LayoutView();
        root.setPrefSize(500,400);

        Scene scene = new Scene(root);

        stage.setTitle("Layout Simulator");
        scene.setFill(Color.GREEN);
        stage.setScene(scene);
        stage.show();


    }
}
