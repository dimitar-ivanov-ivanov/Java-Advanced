package com.company.CatLady;

import com.company.CatLady.Models.Cat;
import com.company.CatLady.Models.Cymric;
import com.company.CatLady.Models.Siamese;
import com.company.CatLady.Models.StreetExtraordinaire;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        List<Cat> cats = getCats(scanner);
        getNameAndPrintCat(cats, scanner);
    }

    private static void getNameAndPrintCat(List<Cat> cats, Scanner scanner) {
        String name = scanner.nextLine();
        cats.stream()
                .filter(cat -> cat.getName().equals(name))
                .forEach(cat -> System.out.println(cat));
    }

    private static List<Cat> getCats(Scanner scanner) {
        List<Cat> cats = new ArrayList<>();
        String[] args = scanner.nextLine().split(" ");

        while (!args[0].equals("End")) {
            String name = args[1];
            int uniqueVal = Integer.parseInt(args[2]);
            switch (args[0]) {
                case "Siamese":
                    cats.add(new Siamese(name, uniqueVal));
                    break;
                case "Cymric":
                    cats.add(new Cymric(name, uniqueVal));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(name, uniqueVal));
                    break;
            }
            args = scanner.nextLine().split(" ");
        }

        return cats;
    }
}
