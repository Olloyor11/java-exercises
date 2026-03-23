package com.amigoscode._4_datastructures._6_sets;

// Exercise: TreeSet Operations
// Learn how to use TreeSet - a sorted set implementation backed by a TreeMap.

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a TreeSet of Integers called 'numbers'
        TreeSet<Integer> numbers = new TreeSet<>();

        // TODO: 2 - Add these elements: 50, 20, 40, 10, 30, 60, 15, 45
        //           Print the set and observe that elements are automatically sorted
        Integer[] array = {50, 20, 40, 10, 30, 60, 15, 45};
        Collections.addAll(numbers, array);
        System.out.println(numbers);


        // TODO: 3 - Get and print the first (lowest) element using first()
        //           Get and print the last (highest) element using last()
        System.out.println(numbers.first());
        System.out.println(numbers.last());


        // TODO: 4 - Get a subset of elements from 20 (inclusive) to 45 (exclusive) using subSet()
        //           Print the subset
        System.out.println(numbers.subSet(20, true,45,false));


        // TODO: 5 - Get and print the headSet (elements less than 30)
        //           Get and print the tailSet (elements greater than or equal to 30)
        System.out.println(numbers.headSet(30));
        System.out.println(numbers.tailSet(30,true));


        // TODO: 6 - Iterate over the TreeSet using a for-each loop
        //           Print each element and observe the natural ascending order

        for (int num : numbers){
            System.out.println(num);
        }

    }
}
