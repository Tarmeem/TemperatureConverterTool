// 
// Decompiled by Procyon v0.5.36
// 

package com.internshala.javafxapp;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

public class Controller implements Initializable
{
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;
    private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";
    private boolean isC_TO_F;
    
    public Controller() {
        this.isC_TO_F = true;
    }
    
    public void initialize(final URL location, final ResourceBundle resources) {
        this.choiceBox.getItems().add((Object)"Celsius to Fahrenheit");
        this.choiceBox.getItems().add((Object)"Fahrenheit to Celsius");
        this.choiceBox.setValue((Object)"Celsius to Fahrenheit");
        this.choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Celsius to Fahrenheit")) {
                this.isC_TO_F = true;
            }
            else {
                this.isC_TO_F = false;
            }
        });
        this.convertButton.setOnAction(event -> this.convert());
    }
    
    private void convert() {
        final String input = this.userInputField.getText();
        float enteredTemperature = 0.0f;
        try {
            enteredTemperature = Float.parseFloat(input);
        }
        catch (Exception exception) {
            this.warnUser();
            return;
        }
        float newTemperature = 0.0f;
        if (this.isC_TO_F) {
            newTemperature = enteredTemperature * 9.0f / 5.0f + 32.0f;
        }
        else {
            newTemperature = (enteredTemperature - 32.0f) * 5.0f / 9.0f;
        }
        this.display(newTemperature);
    }
    
    private void warnUser() {
        final Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }
    
    private void display(final float newTemperature) {
        final String unit = this.isC_TO_F ? " F" : " C";
        System.out.println("The new temperature is: " + newTemperature + unit);
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: " + newTemperature + unit);
        alert.show();
    }
}
