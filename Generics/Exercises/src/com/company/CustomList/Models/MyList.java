package com.company.CustomList.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyList<T extends Comparable<T>> {
    private List<T> data;

    public MyList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.data, firstIndex, secondIndex);

    }

    public int counteGreaterThan(T element) {
        int count = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return Collections.max(this.data);
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.data.size(); i++) {
            output.append(this.data.get(i) + "\n");
        }

        return output.toString();
    }
}
