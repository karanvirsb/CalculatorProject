package com.Calculator.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class calculation {

    public static String calculate(String expression){

        ICalculateOperations multiplication = new calculateMultiplication();
        ICalculateOperations subtraction = new calculateSubtraction();
        ICalculateOperations addition = new calculateAddition();
        ICalculateOperations division = new calculateDivision();

        boolean finished = false;
        double num1 = 0, num2 = 0, cal = 0;
        String finalCal = expression;

        String regMulti = "\\d+\\.?\\d*[*]\\d+\\.?\\d*";
        String regSub = "\\d+\\.?\\d*[-]\\d+\\.?\\d*";
        String regDiv = "\\d+\\.?\\d*[/]\\d+\\.?\\d*";
        String regAdd = "\\d+\\.?\\d*[+]\\d+\\.?\\d*";
        String regBrackets = "\\(([^)]+)\\)";

        Pattern multi = Pattern.compile(regMulti);
        Pattern add = Pattern.compile(regAdd);
        Pattern sub = Pattern.compile(regSub);
        Pattern div = Pattern.compile(regDiv);
        Pattern brackets = Pattern.compile(regBrackets);


        while(!finished)
        {
            Matcher bracketMatch = brackets.matcher(finalCal);
            Matcher multiMatch = multi.matcher(finalCal);
            Matcher divMatch = div.matcher(finalCal);
            Matcher addMatch = add.matcher(finalCal);
            Matcher subMatch = sub.matcher(finalCal);

            if(bracketMatch.find()){
                String tmp = bracketMatch.group();
                tmp = tmp.replace("(", "");
                tmp = tmp.replace(")", "");

                if(tmp.contains("*"))
                {
                    finalCal =  finalCal.replace(bracketMatch.group(), String.valueOf(multiplication.calculateOperation(tmp)));
                }
                else if(tmp.contains("/")){
                    finalCal =  finalCal.replace(bracketMatch.toString(), String.valueOf(division.calculateOperation(tmp)));
                }
                else if(tmp.contains("+")){
                    finalCal =  finalCal.replace(bracketMatch.toString(), String.valueOf(addition.calculateOperation(tmp)));
                }
                else if(tmp.contains("-")){
                    finalCal =  finalCal.replace(bracketMatch.toString(), String.valueOf(subtraction.calculateOperation(tmp)));
                }
                else{
                    return "Error";
                }

            }
           else if(multiMatch.find())
            {
                finalCal =  finalCal.replaceAll(regMulti, String.valueOf(multiplication.calculateOperation(multiMatch.group())));
            }
            else if(divMatch.find())
            {
                finalCal =  finalCal.replaceAll(regDiv, String.valueOf(division.calculateOperation(divMatch.group())));
            }
            else if(addMatch.find()){

                finalCal =  finalCal.replaceAll(regAdd, String.valueOf(addition.calculateOperation(addMatch.group())));
            }
            else if(subMatch.find())
            {

                finalCal =  finalCal.replaceAll(regSub, String.valueOf(subtraction.calculateOperation(subMatch.group())));
            }
            else{
                finished = true;
            }
        }

        return finalCal;
    }

}
