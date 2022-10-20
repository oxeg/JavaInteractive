package dev.oxeg.fileseparator.oxeg;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static dev.oxeg.fileseparator.oxeg.OxegFileSeparator.DIRECTORY;

public class FileGenerator {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = UPPERCASE_LETTERS.toLowerCase();
    private static final String DIGITS = "0123456789";
    private static final String VALID_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS;

    private static final int BUFFER_SIZE = 1000;
    private static final Random RND = new Random();


    public static void main(String[] args) throws IOException {
        verifyArguments(args);
        var fileName = args[0];
        var fileLength = Long.parseLong(args[1]);

        var buffer = CharBuffer.allocate(BUFFER_SIZE);
        long symbolsWritten = 0;
        int symbolsToGenerate = fileLength - symbolsWritten > BUFFER_SIZE ? BUFFER_SIZE : (int) (fileLength - symbolsWritten);

        try (var fileWriter = new FileWriter(DIRECTORY + fileName, StandardCharsets.UTF_8)) {
            while (symbolsToGenerate > 0) {
                for (int i = 0; i < symbolsToGenerate; i++) {
                    var c = VALID_CHARACTERS.charAt(RND.nextInt(VALID_CHARACTERS.length()));
                    System.out.println("Writing: " + c);
                    buffer.put(c);
                }
                symbolsWritten += symbolsToGenerate;
                buffer.flip();
                fileWriter.append(buffer);
                fileWriter.flush();
                symbolsToGenerate = fileLength - symbolsWritten > BUFFER_SIZE ? BUFFER_SIZE : (int) (fileLength - symbolsWritten);
            }
        }
    }

    private static void verifyArguments(String[] args) {
        if (args.length < 2) {
            System.err.println("Arguments are expected: {file_name} {file size}");
            System.exit(1);
        }
        try {
            Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Wrong number format: " + e.getMessage());
            System.exit(1);
        }
    }
}
