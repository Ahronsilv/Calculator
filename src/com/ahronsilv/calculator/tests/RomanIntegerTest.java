/*
    Я не буду в юнит-тестах разбирать все случаи
    Просто хотел показать, что я умею их делать
*/
package com.ahronsilv.calculator.tests;

import com.ahronsilv.calculator.roman.RomanInteger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RomanIntegerTest {

    @Test
    void isValidRoman() {
        String roman = "IX";
        boolean result = RomanInteger.IsValidRoman(roman);
        Assert.assertTrue(result);
    }

    @Test
    void isNotValidRoman() {
        String roman = "431d";
        boolean result = RomanInteger.IsValidRoman(roman);
        Assert.assertFalse(result);
    }

    @Test
    public void romanToArabicValid() {
        String roman = "VIII";
        int result = RomanInteger.romanToArabic(roman);
        Assert.assertEquals(result, 8);
    }

    @Test
    public void romanToArabicInValid() {
        String roman = "jkds";
        Assert.assertThrows(IllegalArgumentException.class, () -> {RomanInteger.romanToArabic(roman);});
    }

    @Test
    void arabicToRomanValid() {
        int arabic = 231;
        String result = RomanInteger.arabicToRoman(arabic);
        Assert.assertTrue(result.contains("CCXXXI"));
    }
    @Test
    public void arabicToRomanInValid() {
        int arabic = 3241123;
        Assert.assertThrows(IllegalArgumentException.class, () -> {RomanInteger.arabicToRoman(arabic);});
    }
}
