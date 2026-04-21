package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Grouping and Counting
 * <p>
 * Practice advanced grouping scenarios including finding the most common
 * element, partitioning, and using downstream collectors like mapping() and maxBy().
 */
public class GroupingAndCounting {

    record Student(String name, int grade, String subject) {
    }

    public static void main(String[] args) {
        List<String> wordsWithRepeats = List.of(
                "java", "streams", "lambda", "java", "streams",
                "java", "functional", "lambda", "streams", "api",
                "java", "lambda", "functional", "api", "streams"
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        List<Student> students = List.of(
                new Student("Alice", 92, "Math"),
                new Student("Bob", 85, "Science"),
                new Student("Charlie", 78, "Math"),
                new Student("Diana", 95, "Science"),
                new Student("Eve", 88, "Math"),
                new Student("Frank", 72, "Science"),
                new Student("Grace", 91, "Math"),
                new Student("Henry", 83, "Science")
        );

        // TODO: 1 - Group 'wordsWithRepeats' by the word itself and count occurrences
        //           Result type: Map<String, Long>
        //           Print each word and its count
        System.out.println("TODO: 1 ");
        Map<String, Long> count =
                wordsWithRepeats
                        .stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(count);
        System.out.println();


        // TODO: 2 - Find the most common word in 'wordsWithRepeats'
        //           Group by word, count occurrences, then find the entry with max value
        //           Hint: Use entrySet().stream() on the grouped map, then max()
        //           Print the word and its count
        System.out.println("TODO: 2 ");
        Map.Entry<String, Long> mostCommonWord =
                wordsWithRepeats
                        .stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Comparator.comparing(Map.Entry::getValue))
                        .get();
        System.out.println(mostCommonWord);
        System.out.println();


        // TODO: 3 - Use Collectors.partitioningBy to split 'numbers' into even and odd
        //           Result type: Map<Boolean, List<Integer>>
        //           Print the even numbers (key=true) and odd numbers (key=false)
        System.out.println("TODO: 3 ");
        Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(result);
        System.out.println();

        // TODO: 4 - Partition 'students' into those with grade >= 85 (pass) and below (fail)
        //           Print each group
        System.out.println("TODO: 4 ");
        Map<Boolean, List<Student>> thoseWithGradeGreater85 =
                students
                        .stream()
                        .collect(Collectors.partitioningBy(student -> student.grade >= 85));
        System.out.println("Pass: " + thoseWithGradeGreater85.get(true));
        System.out.println("Fail: " + thoseWithGradeGreater85.get(false));
        System.out.println();

        // TODO: 5 - Use Collectors.mapping() within groupingBy:
        //           Group students by subject, but collect only their names (not full objects)
        //           Hint: Collectors.groupingBy(Student::subject, Collectors.mapping(Student::name, Collectors.toList()))
        //           Print each subject and its list of student names
        System.out.println("TODO: 5 ");
        Map<String, List<String>> collect =
                students
                        .stream()
                        .collect(Collectors.groupingBy(Student::subject,
                                Collectors.mapping(Student::name, Collectors.toList())));
        System.out.println(collect);
        System.out.println();

        // TODO: 6 - Use maxBy as a downstream collector:
        //           Group students by subject and find the highest-scoring student per subject
        //           Use Collectors.groupingBy with Collectors.maxBy
        //           Print each subject and its top student
        System.out.println("TODO: 6 ");
        Map<String, Optional<Student>> topStudent = students.stream().collect(Collectors.groupingBy(Student::subject, Collectors.maxBy(Comparator.comparing(Student::grade))));
        System.out.println(topStudent);
    }
}
