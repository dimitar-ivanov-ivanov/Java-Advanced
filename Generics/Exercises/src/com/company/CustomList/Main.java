package com.company.CustomList;

import com.company.CustomList.Models.MyList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String[] args = scanner.nextLine().split(" ");
        String command = args[0];

        MyList<String> elements = new MyList<>();
        String element = "";
        int index = -1;

        while (!command.equals("END")) {
            switch (command) {
                case "Add":
                    element = args[1];
                    addElementToList(elements, element);
                    break;
                case "Remove":
                    index = Integer.parseInt(args[1]);
                    removeElementFromList(elements, index);
                    break;
                case "Contains":
                    element = args[1];
                    findIfListContainsElement(elements, element);
                    break;
                case "Swap":
                    index = Integer.parseInt(args[1]);
                    int index2 = Integer.parseInt(args[2]);
                    swapElementsInList(elements, index, index2);
                    break;
                case "Greater":
                    element = args[1];
                    findElementsGreaterThan(elements, element);
                    break;
                case "Max":
                    findMaxInList(elements);
                    break;
                case "Min":
                    findMinInList(elements);
                    break;
                case "Print":
                    printList(elements);
                    break;
                default:
                    break;
            }

            args = scanner.nextLine().split(" ");
            command = args[0];
        }
    }

    private static void printList(MyList<String> elements) {
        System.out.println(elements);
    }

    private static void findMinInList(MyList<String> elements) {
        System.out.println(elements.getMin());
    }

    private static void findMaxInList(MyList<String> elements) {
        System.out.println(elements.getMax());
    }

    private static void swapElementsInList(MyList<String> elements, int index, int index2) {
        elements.swap(index, index2);
    }

    private static void findElementsGreaterThan(MyList<String> elements, String element) {
        System.out.println(elements.counteGreaterThan(element));
    }

    private static void findIfListContainsElement(MyList<String> elements, String element) {
        System.out.println(elements.contains(element));
    }

    private static void removeElementFromList(MyList<String> elements, Integer index) {
        elements.remove(index);
    }

    private static void addElementToList(MyList<String> elements, String element) {
        elements.add(element);
    }
}
