package dev.oxeg.fileseparator.oxeg;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;

public class OxegUtils {
    static final String DIRECTORY = "src/main/java/dev/oxeg/fileseparator/";
    static final String INPUT_FILENAME = "unsorted.txt";
    static final String OUTPUT_FILENAME_NUMBERS = "numbers.txt";
    static final String OUTPUT_FILENAME_LETTERS = "letters.txt";
    static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String LOWERCASE_LETTERS = UPPERCASE_LETTERS.toLowerCase();
    static final String DIGITS = "0123456789";
    static final String VALID_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS;

    static final int BUFFER_SIZE = 1000;
    static final Random RND = new Random();

    private OxegUtils() {
    }

    static void writeBufferToFile(FileWriter fileWriter, CharBuffer buffer) throws IOException {
        buffer.flip();
        fileWriter.append(buffer);
        fileWriter.flush();
    }
}
