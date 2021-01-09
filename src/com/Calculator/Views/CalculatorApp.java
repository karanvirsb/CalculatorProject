package com.Calculator.Views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    public void start(Stage primaryStage) throws Exception{
       //setting up the app
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image("com/Calculator/Assets/calculator.png"));

        //The root pane
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.getStylesheets().add("com/Calculator/stylesheets/main.css");

        //the label and textfied
        Label calFinal = new Label("");
        calFinal.setStyle("-fx-text-alignment: right;");
        calFinal.setTextAlignment(TextAlignment.RIGHT);

        TextField calInput = new TextField();

        calInput.setPrefWidth(375);

        //these are the button for the app
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

        //these are the signs
        Button calEqual = new Button("=");
        Button calPlus = new Button("+");
        Button calClearAll = new Button("CE");
        Button calClear = new Button("C");
        Button calBackSpace = new Button ("<-");
        Button calDivision = new Button("/");
        Button calMultiplication = new Button("*");
        Button calMinus = new Button("-");
        Button calNegate = new Button("+/-");
        Button calDot = new Button (".");

        //adding the text and label in
        root.add(calFinal, 0,0, 4, 1);
        root.add(calInput, 0,1, 4, 1);

        //Adding the buttons in for the top row
        root.add(calClearAll, 0, 2);
        root.add(calClear, 1,2);
        root.add(calBackSpace, 2, 2);
        root.add(calDivision, 3, 2);

        //Adding the buttons for the second from top
        root.add(calSeven, 0, 3);
        root.add(calEight, 1, 3);
        root.add(calNine, 2, 3);
        root.add(calMultiplication, 3, 3);

        //Adding the buttons for the thrid row
        root.add(calFour, 0, 4 );
        root.add(calFive, 1, 4 );
        root.add(calSix, 2, 4 );
        root.add(calMinus, 3, 4 );

        //Addinh the buttons for the fourth row

        root.add(calOne, 0, 5 );
        root.add(calTwo, 1, 5 );
        root.add(calThree, 2, 5 );
        root.add(calPlus, 3, 5 );

        //Adding buttons for the sixth row
        root.add(calNegate, 0, 6 );
        root.add(calZero, 1, 6 );
        root.add(calDot, 2, 6 );
        root.add(calEqual, 3, 6 );



        //setting up the scene and width

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(375);
        primaryStage.setHeight(500);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }

}
