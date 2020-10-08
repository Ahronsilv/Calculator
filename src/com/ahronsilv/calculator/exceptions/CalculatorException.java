/*
    Copyright: Haim Aharon Zilberman (c)
    October 2020
    Haifa, Israel
*/
package com.ahronsilv.calculator.exceptions;

public class CalculatorException extends RuntimeException {
    String message;

    public CalculatorException(String str){
        message = str;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
