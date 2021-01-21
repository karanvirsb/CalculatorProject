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
                    String[] split = tmp.split("[/]");
                    num1 = Double.parseDouble(split[0]);
                    num2 = Double.parseDouble(split[1]);
                    cal = num1 / num2;
                    finalCal =  finalCal.replace(bracketMatch.toString(), String.valueOf(cal));
                }
                else if(tmp.contains("+")){
                    String[] split = tmp.split("[+]");
                    num1 = Double.parseDouble(split[0]);
                    num2 = Double.parseDouble(split[1]);
                    cal = num1 + num2;
                    finalCal =  finalCal.replace(bracketMatch.toString(), String.valueOf(cal));
                }
                else if(tmp.contains("-")){
                    String[] split = tmp.split("[-]");
                    num1 = Double.parseDouble(split[0]);
                    num2 = Double.parseDouble(split[1]);
                    cal = num1 + num2;
                    finalCal =  finalCal.replace(bracketMatch.toString(), String.valueOf(cal));
                }
                else{
                    return "Error";
                }

            }
           else if(multiMatch.find())
            {
                String tmp = multiMatch.group();
                String[] split = tmp.split("[*]");
                num1 = Double.parseDouble(split[0]);
                num2 = Double.parseDouble(split[1]);
                cal = num1 * num2;
                finalCal =  finalCal.replaceAll(regMulti, String.valueOf(cal));
            }
            else if(divMatch.find())
            {
                String tmp = divMatch.group();
                String[] split = tmp.split("[/]");
                num1 = Double.parseDouble(split[0]);
                num2 = Double.parseDouble(split[1]);
                cal = num1 / num2;
                finalCal =  finalCal.replaceAll(regDiv, String.valueOf(cal));
            }
            else if(addMatch.find()){
                String tmp = addMatch.group();
                String[] split = tmp.split("[+]");
                num1 = Double.parseDouble(split[0]);
                num2 = Double.parseDouble(split[1]);
                cal = num1 + num2;
                finalCal =  finalCal.replaceAll(regAdd, String.valueOf(cal));
            }
            else if(subMatch.find())
            {
                String tmp = subMatch.group();
                String[] split = tmp.split("[-]");
                num1 = Double.parseDouble(split[0]);
                num2 = Double.parseDouble(split[1]);
                cal = num1 + num2;
                finalCal =  finalCal.replaceAll(regSub, String.valueOf(cal));
            }
            else{
                finished = true;
            }
        }

        return finalCal;
    }

}
