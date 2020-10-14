package com.company.GenericArrayCreator;

import com.company.GenericArrayCreator.Models.ArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);

        Arrays.stream(strings).forEach(x -> System.out.println(x));
        Arrays.stream(integers).forEach(x -> System.out.println(x));
    }
}
