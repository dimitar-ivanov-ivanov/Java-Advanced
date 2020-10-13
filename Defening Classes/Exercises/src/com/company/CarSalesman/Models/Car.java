package com.company.CarSalesman.Models;

public class Car {
    private static final int MISSING_WEIGHT = -1;
    private static final String MISSING_COLOR = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = MISSING_WEIGHT;
        this.color = MISSING_COLOR;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }


    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Car parseCar(String[] args, Engine engine) {
        String model = args[0];
        Integer weight = 0;
        String color = "";

        if (args.length == 3) {
            try {
                weight = Integer.parseInt(args[2]);
                return new Car(model, engine, weight);
            } catch (NumberFormatException nfe) {
                color = args[2];
                return new Car(model, engine, color);
            }
        } else if (args.length == 4) {
            weight = Integer.parseInt(args[2]);
            color = args[3];
            return new Car(model, engine, weight, color);
        }

        return new Car(model, engine);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.model + ":\n");
        output.append(this.engine + "\n");

        if (this.weight == MISSING_WEIGHT) {
            output.append("Weight: n/a\n");
        } else {
            output.append("Weight: " + this.weight + "\n");
        }

        output.append("Color: " + this.color);
        return output.toString();
    }
}
