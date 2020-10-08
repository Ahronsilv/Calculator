/*
    Copyright: Haim Aharon Zilberman (c)
    October 2020
    Haifa, Israel
*/
package com.ahronsilv.calculator;

import com.ahronsilv.calculator.roman.RomanInteger;

public class CalculatorAction {
    private static CalculatorGetter _calculatorGetter;

    private static int PerformAction()
    {
        int result = 0;
        switch (_calculatorGetter.Operation())
        {
            case PLUS -> {
                result = _calculatorGetter.A() + _calculatorGetter.B();
                break;
            }
            case MINUS -> {
                result = _calculatorGetter.A() - _calculatorGetter.B();
                break;
            }
            case MULTIPLY -> {
                result = _calculatorGetter.A() * _calculatorGetter.B();
                break;
            }
            case DIVIDE -> {
                result = _calculatorGetter.A() / _calculatorGetter.B();
                break;
            }
        }
        return result;
    }

    public static String GetResult(CalculatorGetter calculatorGetter)
    {
        _calculatorGetter = calculatorGetter;
        int a = PerformAction();
        String result;
        if(calculatorGetter.IsRoman()) {
            result = RomanInteger.arabicToRoman(a);
        } else {
            result = String.valueOf(a);
        }
        return result;
    }
}
