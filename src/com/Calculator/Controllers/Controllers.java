package com.Calculator.Controllers;

import com.Calculator.Utilities.calculation;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Controllers{

    @FXML
    Label calFinal;

    @FXML
    TextField calInput;

    @FXML
    VBox historyVBox;

    @FXML
    ScrollPane historyScrollPane;

    String previous = "";
    String ans = "";
    static int i = 0;

    public void insertNumber(String number){
        calInput.setText(calInput.getText() + number);
    }

    public void insertOperator(String operator){
        calInput.setText(calInput.getText() + operator);
    }

    public void backspace(){
        if(!calInput.getText().isEmpty()) {
            StringBuilder sb = new StringBuilder(calInput.getText());
            sb.deleteCharAt(calInput.getLength() - 1);
            calInput.setText(sb.toString());
        }
    }


    public void clear(){
        calInput.setText("");
        calFinal.setText("");
    }

    public void calculate(){
        if(!calInput.getText().isEmpty()) {
            previous = calInput.getText();
            String finalCal = calculation.calculate(calInput.getText());
            calFinal.setText(finalCal);
            ans = finalCal;
            history(previous, ans);
        }
    }

    public void history(String previous, String ans){
        calInput.setText("");
        Button prevSolution = new Button();
        prevSolution.setPrefSize(200, 100);
        prevSolution.setAlignment(Pos.TOP_LEFT);
        prevSolution.setText(previous + "\n = " + ans);
        historyVBox.getChildren().add(prevSolution);
    }

    public void mouseClicked(MouseEvent mouseEvent) {

        Button source = (Button) mouseEvent.getSource();

        String buttonText = source.getText();

            switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "/":
            case "*":
            case ".":
            case "(":
            case ")":
                insertOperator(buttonText);
                break;
            case "=":
                calculate();
                break;
            case "C":
                clear();
                break;
            case "<-":
                backspace();
                break;




        }

    }

    public TextField getCalInput() {
        return calInput;
    }

    public ScrollPane getHistoryScrollPane() {
        return historyScrollPane;
    }

    public VBox getHistoryPane() {
        return historyVBox;
    }

    public void keyTyped(KeyEvent keyEvent) {
        StringBuilder sb = new StringBuilder(keyEvent.getCharacter());
        if(sb.toString().equals("=")){
            calculate();
        }
    }
}
