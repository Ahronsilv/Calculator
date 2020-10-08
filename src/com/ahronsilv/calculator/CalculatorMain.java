/*
    Copyright: Haim Aharon Zilberman (c)
    October 2020
    Haifa, Israel
*/
package com.ahronsilv.calculator;

import java.util.Scanner;

public class CalculatorMain {

    private static String GetInput()
    {
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }

    public static void main(String[] args)
    {
        System.out.print
                ("""
                    Добро пожаловать в калькулятор!
                    Калькулятор работает только с числами от 0 до 10 включительно.
                    Допускаются римские и арабские цифры.
                    Не допускается смешивание цифр из разных алфавитов.
                    Допустимые операции: +, -, *, /
                    Для выхода из программы введите слово 'exit' без кавычек.;
                """);
        CalculatorGetter calculatorGetter = new CalculatorGetter();
        while(true)
        {
            try
            {
                String inputString = GetInput();
                if(inputString.contains("exit"))
                {
                    break;
                }
                calculatorGetter.Parse(inputString);
                String result = CalculatorAction.GetResult(calculatorGetter);
                System.out.println(result);
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
