package com.Calculator;

import com.Calculator.Controllers.Controllers;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    Controllers c = new Controllers();

    public void start(Stage primaryStage) throws Exception{

        FXMLLoader  loader = new FXMLLoader(getClass().getResource("Resources/calculatorApp.fxml"));
        Parent root = loader.load();

        root.getStylesheets().add("com/Calculator/stylesheets/main.css");

        Controllers c =loader.getController();
        TextField calInput = c.getCalInput();

        calInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(!t1.matches("[0-9-/*+().]*")){
                    calInput.setText(s);
                }
            }
        });

        ScrollPane p = c.getHistoryScrollPane();
        GridPane g = c.getHistoryPane();
        p.setContent(g);

        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image("com/Calculator/Assets/calculator.png"));
        Scene s = new Scene(root);
        primaryStage.setScene(s);
        primaryStage.show();


    }

//    public void increaseFont(Parent root){
//        root.setStyle("-fx-font-size: 1000;");
//
//    }

    public static void main(String[] args){
        Application.launch(args);
    }
    
}
