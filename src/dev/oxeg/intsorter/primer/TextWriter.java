package dev.oxeg.intsorter.primer;

import java.io.FileWriter;
import java.io.IOException;

public class TextWriter implements Runnable{
    private final String path;
    private final String text;

    public TextWriter(String path, String text) {
        this.path = path;
        this.text = text;
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
