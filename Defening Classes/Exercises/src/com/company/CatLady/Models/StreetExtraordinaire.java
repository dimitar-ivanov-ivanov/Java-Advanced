package com.company.CatLady.Models;

import com.company.CatLady.Models.Cat;

public class StreetExtraordinaire extends Cat {
    private int decibelsOfMeows;

    public StreetExtraordinaire(String name, int decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.decibelsOfMeows;
    }
}
