package com.epita.socra.app.tools;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class MorseConverter {

    private final static String[] digitToMorseMap = new String[]{
        "_____",
        ".____",
        "..___",
        "...__",
        "...._",
        ".....",
        "_....",
        "__...",
        "___..",
        "____."
    };

    private final static HashMap morseToDigitMap = new HashMap<String, String>() {
        {
            put("_____", "0");
            put(".____", "1");
            put("..___", "2");
            put("...__", "3");
            put("...._", "4");
            put(".....", "5");
            put("_....", "6");
            put("__...", "7");
            put("___..", "8");
            put("____.", "9");
        }
    };

    /* Method to decide in which way the conversion has to take place
     *
     */
    public static String convert(String input)
    {
        if (input.charAt(0) == '_' || input.charAt(0) == '.')
        {
            return toNumber(input);
        }
        return toMorse(input);
    }

    /**
     * Method that converts a string representing a number to its Morse equivalent
     *
     */
    public static String toMorse(String stringNumber) {
        if (stringNumber.charAt(0) == '-')
        {
           throw new InvalidParameterException("number cannot be negative.");
        }
        StringBuilder sb = new StringBuilder();
        for (char c:
             stringNumber.toCharArray()) {
            if (c < '0' || c > '9')
            {
                throw new InvalidParameterException("input must be a valid positive number.");
            }
            int digit = Character.getNumericValue(c);
            sb.append(digitToMorseMap[digit]);
        }
        return sb.toString();
    }

    public static String toNumber(String morseNumber) {
        int i = 0;

        StringBuilder sb = new StringBuilder();
        while (i < morseNumber.length())
        {
            String morseDigit;
            try {
                morseDigit = morseNumber.substring(i, i + 5);
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidParameterException("Morse string is not a digit or number");
            }
            if (morseToDigitMap.containsKey(morseDigit))
            {
                sb.append(morseToDigitMap.get(morseDigit));
            }
            else
            {
                throw new InvalidParameterException("Morse string is not a digit or number");
            }
            i += 5;
        }
        return sb.toString();
    }
}
