package com.calculator.calculate;

import com.calculator.exception.IncorrectOperation;

public interface Calculate {

    int calculate(int firstNumber, int secondNumber, String operationType) throws IncorrectOperation;
}
