package com.company.Cars;

import com.company.Cars.Car;

import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] carTokens = scanner.nextLine().split(" ");
            Car car;

            if (carTokens.length == 1) {
                car = new Car(carTokens[0]);
            } else {
                car = new Car(carTokens[0], carTokens[1], Integer.parseInt(carTokens[2]));
            }

            System.out.println(car.carInfo());
        }
    }
}
