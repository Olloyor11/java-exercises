package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.*;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    public record Student(String name, int grade, String subject){


    }


    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Alice", 92, "Math"),
                new Student("Bob", 78, "Science"),
                new Student("Charlie", 85, "English"),
                new Student("Diana", 90, "Math"),
                new Student("Eve", 72, "Science"),
                new Student("Frank", 88, "English"),
                new Student("Grace", 95, "Math"),
                new Student("Henry", 65, "Science"),
                new Student("Isla", 80, "English"),
                new Student("Jack", 70, "Math")
        ));


        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> group = new HashMap<>();
        for (Student student : students){
            List<Student> list = group.computeIfAbsent(student.subject(), (String k) -> new ArrayList<>() );
            list.add(student);
        }
        for (Map.Entry<String, List<Student>> entry : group.entrySet()){
            System.out.println("Subject: " + entry.getKey() + " and it's students: " + entry.getValue());
        }
        System.out.println();


        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects

        Set<String> uniqueSubjects = new HashSet<>();
        for (Student student : students){
            uniqueSubjects.add(student.subject());

        }
        for (String subject : uniqueSubjects) {
            System.out.println(subject);
        }
        System.out.println();

        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)

        Stack<Student> studentStack = new Stack<>();
        for (int i = 0; i < 3; i++) {
            studentStack.push(students.get(i));

        }
        for (int i = 0; i < 3; i++) {

            System.out.println(studentStack.pop());
        }


        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list

        students.sort(Comparator.comparingInt((Student student) -> student.grade()).reversed());
        System.out.println();


        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)

        System.out.println(" -=SUMMARY REPORT=- ");
        System.out.println("Total number of students: " + students.size());
        System.out.println("Number of unique subjects: " + uniqueSubjects.size());
        Student topStudent = students.get(0);
        System.out.println("Highest grade student: " + topStudent.name() + " in " + topStudent.subject() + " with " + topStudent.grade() + " score! ");
        System.out.println("Number of students per subject: ");
        for (Map.Entry<String, List<Student>> entry : group.entrySet()){
            System.out.println("Subject: " + entry.getKey() + " and it's students: " + entry.getValue().size());
        }
    }
}
