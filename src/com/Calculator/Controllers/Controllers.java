package com.Calculator.Controllers;

import com.Calculator.Utilities.calculation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Controllers{

    @FXML
    Label calFinal;

    @FXML
    TextField calInput;

    @FXML
    GridPane historyPane;

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
        previous = calInput.getText();
        String finalCal = calculation.calculate(calInput.getText());
        calFinal.setText(finalCal);
        ans = finalCal;
        history(previous, ans);
    }

    public void history(String previous, String ans){
        Button prevSolution = new Button();
        prevSolution.setStyle("-fx-font-size: 25px");
        prevSolution.setText(previous + "=" + ans);
        historyPane.setVgap(10);
        GridPane.getVgrow(prevSolution);
        historyPane.add(prevSolution, 0, i);
        i++;
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

    public GridPane getHistoryPane() {
        return historyPane;
    }

    public void keyTyped(KeyEvent keyEvent) {
        StringBuilder sb = new StringBuilder(keyEvent.getCharacter());
        if(sb.toString().equals("=")){
            calculate();
        }
    }
}