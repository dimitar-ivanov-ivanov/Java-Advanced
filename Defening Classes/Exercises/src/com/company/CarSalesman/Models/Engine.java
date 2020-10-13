package com.company.CarSalesman.Models;

public class Engine {
    private static final int MISSING_DISPLACEMENT = -1;
    private static final String MISSING_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = MISSING_DISPLACEMENT;
        this.efficiency = MISSING_EFFICIENCY;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public static Engine parseEngine(String[] args) {
        String model = args[0];
        Integer power = Integer.parseInt(args[1]);
        Integer displacement = 0;
        String efficiency = "";

        if (args.length == 3) {
            try {
                displacement = Integer.parseInt(args[2]);
                return new Engine(model, power, displacement);
            } catch (NumberFormatException nfe) {
                efficiency = args[2];
                return new Engine(model, power, efficiency);
            }
        } else if (args.length == 4) {
            displacement = Integer.parseInt(args[2]);
            efficiency = args[3];
            return new Engine(model, power, displacement, efficiency);
        }

        return new Engine(model, power);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.model + ":\n");
        output.append("Power: " + this.power + "\n");

        if (this.displacement == MISSING_DISPLACEMENT) {
            output.append("Displacement: n/a\n");
        } else {
            output.append("Displacement: " + this.displacement + "\n");
        }

        output.append("Efficiency: " + this.efficiency);
        return output.toString();
    }
}
