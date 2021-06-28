package com.leetcode.solutions;

/**
 * Function to convert Number to Roman limit
 *  0 < n <= 3999
 */
public class NumberToRoman {
    //Note: The order of Roman Numberals is high to low so we can fint
    private Numeral[] numerals = {
            new Numeral("M", 1000),
            new Numeral("CM", 900),
            new Numeral("D", 500),
            new Numeral("CD", 400),
            new Numeral("C", 100),
            new Numeral("XC", 90),
            new Numeral("L", 50),
            new Numeral("XL", 40),
            new Numeral("X", 10),
            new Numeral("IX", 9),
            new Numeral("V", 5),
            new Numeral("IV", 4),
            new Numeral("I", 1),
    };

    public String intToRoman(int num) {
        String result = "";

        for(Numeral numeral : numerals){
            int numberOfSymbols = num / numeral.value; //Quotient
            if(numberOfSymbols != 0) {
                result += numeral.symbol.repeat(numberOfSymbols);
            }
            num %= numeral.value; //Reminder  is left out number
        }
        return result;
    }
}
class Numeral {
    public String symbol;
    public int value;

    public Numeral(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }
}
