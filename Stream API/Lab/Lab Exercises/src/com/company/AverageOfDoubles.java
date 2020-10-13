package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class AverageOfDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OptionalDouble average = Arrays.stream(Arrays.stream(scanner.nextLine()
                .split(" "))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new))
                .mapToDouble(e -> Double.parseDouble(e))
                .average();

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(average.getAsDouble()));
    }
}
