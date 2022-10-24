package dev.oxeg.intsorter.primer;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        new File("src/resource/Unsorted.txt").delete();
        new File("src/resource/Numbers.txt").delete();
        new File("src/resource/Letters.txt").delete();

        long before = System.currentTimeMillis();

        String symbols = "12344567890abcdefghijklmnopqrstuvwxyz1234567890";

        for (int j = 0; j < 5; j++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 200000; i++) {
                String symbol = String.valueOf(symbols.charAt((int) (Math.random() * symbols.length())));

                if ((int) (Math.random() * 2) == 1) symbol = symbol.toUpperCase();

                sb.append(symbol);
            }

            Thread thread = new Thread(new TextWriter("src/main/java/dev/oxeg/intsorter/primer/resource/Unsorted.txt",
                    sb.toString()));
            thread.start();
            thread.join();
        }

        TextReader textReader = new TextReader("src/dev/oxeg/intsorter/primer/resource/Unsorted.txt");
        textReader.run();

        String letters = textReader.getLetters();
        String numbers = textReader.getNumbers();

        Thread threadLetters = new Thread(new TextWriter("src/main/java/dev/oxeg/intsorter/primer/resource/Letters.txt",
                letters));
        threadLetters.start();
        threadLetters.join();
        Thread threadNumbers = new Thread(new TextWriter("src/main/java/dev/oxeg/intsorter/primer/resource/Numbers.txt",
                numbers));
        threadNumbers.start();
        threadNumbers.join();

        long after = System.currentTimeMillis();
        long dif = after - before;

        System.out.println("Количество букв: " + letters.length());
        System.out.println("Количество цифр: " + numbers.length());
        System.out.println("Выполнено за: " + dif + "мс.");
    }
}