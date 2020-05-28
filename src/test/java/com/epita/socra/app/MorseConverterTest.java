package com.epita.socra.app;

import com.epita.socra.app.tools.MorseConverter;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

/**
 * Unit test for MorseConverter.
 */
public class MorseConverterTest {
    @Test
    public void toMorseBasicNumber() {
        String number = "999";
        Assert.assertEquals(MorseConverter.toMorse(number), "____.____.____.");
    }

    @Test
    public void toMorseBasicNumber2()
    {
        String number = "765";
        Assert.assertEquals(MorseConverter.toMorse(number), "__..._.........");
    }

    @Test
    public void toMorseBiggerNumber()
    {
        String number = "123480";
        Assert.assertEquals(MorseConverter.toMorse(number), ".____..___...__....____.._____");
    }

    @Test
    public void toMorseEvenBiggerNumber()
    {
        String number = "1234809898767665645443432152615276879797328627364732648732684723687";
        Assert.assertEquals(MorseConverter.toMorse(number),".____..___...__....____.._________.___..____.___..__." +
            ".._....__..._...._........._........_........._...._...__...._...__..___.____.......____.....____.......__" +
            "___..._....___..__...____.__...____.__......__..______.._......_____......___........___......__..____.." +
            "......____..__......__..____....___......___.....___...___....___..__...");
    }

    @Test
    public void toMorseNegativeNumber()
    {
        String number = "-42";
        try
        {
            MorseConverter.toMorse(number);
            throw new AssertionError();
        }
        catch (InvalidParameterException e)
        {
            Assert.assertEquals(e.getMessage(), "number cannot be negative.");
        }
    }

    @Test
    public void toMorseNotANumber()
    {
        String number = "hello there";
        try
        {
            MorseConverter.toMorse(number);
            throw new AssertionError();
        }
        catch (InvalidParameterException e)
        {
            Assert.assertEquals(e.getMessage(), "input must be a valid positive number.");
        }
    }

    @Test
    public void toNumberBasicMorse() {
        String number = "____.____.____.";
        Assert.assertEquals(MorseConverter.toNumber(number), "999");
    }

    @Test
    public void toNumberBasicMorse2()
    {
        String number = "__..._.........";
        Assert.assertEquals(MorseConverter.toNumber(number), "765");
    }

    @Test
    public void toNumberBiggerMorse()
    {
        String number = ".____..___...__....____.._____";
        Assert.assertEquals(MorseConverter.toNumber(number), "123480");
    }

    @Test
    public void toNumberEvenBiggerMorse()
    {
        String number = ".____..___...__....____.._________.___..____.___..__." +
            ".._....__..._...._........._........_........._...._...__...._...__..___.____.......____.....____.......__" +
            "___..._....___..__...____.__...____.__......__..______.._......_____......___........___......__..____.." +
            "......____..__......__..____....___......___.....___...___....___..__...";
        Assert.assertEquals(MorseConverter.toNumber(number), "12348098987676656454434321526152768797973286273647" +
            "32648732684723687");
    }

    @Test
    public void toNumberMorseInvalid()
    {
        String number = "_.__.._._..._";
        try
        {
            MorseConverter.toNumber(number);
            throw new AssertionError();
        }
        catch (InvalidParameterException e)
        {
            Assert.assertEquals(e.getMessage(), "Morse string is not a digit or number");
        }
    }

    @Test
    public void toNumberMorseInvalid2()
    {
        String number = "hello there";
        try
        {
            MorseConverter.toNumber(number);
            throw new AssertionError();
        }
        catch (InvalidParameterException e)
        {
            Assert.assertEquals(e.getMessage(), "Morse string is not a digit or number");
        }
    }
}
