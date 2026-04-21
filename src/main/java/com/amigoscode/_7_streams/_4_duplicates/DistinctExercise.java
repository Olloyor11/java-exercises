package com.amigoscode._7_streams._4_duplicates;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collector;



/**
 * Exercise: Removing Duplicates
 *
 * Learn different ways to remove duplicate elements from a stream
 * using distinct(), collecting to a Set, and custom approaches.
 */
public class DistinctExercise {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Integer> numbersWithDuplicates = List.of(1, 2, 3, 2, 4, 5, 3, 6, 1, 7, 5, 8);
        List<String> mixedCaseNames = List.of("Alice", "bob", "ALICE", "Bob", "charlie", "CHARLIE", "alice");
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 30),
                new Person("Charlie", 35),
                new Person("Bob", 25)
        );
        List<String> fruits = List.of("banana", "apple", "cherry", "apple", "banana", "date", "cherry");

        // TODO: 1 - Remove duplicates from 'numbersWithDuplicates' using distinct()
        //           Print the resulting unique numbers
        System.out.println("TO DO 1: ");
        List<Integer> removeDuplicate = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(removeDuplicate);
        System.out.println();

        // TODO: 2 - Remove duplicates from 'mixedCaseNames' in a case-insensitive manner
        //           Map all names to lowercase first, then use distinct()
        //           Print the resulting unique names
        System.out.println("TO DO 2: ");
        List<String> uniqueNames = mixedCaseNames.stream().map(a -> a.toLowerCase()).distinct().collect(Collectors.toList());
        System.out.println(uniqueNames);
        System.out.println();


        // TODO: 3 - Collect 'fruits' to a Set instead of using distinct()
        //           This automatically removes duplicates
        //           Print the resulting set
        System.out.println("TO DO 3: ");
        Set<String> uniqueFruits = fruits.stream().collect(Collectors.toSet());
        System.out.println(uniqueFruits);
        System.out.println();

        // TODO: 4 - Count the number of distinct elements in 'numbersWithDuplicates'
        //           Use distinct() followed by count()
        //           Print the count
        System.out.println("TO DO 4: ");
        Long countDistinctNums = numbersWithDuplicates.stream().distinct().count();
        System.out.println(countDistinctNums);
        System.out.println();

        // TODO: 5 - Remove duplicate Person objects from 'people'
        //           Since Person is a record, equals/hashCode are auto-generated
        //           Use distinct() and print each unique person
        System.out.println("TO DO 5: ");
        List<Person> uniquePeople = people.stream().distinct().collect(Collectors.toList());
        System.out.println(uniquePeople);
        System.out.println();

        // TODO: 6 - Remove duplicates from 'fruits' with custom logic using a TreeSet
        //           collector that ignores case (use String.CASE_INSENSITIVE_ORDER)
        //           Hint: Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER))
        //           Print the result
        System.out.println("TO DO 6: ");
        System.out.println(fruits.stream().collect(Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER))));
        System.out.println();
    }
}
