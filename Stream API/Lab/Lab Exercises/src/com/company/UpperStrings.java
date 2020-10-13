package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class UpperStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Arrays.stream(words)
                .map(s -> s.toUpperCase())
                .forEach(x -> System.out.print(x + " "));
    }
}
