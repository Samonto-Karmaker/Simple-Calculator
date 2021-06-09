package com.example.simplecalculator;

public class Calculator_Utility implements Util_Interface {

    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    UI_Interface output;

    public Calculator_Utility(UI_Interface out){
        output = out;
    }


    @Override
    public void process(double num1, double num2, int operation_id){
        if(operation_id == ADDITION){
            output.print(add(num1, num2));
        }
        else if(operation_id == SUBTRACTION){
            output.print(sub(num1, num2));
        }
        else if(operation_id == MULTIPLICATION){
            output.print(multiply(num1, num2));
        }
        else if(operation_id == DIVISION){
            output.print(divide(num1, num2));
        }
    }


    private String add(double num1, double num2){
        return String.valueOf((num1 + num2));
    }

    private String sub(double num1, double num2){
        return String.valueOf((num1 - num2));
    }

    private String multiply(double num1, double num2){
        return String.valueOf((num1 * num2));
    }

    private String divide(double num1, double num2){
        try{
            return String.valueOf((num1 / num2));
        }
        catch (ArithmeticException a){
            return "You can not divide a number by zero";
        }
    }
}
