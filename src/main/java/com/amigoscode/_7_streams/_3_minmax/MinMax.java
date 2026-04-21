package com.amigoscode._7_streams._3_minmax;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Exercise: Min and Max
 *
 * Learn how to find minimum and maximum elements in a stream
 * using min(), max(), and reduce(). These operations return Optional
 * since the stream might be empty.
 */
public class MinMax {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(45, 12, 89, 3, 67, 34, 91, 23, 56);
        List<String> words = List.of("Java", "Streams", "Hi", "Programming", "API", "Go");
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 22),
                new Person("Eve", 28)
        );
        List<Integer> emptyList = List.of();

        // TODO: 1 - Find the minimum value in 'numbers' using stream min()
        //           Use Comparator.naturalOrder() or Integer::compareTo
        //           Print the result
        System.out.println("TO DO 1: ");
        Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
        Integer minWithCompareTo = numbers.stream().min(Integer::compareTo).get();
        System.out.println("Use Comparator.naturalOrder(): " + min);
        System.out.println("Use Integer::compareTo: " + minWithCompareTo);
        System.out.println();


        // TODO: 2 - Find the maximum value in 'numbers' using stream max()
        //           Print the result
        System.out.println("TO DO 2: ");
        Integer max = numbers.stream().max(Integer::compareTo).get();
        System.out.println(max);
        System.out.println();


        // TODO: 3 - Find the shortest string in 'words' by comparing string length
        //           Use Comparator.comparingInt(String::length)
        //           Print the result
        System.out.println("TO DO 3: ");
        String wordLengthComparator = words.stream().min(Comparator.comparingInt(String::length)).get();
        System.out.println(wordLengthComparator);
        System.out.println();


        // TODO: 4 - Find the youngest person from 'people'
        //           Use Comparator.comparingInt(Person::age)
        //           Print the person's name and age
        System.out.println("TO DO 4: ");
        Person youngestPerson = people.stream().min(Comparator.comparingInt(Person::age)).get();
        System.out.println("Youngest person is: " + youngestPerson);
        System.out.println();

        // TODO: 5 - Find the maximum value in 'numbers' using reduce() instead of max()
        //           Use Integer::max as the binary operator
        //           Print the result
        System.out.println("TO DO 5: ");
        Integer maxNum = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxNum);
        System.out.println();

        // TODO: 6 - Handle the empty stream case: try to find min of 'emptyList'
        //           Use orElse() to provide a default value of -1
        //           Print the result
        System.out.println("TO DO 6: ");
        Integer minEmptyList = emptyList.stream().min(Integer::compareTo).orElse(-1);
        System.out.println(minEmptyList);

        System.out.println();
    }
}
