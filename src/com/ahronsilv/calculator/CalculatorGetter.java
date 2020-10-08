/*
    Copyright: Haim Aharon Zilberman (c)
    October 2020
    Haifa, Israel
*/
package com.ahronsilv.calculator;

import com.ahronsilv.calculator.enums.EnumOperations;
import com.ahronsilv.calculator.exceptions.CalculatorException;
import com.ahronsilv.calculator.roman.RomanInteger;

public class CalculatorGetter {
    private int _a;
    private int _b;
    private EnumOperations _operation;
    private boolean _isRoman;

    public int A()
    {
        return _a;
    }

    public int B()
    {
        return _b;
    }

    public EnumOperations Operation()
    {
        return _operation;
    }

    public boolean IsRoman()
    {
        return _isRoman;
    }

    private int ConvertOperand(String operand)
    {
        int result = 0;
        if(RomanInteger.IsValidRoman(operand))
        {
            result = RomanInteger.romanToArabic(operand);
            _isRoman = true;
        } else
        {
            result = Integer.parseInt(operand);
        }
        return  result;
    }

    public void Parse(String str) {
        str = str.replaceAll("\\s+","");
        String operators[]=str.split("[0-9IVX]+");
        String operands[]=str.split("[+-/*]");

        if(operands.length != 2 || operators.length != 2)
        {
            throw new CalculatorException("Неверный формат вводной строки");
        }

        if(RomanInteger.IsValidRoman(operands[0]) != (RomanInteger.IsValidRoman(operands[1])))
        {
            throw new CalculatorException("Нельзя смешивать римские и арабские цифры!");
        }

        int a = ConvertOperand(operands[0]);
        int b = ConvertOperand(operands[1]);
        String op = operators[1];

        if (!(a >= 0 && a <= 10) || !(b >= 0 && b <= 10))
        {
            throw new CalculatorException("Введенные числа должны быть в промежутке от 0 до 10");
        }

        _a = a;
        _b = b;

        switch (op)
        {
            case "+":
                _operation = EnumOperations.PLUS;
                break;
            case "-":
                _operation = EnumOperations.MINUS;
                break;
            case "/":
                _operation = EnumOperations.DIVIDE;
                break;
            case "*":
                _operation = EnumOperations.MULTIPLY;
                break;
        }
    }
}
