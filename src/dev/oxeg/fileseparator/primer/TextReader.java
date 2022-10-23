package dev.oxeg.intsorter.primer;

import java.io.FileReader;
import java.io.IOException;

public class TextReader implements Runnable {

    private final String path;
    private final StringBuilder letters = new StringBuilder();
    private final StringBuilder numbers = new StringBuilder();

    public TextReader(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                String symbol = String.valueOf((char) c);

                try {
                    int num = Integer.parseInt(symbol);

                    numbers.append(num);
                } catch (NumberFormatException e) {
                    letters.append(symbol);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getLetters() {
        return letters.toString();
    }

    public String getNumbers() {
        return numbers.toString();
    }
}
