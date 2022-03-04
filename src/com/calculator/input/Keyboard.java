package com.calculator.input;

import com.calculator.exception.IncorrectOperation;

public interface Keyboard extends ValidateInput{

    int inputNumber() ;
    String inputOperationType() throws IncorrectOperation;
}
