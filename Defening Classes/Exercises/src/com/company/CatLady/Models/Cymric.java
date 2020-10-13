package com.company.CatLady.Models;

import com.company.CatLady.Models.Cat;

public class Cymric extends Cat {
    private int furLength;

    public Cymric(String name, int furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.furLength;
    }
}
