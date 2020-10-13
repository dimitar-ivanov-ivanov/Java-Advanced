package com.company.RawData;

import com.company.RawData.Models.Car;
import com.company.RawData.Models.Cargo;
import com.company.RawData.Models.Engine;
import com.company.RawData.Models.Tyre;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = getCars(scanner, numberOfCars);
        filterCarsThroughCargoType(cars, scanner);
    }

    private static void filterCarsThroughCargoType(List<Car> cars, Scanner scanner) {
        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            cars.stream()
                    .filter(car -> {
                        return car.getTyres().stream().filter(tyre -> tyre.getPressure() < 1).toArray().length > 0;
                    })
                    .forEach(car -> System.out.println(car));
        } else if (cargoType.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car));
        }

    }

    private static List<Car> getCars(Scanner scanner, int numberOfCars) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] args = scanner.nextLine().split(" ");
            String model = args[0];
            Integer engineSpeed = Integer.parseInt(args[1]);
            Integer enginePower = Integer.parseInt(args[2]);
            Integer cargoWeight = Integer.parseInt(args[3]);
            String cargoType = args[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tyre> tyres = new ArrayList<>();
            for (int j = 5; j < args.length - 1; j += 2) {
                Double tyrePressure = Double.parseDouble(args[j]);
                Integer tyreAge = Integer.parseInt(args[j + 1]);
                tyres.add(new Tyre(tyrePressure, tyreAge));
            }

            cars.add(new Car(model, engine, cargo, tyres));
        }

        return cars;
    }
}
