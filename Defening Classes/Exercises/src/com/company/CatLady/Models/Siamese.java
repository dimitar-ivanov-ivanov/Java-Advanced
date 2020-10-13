package com.company.CatLady.Models;

import com.company.CatLady.Models.Cat;

public class Siamese extends Cat {
    private int earSize;

    public Siamese(String name, int earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.earSize;
    }
}
