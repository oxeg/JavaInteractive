package dev.oxeg.fileseparator.oxeg;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;

import static dev.oxeg.fileseparator.oxeg.OxegUtils.*;

public class OxegFileSeparator {
    public static void main(String[] args) throws IOException, InterruptedException {
        final var numbersQueue = new ArrayBlockingQueue<Character>(BUFFER_SIZE);
        final var numbersWriter = new Thread(new FileWriterThread(DIRECTORY + OUTPUT_FILENAME_NUMBERS, numbersQueue));
        numbersWriter.start();

        final var lettersQueue = new ArrayBlockingQueue<Character>(BUFFER_SIZE);
        final var lettersWriter = new Thread(new FileWriterThread(DIRECTORY + OUTPUT_FILENAME_LETTERS, lettersQueue));
        lettersWriter.start();

        try (var reader = new FileReader(DIRECTORY + INPUT_FILENAME, StandardCharsets.UTF_8)) {
            var buffer = CharBuffer.allocate(BUFFER_SIZE);
            var letterCounter = 0;
            var numberCounter = 0;
            while (reader.read(buffer) > 0) {
                for (char c : buffer.array()) {
                    if (Character.isDigit(c)) {
                        numberCounter++;
                        numbersQueue.put(c);
                    } else if (Character.isLetter(c)) {
                        letterCounter++;
                        lettersQueue.put(c);
                    } else {
                        System.err.println("Character not allowed here: " + c);
                        System.exit(1);
                    }
                }
                buffer.clear();
            }
            numbersWriter.interrupt();
            numbersWriter.join();
            lettersWriter.interrupt();
            lettersWriter.join();

            System.out.println("Total Letters: " + letterCounter);
            System.out.println("Total Numbers: " + numberCounter);
        }
    }

    private static class FileWriterThread implements Runnable {
        private final String fileName;
        private final ArrayBlockingQueue<Character> writeQueue;

        private FileWriterThread(String fileName, ArrayBlockingQueue<Character> writeQueue) {
            this.fileName = fileName;
            this.writeQueue = writeQueue;
        }

        @Override
        public void run() {
            try (var fileWriter = new FileWriter(fileName, StandardCharsets.UTF_8)) {
                var buffer = CharBuffer.allocate(BUFFER_SIZE);
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        while (buffer.remaining() > 0) {
                            buffer.put(writeQueue.take());
                        }
                        writeBufferToFile(fileWriter, buffer);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (!buffer.isEmpty()) {
                    writeBufferToFile(fileWriter, buffer);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
