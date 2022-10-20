package dev.oxeg.fileseparator.oxeg;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class OxegFileSeparator {
    private static final String DIRECTORY = "src/main/java/dev/oxeg/fileseparator/";
    private static final String INPUT_FILENAME = "unsorted.txt";
    private static final String OUTPUT_FILENAME_NUMBERS = "numbers.txt";
    private static final String OUTPUT_FILENAME_LETTERS = "letters.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new FileReader(DIRECTORY + INPUT_FILENAME, StandardCharsets.UTF_8);
             var numbersWriter = new FileWriter(DIRECTORY + OUTPUT_FILENAME_NUMBERS, StandardCharsets.UTF_8);
             var lettersWriter = new FileWriter(DIRECTORY + OUTPUT_FILENAME_LETTERS, StandardCharsets.UTF_8)) {
            var buffer = new char[1000];
            var letterCounter = 0;
            var numberCounter = 0;
            while (reader.read(buffer) > 0) {
                for (char c : buffer) {
                    if (Character.isDigit(c)) {
                        numberCounter++;
                        numbersWriter.append(c);
                    } else if (Character.isLetter(c)) {
                        letterCounter++;
                        lettersWriter.append(c);
                    } else {
                        System.err.println("Character not allowed here: " + c);
                        System.exit(1);
                    }
                }
                numbersWriter.flush();
                lettersWriter.flush();
            }
            System.out.println("Total Letters: " + letterCounter);
            System.out.println("Total Numbers: " + numberCounter);
        }
    }
}
