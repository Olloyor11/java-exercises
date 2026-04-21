package com.amigoscode._7_streams._11_understanding;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercise: Lazy Evaluation and Stream Behavior
 *
 * Understand how streams are lazily evaluated, how short-circuiting works,
 * why streams can only be consumed once, and how operation ordering
 * affects performance.
 */
public class LazyStreams {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve", "Frank");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: 1 - Demonstrate lazy evaluation using peek():
        //           Create a stream from 'names', add peek(n -> System.out.println("Processing: " + n))
        //           before a filter that keeps names with length > 3,
        //           add another peek after the filter,
        //           then use findFirst() as terminal operation.
        //           Observe: not all elements are processed! Operations execute per-element.
        //           Print the result.
        System.out.println("TODO: 1 ");
        Optional<String> first = names
                .stream()
                .peek(n -> System.out.println("Processing: " + n))
                .filter(n -> n.length() > 3)
                .peek(s -> System.out.println("After the Filter: " + s))
                .findFirst();
        System.out.println(first);
        System.out.println();


        // TODO: 2 - Demonstrate short-circuiting with findFirst():
        //           Create a stream from 'numbers', use peek to print "Checking: " + number,
        //           filter for numbers > 5, then findFirst().
        //           Notice how the stream stops processing once the first match is found.
        //           Print how many elements were actually checked.
        System.out.println("TODO: 2 ");
        numbers.stream().peek(num -> System.out.println("Checking: " + num)).filter(num -> num > 5).findFirst();
        System.out.println();

        // TODO: 3 - Show that streams can only be consumed once:
        //           Create a Stream<String> variable from 'names'.
        //           Call count() on it (first consumption).
        //           Then try to call count() again on the same stream.
        //           Wrap the second call in a try-catch for IllegalStateException.
        //           Print the exception message.
        System.out.println("TODO: 3 ");
        Stream<String> namesVar = names.stream();

        long counter = namesVar.count();
        System.out.println("First counter:" + counter);

        try {
            long seconCount = namesVar.count();
            System.out.println("Second count: " + seconCount);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // TODO: 4 - Demonstrate that ordering of operations matters for performance:
        //           Approach 1: filter first, then map (efficient)
        //           numbers.stream().filter(n -> n > 5).map(n -> n * n)...
        //           Approach 2: map first, then filter (wasteful - maps elements that get filtered)
        //           numbers.stream().map(n -> n * n).filter(n -> n > 25)...
        //           Use peek() to count how many times map executes in each approach.
        //           Both give the same result but the first approach does less work.
        System.out.println("TODO: 4 ");
        System.out.println("FILTER");
        List<Integer> peek = numbers
                .stream()
                .filter(n -> n > 5)
                .map(n -> n * n)
                .peek(s -> System.out.println("Filter first: " + s))
                .toList();
        System.out.println(peek);
        System.out.println();
        System.out.println("MAP");

        Stream<Integer> peek1 = numbers
                .stream()
                .map(n -> {
                    System.out.println("Mapping: " + n);
                return n * n;})
                .filter(n -> n > 25)
                .peek(s -> System.out.println("Map first: " + s));
        System.out.println(peek1.toList());
        System.out.println();

        // TODO: 5 - Show the difference between intermediate and terminal operations:
        //           Create a stream pipeline with filter and map but NO terminal operation.
        //           Add a System.out.println("This should NOT print") inside peek.
        //           Then add a terminal operation (e.g., collect) to a second pipeline
        //           with a peek that prints "This SHOULD print".
        //           Observe: without a terminal operation, nothing happens!
        System.out.println("TODO: 5 ");
        numbers.stream().peek(num -> System.out.println("This should NOT print"));
        numbers.stream().peek(num -> System.out.println("This SHOULD print")).collect(Collectors.toList());


    }
}
