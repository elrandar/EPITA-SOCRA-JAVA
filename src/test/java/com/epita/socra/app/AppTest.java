package com.epita.socra.app;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epita.socra.app.tools.IOAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void digit() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("3");
        App app = new App(mock);
        app.exec();

        verify(mock).write("Input positive number :");
        verify(mock).write(argThat(message -> message.equals("...__")));
    }

    @Test
    public void basicNumber() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("123");
        App app = new App(mock);
        app.exec();

        verify(mock).write("Input positive number :");
        verify(mock).write(argThat(message -> message.equals(".____..___...__")));
    }

    @Test
    public void negativeNumber()
    {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("-57");
        App app = new App(mock);
        app.exec();

        verify(mock).write("Input positive number :");
        verify(mock).write(argThat(message -> message.equals("number cannot be negative.")));
    }

    @Test
    public void notANumber()
    {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("bonjour ici");
        App app = new App(mock);
        app.exec();

        verify(mock).write("Input positive number :");
        verify(mock).write(argThat(message -> message.equals("input must be a valid positive number.")));
    }
}
