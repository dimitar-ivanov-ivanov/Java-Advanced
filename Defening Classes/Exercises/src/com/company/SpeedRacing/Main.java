package com.company.SpeedRacing;

import com.company.SpeedRacing.Models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = getCars(scanner, numberOfCars);
        driveCars(cars, scanner);
        printCars(cars);
    }

    private static void printCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }

    private static void driveCars(List<Car> cars, Scanner scanner) {
        String[] args = scanner.nextLine().split(" ");

        while (!args[0].equals("End")) {
            String model = args[1];
            Integer distance = Integer.parseInt(args[2]);

            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getModel().equals(model)) {
                    if (!cars.get(i).driveCar(distance)) {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }

            args = scanner.nextLine().split(" ");
        }
    }

    private static List<Car> getCars(Scanner scanner, int numberOfCars) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] args = scanner.nextLine().split(" ");
            cars.add(Car.parseCar(args));
        }

        return cars;
    }
}
