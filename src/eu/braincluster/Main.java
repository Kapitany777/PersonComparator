package eu.braincluster;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Test 1");
        Test1();

        System.out.println("Test 2");
        Test2();

        System.out.println("Test 3");
        Test3();
    }

    private static void Test1()
    {
        List<Person> people = Arrays.asList(
                new Person("Pistabá", 50),
                new Person("Feribá", 60),
                new Person("Béla", 40),
                new Person("Julis", 20)
        );

        var ascendingAge1 =
                people.stream()
                        .sorted((person1, person2) -> person1.ageDifference(person2))
                        .collect(Collectors.toList());

        ascendingAge1.forEach(System.out::println);
        System.out.println();

        var ascendingAge2 =
                people.stream()
                        .sorted(Person::ageDifference)
                        .collect(Collectors.toList());

        ascendingAge2.forEach(System.out::println);
        System.out.println();
    }

    private static void Test2()
    {
        List<Person> people = Arrays.asList(
                new Person("Pistabá", 50),
                new Person("Feribá", 60),
                new Person("Béla", 40),
                new Person("Julis", 20)
        );

        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        people.stream()
                .sorted(compareDescending)
                .forEach(System.out::println);

        System.out.println();
    }

    private static void Test3()
    {
        List<Person> people = Arrays.asList(
                new Person("Pistabá", 50),
                new Person("Feribá", 60),
                new Person("Béla", 40),
                new Person("Julis", 20)
        );

        people.stream()
                .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                .forEach(System.out::println);

        System.out.println();

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println();
    }
}
