package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class FirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        HashSet<Character> letters = new HashSet<Character>(
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(x -> x.charAt(0))
                        .collect(Collectors.toSet()));

        List<String> result = new ArrayList<>();

        Arrays.stream(words)
                .forEach(word -> {
                    letters.forEach(letter -> {
                        if (word.toLowerCase().charAt(0) == letter) {
                            result.add(word);
                        }
                    });
                });

        Collections.sort(result);
        if (result.size() == 0) {
            System.out.println("No match");
        } else {
            Optional<String> firstMatchingResult = result.stream().findFirst();
            System.out.println(firstMatchingResult.get());
        }
    }
}
