package com.calculator.input;

import com.calculator.exception.IncorrectOperation;

public interface ValidateInput {

    String validateInput(String operationType) throws IncorrectOperation;
}
