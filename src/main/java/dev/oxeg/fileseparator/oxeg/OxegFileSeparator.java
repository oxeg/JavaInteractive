package dev.oxeg.fileseparator.oxeg;

import java.util.concurrent.ArrayBlockingQueue;

import static dev.oxeg.fileseparator.oxeg.OxegUtils.*;

public class OxegFileSeparator {
    public static void main(String[] args) throws InterruptedException {
        final var numbersQueue = new ArrayBlockingQueue<Character>(BUFFER_SIZE);
        final var numbersWriter = new Thread(new FileWriterThread(DIRECTORY + OUTPUT_FILENAME_NUMBERS, numbersQueue));
        numbersWriter.start();

        final var lettersQueue = new ArrayBlockingQueue<Character>(BUFFER_SIZE);
        final var lettersWriter = new Thread(new FileWriterThread(DIRECTORY + OUTPUT_FILENAME_LETTERS, lettersQueue));
        lettersWriter.start();

        var readerThread = new Thread(new FileReaderThread(DIRECTORY + INPUT_FILENAME, numbersQueue, lettersQueue));
        readerThread.start();
        readerThread.join();

        numbersWriter.interrupt();
        numbersWriter.join();
        lettersWriter.interrupt();
        lettersWriter.join();
    }

}
