package com.company.CarSalesman;

import com.company.CarSalesman.Models.Car;
import com.company.CarSalesman.Models.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engines = getEngines(scanner);
        List<Car> cars = getCars(scanner, engines);
        printCars(cars);
    }

    private static void printCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }

    private static List<Car> getCars(Scanner scanner, Map<String, Engine> engines) {
        List<Car> cars = new ArrayList<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] args = scanner.nextLine().split(" ");
            Engine engine = engines.get(args[1]);

            cars.add(Car.parseCar(args, engine));
        }

        return cars;
    }

    private static Map<String, Engine> getEngines(Scanner scanner) {
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] args = scanner.nextLine().split(" ");
            Engine engine = Engine.parseEngine(args);
            if (!engines.containsKey(engine.getModel())) {
                engines.put(engine.getModel(), engine);
            }
        }

        return engines;
    }
}
