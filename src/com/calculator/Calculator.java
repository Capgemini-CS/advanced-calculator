package com.calculator;

import com.calculator.calculate.Calculate;
import com.calculator.exception.IncorrectOperation;
import com.calculator.input.Keyboard;
import com.calculator.operation.Action;
import com.calculator.operations.Operation;
import com.calculator.output.Screen;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Calculator implements Keyboard, Operation, Calculate, Screen {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IncorrectOperation {

        System.out.println("Please input two numbers and then select one mathematical operator:" +
                "\nADDITION\nSUBTRACTION\nMULTIPLICATION\nDIVISION");

        Calculator calculator1 = new Calculator();

        calculator1.screen();

    }

    @Override
    public int inputNumber() {
        return scanner.nextInt();
    }

    @Override
    public String inputOperationType() throws IncorrectOperation {
        String operationType = scanner.next();
        return validateInput(operationType);
    }

    @Override
    public String validateInput(String operationType) throws IncorrectOperation {
        if (!List.of("ADDITION", "DIVISION", "MULTIPLICATION", "SUBTRACTION").contains(operationType)) {
            throw new IncorrectOperation("Please select correct mathematical operator symbol!");
        }
        return operationType;
    }

    @Override
    public int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public int substraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public int division(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public int calculate(int firstNumber, int secondNumber, String operationType) throws IncorrectOperation {
        Action action = Action.valueOf(operationType);
        int result = 0;
        switch (action) {
            case ADDITION:
                result = addition(firstNumber, secondNumber);
                break;
            case SUBTRACTION:
                result = substraction(firstNumber, secondNumber);
                break;
            case MULTIPLICATION:
                result = multiplication(firstNumber, secondNumber);
                break;
            case DIVISION:
                if (secondNumber == 0) {
                    throw new IncorrectOperation("You can't divide by 0!");
                }
                result = division(firstNumber, secondNumber);
                break;
        }
        return result;
    }

    @Override
    public void screen() throws IncorrectOperation {
        System.out.println(calculate(inputNumber(), inputNumber(), inputOperationType()));
    }
}
