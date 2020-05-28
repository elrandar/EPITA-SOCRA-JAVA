package com.epita.socra.app;

import com.epita.socra.app.tools.MorseConverter;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

/**
 * Unit test for MorseConverter.
 */
public class MorseConverterTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void basicNumber() {
        String number = "999";
        Assert.assertEquals(MorseConverter.toMorse(number), "____.____.____.");
    }

    @Test
    public void basicNumber2()
    {
        String number = "765";
        Assert.assertEquals(MorseConverter.toMorse(number), "__..._.........");
    }

    @Test
    public void biggerNumber()
    {
        String number = "123480";
        Assert.assertEquals(MorseConverter.toMorse(number), ".____..___...__....____.._____");
    }

    @Test
    public void negativeNumber()
    {
        String number = "-42";
        try
        {
            String converted = MorseConverter.toMorse(number);
            throw new AssertionError();
        }
        catch (InvalidParameterException e)
        {
            Assert.assertEquals(e.getMessage(), "number cannot be negative.");
        }
    }

    @Test
    public void notANumber()
    {

        String number = "hello there";
        try
        {
            String converted = MorseConverter.toMorse(number);
            throw new AssertionError();
        }
        catch (InvalidParameterException e)
        {
            Assert.assertEquals(e.getMessage(), "input must be a valid positive number.");
        }
    }
}
