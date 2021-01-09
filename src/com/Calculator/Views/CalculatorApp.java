package com.Calculator.Views;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    public void start(Stage primaryStage) throws Exception{
       //setting up the app
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image("com/Calculator/Assets/calculator.png"));

        GridPane root = new GridPane();

        primaryStage.setWidth(375);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

}
