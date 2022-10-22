package dev.oxeg.fileseparator.BerserkZak;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class RandomGenerator {
public static void generator() {

        try {
            PrintWriter writer = new PrintWriter("C:\\Generate\\Unsorted.txt", StandardCharsets.UTF_8);

            String generation = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
            StringBuilder sStringGeneration = new StringBuilder();
            for (int n = 0; n <= 999; n++) {
                int index = (int)(generation.length() * Math.random());
                sStringGeneration.append(generation.charAt(index));
            }
            writer.printf(String.valueOf(sStringGeneration));
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

}
}
