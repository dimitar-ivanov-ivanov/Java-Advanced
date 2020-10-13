package com.company.OpinionPoll;

import com.company.OpinionPoll.Models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> people = getPeople(scanner, numberOfPeople);
        printPeopleOlderThan30SortedAlphabetically(people);

    }

    private static void printPeopleOlderThan30SortedAlphabetically(List<Person> people) {
        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted()
                .forEach(person -> System.out.println(person));
    }

    private static List<Person> getPeople(Scanner scanner, int numberOfPeople) {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] personArgs = scanner.nextLine().split(" ");
            people.add(Person.parsePerson(personArgs));
        }

        return people;
    }
}
