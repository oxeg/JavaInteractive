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

            new Thread(new TextWriter("src/resource/Unsorted.txt", sb.toString()))  .start();
        }

        TextReader textReader = new TextReader("src/resource/Unsorted.txt");
        textReader.run();

        String letters = textReader.getLetters();
        String numbers = textReader.getNumbers();

        new Thread(new TextWriter("src/resource/Letters.txt", letters)).start();
        new Thread(new TextWriter("src/resource/Numbers.txt", numbers)).start();

        long after = System.currentTimeMillis();
        long dif = after - before;

        System.out.println("Количество букв: " + letters.length());
        System.out.println("Количество цифр: " + numbers.length());
        System.out.println("Выполнено за: " + dif + "мс.");
    }
}