package com.example.a3_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        MainUI root = new MainUI();

        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}
