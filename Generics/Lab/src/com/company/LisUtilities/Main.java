package com.company.LisUtilities;

import com.company.LisUtilities.Models.ListUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 1, 2, 3, 4);

        Integer max = ListUtils.getMax(nums);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minString = ListUtils.getMin(strings);

        System.out.println(max);
        System.out.println(minString);
    }
}
