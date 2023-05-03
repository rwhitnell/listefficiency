package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ListEfficiency {
    public static void main( String[] args )
    {
       // Building lists of many String objects and getting and sorting them

        final int MAX = 50000;
        ArrayList<String> arrayVersion = new ArrayList<String>();
        LinkedList<String> linkedVersion = new LinkedList<String>();

        // Add 1000 randomly generated strings to each list
        for (int i = 0; i < MAX; i++) {
            StringBuilder sb = new StringBuilder();

            // 97 is the ASCII code for 'a'; this will generate random letters from a-z
            for (int j = 0; j < 10; j++) {
                sb.append((char) ((int) (Math.random() * 26) + 97));
            }
            arrayVersion.add(sb.toString());
            linkedVersion.add(sb.toString());
        }
  //      System.out.println(arrayVersion);
        // time 1,000,000 random gets from the arraylist implementation
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * MAX);
            String s = arrayVersion.get(index);
        }
        long endTime = System.nanoTime();
        System.out.println("Time to get 100,000 random elements from an ArrayList: " 
        + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time 1,000,000 random gets from the linked list implementation
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int index = (int) (Math.random() * MAX);
            String s = linkedVersion.get(index);
        }
        endTime = System.nanoTime();
        System.out.println("Time to get 100,000 random elements from a LinkedList: "
        + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time sorting the arraylist implementation
        startTime = System.nanoTime();
        Collections.sort(arrayVersion); // use the available sort method (which is a mergesort)
        endTime = System.nanoTime();
        System.out.println("Time to sort an ArrayList: "
        + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

        // time sorting the linked list implementation
        startTime = System.nanoTime();
        Collections.sort(linkedVersion); // use the available sort method (which is a mergesort)
        endTime = System.nanoTime();
        System.out.println("Time to sort a LinkedList: "
        + String.format("%.2f", (endTime - startTime) / 1.e6) + " milliseconds");

  
    }


}
