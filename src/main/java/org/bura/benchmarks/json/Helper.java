package org.bura.benchmarks.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Helper {

    public static String getResource(String name) {
        try (InputStream stream = Helper.class.getClassLoader().getResourceAsStream(name)) {
            try (Scanner scanner = new Scanner(stream)) {
                String text = scanner.useDelimiter("\\A").next();

                return text;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error on resorce loading: " + name);
        }
    }

    private Helper() {
    }

}
