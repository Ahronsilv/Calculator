/*
    Я не буду в юнит-тестах разбирать все случаи
    Просто хотел показать, что я умею их делать
*/

package com.ahronsilv.calculator.tests;

import com.ahronsilv.calculator.CalculatorAction;
import com.ahronsilv.calculator.CalculatorGetter;
import com.ahronsilv.calculator.enums.EnumOperations;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

class CalculatorGetterTest {

    @Test
    void parseValidArabic() {
        CalculatorGetter calculatorGetter = new CalculatorGetter();
        calculatorGetter.Parse("5+7");
        String result = CalculatorAction.GetResult(calculatorGetter);
        Assert.assertEquals(calculatorGetter.A(), 5);
        Assert.assertEquals(calculatorGetter.B(), 7);
        Assert.assertEquals(calculatorGetter.Operation(), EnumOperations.PLUS);
        Assert.assertFalse(calculatorGetter.IsRoman());
        Assert.assertTrue(result.contains("12"));
    }

    @Test
    void parseValidRoman() {
        CalculatorGetter calculatorGetter = new CalculatorGetter();
        calculatorGetter.Parse("X+V");
        String result = CalculatorAction.GetResult(calculatorGetter);
        Assert.assertEquals(calculatorGetter.A(), 10);
        Assert.assertEquals(calculatorGetter.B(), 5);
        Assert.assertEquals(calculatorGetter.Operation(), EnumOperations.PLUS);
        Assert.assertTrue(calculatorGetter.IsRoman());
        Assert.assertTrue(result.contains("XV"));
    }
}