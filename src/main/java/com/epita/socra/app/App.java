package com.epita.socra.app;

import com.epita.socra.app.tools.*;

import java.util.ArrayList;
import java.util.Map;

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

    /**
     *
     */
    private String toMorse(String number) {

    }


    public void run(){
        adapter.write("Input positive number :");
        String number = adapter.read();
        adapter.write(toMorse(number));
    }
}
