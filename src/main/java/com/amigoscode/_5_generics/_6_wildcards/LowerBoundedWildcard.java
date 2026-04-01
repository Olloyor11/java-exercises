package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Lower Bounded Wildcards (? super T)
 *
 * A lower bounded wildcard <? super Integer> accepts Integer and all its
 * supertypes (Number, Object). This is useful when you want to WRITE to
 * a generic structure.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list CONSUMES values (you write to it), use "super".
 *
 * Complete the TODOs below.
 */
public class LowerBoundedWildcard {

    // TODO: 1 - Create a static method: void addNumbers(List<? super Integer> list)
    //  It should add the integers 1, 2, and 3 to the list.
    //  This works because any list that holds Integer or a supertype of Integer
    //  can safely accept Integer values.

    static void addNumbers(List<? super Integer> list){
        for (int i = 1; i < 4; i++) {
            list.add(i);

        }
    }


    // TODO: 2 - Create a static method:
    //  <T> void moveElements(List<? extends T> source, List<? super T> destination)
    //  It should read each element from source and add it to destination.
    //  This is the PECS principle in action:
    //    source uses "extends" because it PRODUCES elements (we read from it)
    //    destination uses "super" because it CONSUMES elements (we write to it)

    static <T> void moveElements(List<? extends T> source, List<? super T> destination){
        for (T element : source){
            destination.add(element);

        }

    }


    public static void main(String[] args) {

        // TODO: 3 - Call addNumbers() with three different list types:
        //  (a) List<Integer>   - Integer is Integer (exact match)
        //  (b) List<Number>    - Number is a supertype of Integer
        //  (c) List<Object>    - Object is a supertype of Integer
        //  Print each list after calling addNumbers().
        List<Integer> nums = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        addNumbers(nums);
        System.out.println(nums);
        addNumbers(numbers);
        System.out.println(numbers);
        addNumbers(objects);
        System.out.println(objects);



        // TODO: 4 - Demonstrate that you CAN add Integer to List<? super Integer>.
        //  Create a List<? super Integer> variable, assign a new ArrayList<Number>()
        //  to it, and add several Integer values. Print the list.
        //  Then try adding a Double and observe/explain the compile error (commented out).
        //
        // list.add(3.14);  // Why doesn't this compile even though list holds Numbers?
        List<? super Integer> variable = new ArrayList<Number>();
        variable.add(12);
        variable.add(34);
        variable.add(134);
        variable.add(75);
        variable.add(745);
        variable.add(89);
        variable.add(23);



        // TODO: 5 - Use moveElements() to move elements from a List<Integer> source
        //  to a List<Number> destination. Print the destination list to verify.
        List<Integer> sources = new ArrayList<>(List.of(12, 34, 134, 75));
        moveElements(sources, numbers);


        // TODO: 6 - Add a comment below explaining the PECS principle
        //  (Producer Extends, Consumer Super) as it applies to this exercise.
        //  Why is "super" appropriate when the list is a CONSUMER (we write to it)?
        //  How does this complement the "extends" wildcard?

        /*
        what I can understand from PECS principle we can use it to move elements
        between collections and we use extends keyword and data type next to it
        to read the elements from it and use super and data type to mark
        it as destination part but we can not copy or move
        from the list which is marked super
         */

    }
}
