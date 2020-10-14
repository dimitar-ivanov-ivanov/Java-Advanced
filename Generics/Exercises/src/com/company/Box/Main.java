package com.company.Box;

import com.company.Box.Models.Box;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        solve();
    }

    private static <T extends Comparable<T>> void solve() {
        Scanner scanner = new Scanner(System.in);

        List<Box<T>> boxes = getBoxes(scanner);
        //swapElementsInTheBox(scanner, boxes);
        //printBoxes(boxes);
        getValueOfBoxGreaterThanAllBoxes(scanner, boxes);
    }

    private static <T extends Comparable<T>> void getValueOfBoxGreaterThanAllBoxes(Scanner scanner, List<Box<T>> boxes) {
        T value = (T) scanner.nextLine();
        int countOfGreaterElements = Box.getCountOfElementsGreaterThan(boxes, value);
        System.out.println(countOfGreaterElements);
    }

    public static <T> void printBoxes(List<Box<T>> boxes) {
        boxes.stream().forEach(box -> System.out.println(box));
    }

    private static <T> void swapElementsInTheBox(Scanner scanner, List<Box<T>> boxes) {
        int firstPositionToSwap = scanner.nextInt();
        int secondPositionToSwap = scanner.nextInt();
        Box.swap(boxes, firstPositionToSwap, secondPositionToSwap);
    }

    private static <T> List<Box<T>> getBoxes(Scanner scanner) {
        List<Box<T>> boxes = new ArrayList<>();
        int countOfValues = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfValues; i++) {
            Box<T> box = new Box(scanner.nextLine());
            boxes.add(box);
        }

        return boxes;
    }

    private static List<Box<String>> getBoxesOfStrings(Scanner scanner) {
        List<Box<String>> boxes = new ArrayList<>();
        int countOfValues = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfValues; i++) {
            Box<String> box = new Box(scanner.nextLine());
            boxes.add(box);
        }

        return boxes;
    }

    private static List<Box<Integer>> getBoxesOfIntegers(Scanner scanner) {
        List<Box<Integer>> boxes = new ArrayList<>();
        int countOfValues = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfValues; i++) {
            Box<Integer> box = new Box(Integer.parseInt(scanner.nextLine()));
            boxes.add(box);
        }
        return boxes;
    }
}