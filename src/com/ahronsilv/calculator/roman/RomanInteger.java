package com.ahronsilv.calculator.roman;

import com.ahronsilv.calculator.enums.EnumRomanNumeral;

import java.util.List;

public class RomanInteger {

    // Для проверки римского числа на валидность беру только от I до X, так как выше X все равно нельзя вводить согласно ТЗ
    public static boolean IsValidRoman(String str)
    {
        return str.matches("^(X{0,3})(IX|IV|V?I{0,3})$");
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<EnumRomanNumeral> enumRomanNumerals = EnumRomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < enumRomanNumerals.size())) {
            EnumRomanNumeral symbol = enumRomanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " нельзя перевести в арабские цифры");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " число должно быть в промежутке от 0 до 4000");
        }

        List<EnumRomanNumeral> enumRomanNumerals = EnumRomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < enumRomanNumerals.size())) {
            EnumRomanNumeral currentSymbol = enumRomanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

}
