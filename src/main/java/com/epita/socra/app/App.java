package com.epita.socra.app;

import com.epita.socra.app.tools.*;

import java.security.InvalidParameterException;

/**
 * Hello world!
 */
public final class App {


    private IOAdapter adapter;

    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    public void exec()
    {
        adapter.write("Input positive number :");
        String number = adapter.read();
        try {
            adapter.write(MorseConverter.toMorse(number));
        }
        catch (InvalidParameterException e)
        {
            adapter.write(e.getMessage());
        }
    }

    public void run(){
        while (true)
        {
            exec();
        }
    }
}
