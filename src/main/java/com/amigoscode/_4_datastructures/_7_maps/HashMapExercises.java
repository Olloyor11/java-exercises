package com.amigoscode._4_datastructures._7_maps;

// Exercise: HashMap Operations
// Learn how to use HashMap - a key-value pair data structure for fast lookups.

import java.util.HashMap;
import java.util.Map;

public class HashMapExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a HashMap<String, Integer> called 'studentGrades'
        //           This will store student names as keys and their grades as values
        HashMap<String, Integer> studentGrades = new HashMap<>();


        // TODO: 2 - Put 5 entries into the map:
        //           "Alice" -> 92, "Bob" -> 85, "Charlie" -> 78, "Diana" -> 95, "Eve" -> 88
        studentGrades.putAll(Map.of(
                "Alice", 92,
                "Bob", 85,
                "Charlie", 78,
                "Diana", 95,
                "Eve", 88

        ));



        // TODO: 3 - Get the grade for "Charlie" using get() and print it

        System.out.println("Grades of Charlie is: "+studentGrades.get("Charlie"));


        // TODO: 4 - Check if the key "Bob" exists using containsKey()
        //           Print the result
        boolean exists = studentGrades.containsKey("Bob");
        System.out.println(exists);


        // TODO: 5 - Check if the value 95 exists using containsValue()
        //           Print the result
        boolean exist = studentGrades.containsValue(95);
        System.out.println(exist);


        // TODO: 6 - Remove the entry for "Eve" using remove()
        //           Print the map after removal
        studentGrades.remove("Eve");
        System.out.println(studentGrades);


        // TODO: 7 - Iterate over the entrySet() using a for-each loop
        //           Print each entry in the format: "Student: <name>, Grade: <grade>"
        for (Map.Entry<String, Integer> name : studentGrades.entrySet()){
            System.out.println("Student: " + name.getKey() +", " + "Grade: "+ name.getValue());
        }


        // TODO: 8 - Iterate over just the keys using keySet() and print them
        //           Then iterate over just the values using values() and print them
        System.out.println("Names: ");
        for (String names : studentGrades.keySet()){
            System.out.println(names);
        }
        System.out.println("Grades: ");
        for (int grades : studentGrades.values()){
            System.out.println(grades);
        }

    }
}
