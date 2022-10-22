package dev.oxeg.fileseparator.BerserkZak;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BerserkZakFileSeparator {

    public static void main(String[] args) throws IOException {
        RandomGenerator.generator();
        File fileDefault = new File("C:\\Generate\\Unsorted.txt");
        FileReader read = new FileReader(fileDefault, StandardCharsets.UTF_8);
        char[] buffer = new char[1000];
        read.read(buffer);
        StringBuilder numbers = new StringBuilder("Numbers: ");
        StringBuilder letters = new StringBuilder("Letters: ");
        for (int i = 0; i < buffer.length; i++) {
            if (Character.isDigit(buffer[i])) {
                numbers.append(buffer[i]);
            } else {
                letters.append(buffer[i]);
            }
        }
        File fLetters = new File("C:\\Generate\\Letters.txt");
        FileWriter wLetters = new FileWriter(fLetters, StandardCharsets.UTF_8);
        fileDefault.createNewFile();
        wLetters.write(String.valueOf(letters));
        wLetters.flush();
        wLetters.close();
        File fNumbers = new File("C:\\Generate\\Numbers.txt");
        FileWriter wNumbers = new FileWriter(fNumbers, StandardCharsets.UTF_8);
        fileDefault.createNewFile();
        wNumbers.write(String.valueOf(numbers));
        wNumbers.flush();
        wNumbers.close();
        String numbersCount = String.valueOf(numbers.length());
        String lettersCount = String.valueOf(letters.length());
        System.out.println("Total number of numbers in a string: " + numbersCount);
        System.out.println("Total number of letters in a string: " + lettersCount);
    }

}

