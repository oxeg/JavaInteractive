package dev.oxeg.fileseparator.oxeg;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

import static dev.oxeg.fileseparator.oxeg.OxegUtils.*;

public class OxegFileGenerator {
    public static void main(String[] args) throws IOException {
        verifyArguments(args);
        var fileLength = Long.parseLong(args[0]);

        var buffer = CharBuffer.allocate(BUFFER_SIZE);
        long symbolsWritten = 0;
        int symbolsToGenerate = fileLength - symbolsWritten > BUFFER_SIZE ? BUFFER_SIZE : (int) (fileLength - symbolsWritten);

        try (var fileWriter = new FileWriter(DIRECTORY + INPUT_FILENAME, StandardCharsets.UTF_8)) {
            while (symbolsToGenerate > 0) {
                for (int i = 0; i < symbolsToGenerate; i++) {
                    var c = VALID_CHARACTERS.charAt(RND.nextInt(VALID_CHARACTERS.length()));
                    buffer.put(c);
                }
                symbolsWritten += symbolsToGenerate;
                writeBufferToFile(fileWriter, buffer);
                symbolsToGenerate = fileLength - symbolsWritten > BUFFER_SIZE ? BUFFER_SIZE : (int) (fileLength - symbolsWritten);
            }
        }
    }

    private static void verifyArguments(String[] args) {
        if (args.length < 1) {
            System.err.println("Argument is expected: file_size (number)");
            System.exit(1);
        }
        try {
            Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Wrong number format: " + e.getMessage());
            System.exit(1);
        }
    }
}
