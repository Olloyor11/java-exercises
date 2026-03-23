package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }


        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i);

        }
        long arrayListTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("ArrayList time when insertions at the beginning: " + arrayListTime + " ms");
        System.out.println();

        startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linkedList.add(0, i);

        }
        long linkedListTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("LinkedList time when insertions at the beginning: " + linkedListTime + " ms");
        System.out.println();

        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        long startingTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }
        long linkedListsTime = (System.nanoTime() - startingTime) / 1_000_000;
        System.out.println("LinkedList time: " + linkedListsTime + " ms");
        System.out.println();

        startingTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        long arrayListsTime = (System.nanoTime() - startingTime) / 1_000_000;
        System.out.println("ArrayList time: " + arrayListsTime + " ms");
        System.out.println();

        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
//
        long startsTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(linkedList.size() / 2);
        }
        long linkdListsTime = (System.nanoTime() - startsTime) / 1_000_000;
        System.out.println("LinkedList time when random access: " + linkdListsTime + " ms");
        System.out.println();

        startsTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            arrayList.get(arrayList.size() / 2);
        }
        long arraysListsTime = (System.nanoTime() - startsTime) / 1_000_000;
        System.out.println("ArrayList time when random access: " + arraysListsTime + " ms");
        System.out.println();


        // TODO: 5 - Print a summary explaining the differences
        //           Use System.out.println() to explain:
        //           - Why LinkedList is faster for insertions at the beginning
        //           - Why ArrayList is faster for random access (get by index)
        //           - When you would choose one over the other
        System.out.println("Why LinkedList is faster for insertions at the beginning: " +
                "it is because of how they works under the hood! as we know in LinkedList every obj holds" +
                " link to the previous obj and to the obj next to it! that is why it is easier to add obj to the beginning" +
                " cuz in linkedList it just creates a new node and link to that node as beginning of the linkedList obj " +
                "while in Arraylist after adding it have to move every single obj one by one to the left " +
                "which takes so much time   ");
        System.out.println();

        System.out.println("Why ArrayList is faster for random access (get by index): " + "As an Arraylist is backed by an array and it has index by default and to find it is very easy for that " +
                "while LinkedList does not have any clue about what is index and that is why " +
                "it starts from the beginning and goes through every element to find that index");

        System.out.println();
        System.out.println("I will choose Arraylist for " +
                "-Fast random access " +
                "-adding element to the end" +
                "-for saving memory" +
                "I will choose LinkedList for " +
                "-adding or removing elements to/from the beginning");

    }
}
