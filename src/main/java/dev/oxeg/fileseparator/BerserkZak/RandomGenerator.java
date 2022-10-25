package dev.oxeg.fileseparator.BerserkZak;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomGenerator {
    public static void generator() {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("C:\\Generate\\Unsorted.txt", StandardCharsets.UTF_8);
            String generation = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
            StringBuilder sStringGeneration = new StringBuilder();
            var genRandom = new Random();

            for (int n = 0; n <= 999; n++) {

                int index = genRandom.nextInt(generation.length());
                sStringGeneration.append(generation.charAt(index));
            }

            writer.printf(String.valueOf(sStringGeneration));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }
}
