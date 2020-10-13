package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class TakeTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        Arrays.stream(nums)
                .filter(n -> n >= 10 && n <= 20)
                .distinct()
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
