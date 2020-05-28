package com.epita.socra.app.tools;

import java.security.InvalidParameterException;

public class MorseConverter {

    private final static String[] morseMap = new String[]{
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


    /**
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
            sb.append(morseMap[digit]);
        }
        return sb.toString();
    }
}
