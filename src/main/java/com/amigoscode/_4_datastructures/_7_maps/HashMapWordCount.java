package com.amigoscode._4_datastructures._7_maps;

// Exercise: Word Frequency Counter using HashMap
// A practical exercise to count word occurrences in a sentence.

import com.sun.jdi.Value;

import java.util.*;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] words = sentence.split(" ");


        // TODO: 2 - Create a HashMap<String, Integer> called 'wordCount'
        //           Iterate through the words array and count the frequency of each word
        //           Hint: use getOrDefault(word, 0) + 1 to increment the count
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCount);

        // TODO: 3 - Print each word and its count by iterating over the map
        //           Format: "<word>: <count>"
        Iterator<String> iterator = wordCount.keySet().iterator();
        Iterator<Integer> val = wordCount.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + ": " + val.next());

        }
        System.out.println();

        for (Map.Entry<String, Integer> one : wordCount.entrySet()){
            System.out.println(one.getKey() + ": " + one.getValue());
        }
        System.out.println();




        // TODO: 4 - Find and print the most frequent word
        //           Iterate through the entrySet and track the entry with the highest value
        Integer highest = 0;
        String highestWord = "";
        for (Map.Entry<String, Integer> one : wordCount.entrySet()){
            if (highest < one.getValue()){
                highest = one.getValue();
                highestWord = one.getKey();
            }
            
        }
        System.out.println("The most frequent word used is: " + highestWord);


        // TODO: 5 - Find and print all words that appear only once
        //           Iterate through the entrySet and collect entries where value == 1

        for (Map.Entry<String, Integer> unfrequentWord : wordCount.entrySet()){
            if (unfrequentWord.getValue() == 1){
                System.out.println(unfrequentWord.getKey());

            }
        }
        System.out.println();


        // TODO: 6 - Sort the map entries by value (frequency) in descending order and print
        //           Hint: create a List from entrySet(), then sort using a Comparator
        //           that compares entry values in reverse order

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        for (Map.Entry<String, Integer> word : wordCount.entrySet()){
            entryList.add(word);
        }
        entryList.sort(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed());
        System.out.println(entryList);

        }




    }

