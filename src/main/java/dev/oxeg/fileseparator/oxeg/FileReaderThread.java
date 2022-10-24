package dev.oxeg.fileseparator.oxeg;

import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;

import static dev.oxeg.fileseparator.oxeg.OxegUtils.BUFFER_SIZE;

record FileReaderThread(
        String fileName,
        ArrayBlockingQueue<Character> numbersQueue,
        ArrayBlockingQueue<Character> lettersQueue) implements Runnable {

    @Override
    public void run() {
        try (var reader = new FileReader(fileName, StandardCharsets.UTF_8)) {
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

            System.out.println("Total Letters: " + letterCounter);
            System.out.println("Total Numbers: " + numberCounter);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
