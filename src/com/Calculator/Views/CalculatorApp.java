package com.Calculator.Views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    public void start(Stage primaryStage) throws Exception{
       //setting up the app
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image("com/Calculator/Assets/calculator.png"));
        GridPane root = new GridPane();

        Label calFinal = new Label("");
        TextField calInput = new TextField();
        calInput.setPromptText("Enter a number");

        Button calZero = new Button("0");
        Button calOne = new Button("1");
        Button calTwo = new Button("2");
        Button calThree = new Button("3");
        Button calFour = new Button("4");
        Button calFive = new Button("5");
        Button calSix = new Button("6");
        Button calSeven = new Button("7");
        Button calEight = new Button("8");
        Button calNine = new Button("9");
        Button calEqual = new Button("=");
        Button calPlus = new Button("+");

        

        //setting up the scene and width
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(375);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

}
