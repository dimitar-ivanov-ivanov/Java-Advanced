package com.company.Box.Models;

import java.util.List;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static <T> void swap(List<T> elements, int firstPosition, int secondPosition) {
        T temp = elements.get(firstPosition);
        elements.set(firstPosition, elements.get(secondPosition));
        elements.set(secondPosition, temp);
    }

    public static <T extends Comparable<T>> int getCountOfElementsGreaterThan(List<Box<T>> elements, T element) {
        int countOfGreaterElements = 0;

        for (int i = 0; i < elements.size(); i++) {
            if (element.compareTo(elements.get(i).getValue()) < 0) {
                countOfGreaterElements++;
            }
        }

        return countOfGreaterElements;
    }

    @Override
    public String toString() {
        return this.value.getClass().getTypeName() + ": " + this.value;
    }
}
