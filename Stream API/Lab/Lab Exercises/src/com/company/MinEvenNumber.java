package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine()
                .split(" "))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        if (words.length == 0) {
            System.out.println("No match");
            return;
        }

        double[] evenNums = Arrays.stream(words)
                .mapToDouble(x -> Double.parseDouble(x))
                .filter(x -> x % 2 == 0)
                .toArray();

        Arrays.sort(evenNums);
        double minEvenDouble = evenNums[0];
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(minEvenDouble));
    }
}
