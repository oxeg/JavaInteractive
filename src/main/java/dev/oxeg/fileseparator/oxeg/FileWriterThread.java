package dev.oxeg.fileseparator.oxeg;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;

import static dev.oxeg.fileseparator.oxeg.OxegUtils.BUFFER_SIZE;
import static dev.oxeg.fileseparator.oxeg.OxegUtils.writeBufferToFile;

record FileWriterThread(
        String fileName,
        ArrayBlockingQueue<Character> writeQueue) implements Runnable {
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
