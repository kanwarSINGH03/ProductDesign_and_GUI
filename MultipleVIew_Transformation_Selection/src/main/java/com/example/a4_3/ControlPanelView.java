package com.example.a4_3;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ControlPanelView extends VBox {
    private Slider rotationSpeedSlider;
    private CheckBox asteroidMovementCheckBox;
    private CheckBox asteroidSpinCheckBox;
    private InteractionModel interactionModel;

    public ControlPanelView(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;

        // Create the components
        Label label = new Label("Rotation Speed");
        rotationSpeedSlider = new Slider(0, 10, 0); // Min, Max, Default values
        rotationSpeedSlider.setShowTickLabels(true);
        asteroidMovementCheckBox = new CheckBox("Asteroid Movement");
        asteroidSpinCheckBox = new CheckBox("Asteroid Spin");

        // Set default states
        asteroidMovementCheckBox.setSelected(true);
        asteroidSpinCheckBox.setSelected(true);

        // Add components to the VBox
        this.getChildren().addAll(label, rotationSpeedSlider, asteroidMovementCheckBox, asteroidSpinCheckBox);
        this.setSpacing(10);
        this.setPadding(new Insets(10));

        // Event handling
        setupEventHandlers();
    }

    private void setupEventHandlers() {
         //Handle rotation speed changes
        rotationSpeedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            interactionModel.setRotationSpeed(newValue.doubleValue()/3);
        });

        // Handle asteroid movement checkbox
        asteroidMovementCheckBox.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            interactionModel.setAsteroidMovementEnabled(isSelected);
        });

        // Handle asteroid spin checkbox
        asteroidSpinCheckBox.selectedProperty().addListener((observable, oldValue, isSelected) -> {
            interactionModel.setAsteroidSpinEnabled(isSelected);
        });
    }
}

