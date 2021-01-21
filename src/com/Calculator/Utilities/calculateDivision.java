package com.Calculator.Utilities;

public class calculateDivision implements ICalculateOperations{
    @Override
    public double calculateOperation(String value) {
        String[] split = value.split("[/]");
        double num1 = Double.parseDouble(split[0]);
        double num2 = Double.parseDouble(split[1]);
        double cal = num1 / num2;

        return cal;
    }
}
