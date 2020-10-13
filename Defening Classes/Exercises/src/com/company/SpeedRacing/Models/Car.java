package com.company.SpeedRacing.Models;

import java.text.DecimalFormat;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForOneKilometer;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostForOneKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean driveCar(int distance) {
        double fuelConsumption = distance * fuelCostForOneKilometer;

        if (fuelConsumption <= fuelAmount) {
            this.fuelAmount -= fuelConsumption;
            this.distanceTravelled += distance;
            return true;
        }

        return false;
    }

    public static Car parseCar(String[] args) {
        return new Car(args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.model + " " + df.format(this.fuelAmount) + " " + this.distanceTravelled;
    }
}