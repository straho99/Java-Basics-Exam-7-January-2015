package com.straho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _01_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[n];
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int j = 0; j < tokens.length; j++) {
                if (tokens[j].length() > 0) {
                    newList.add(Integer.parseInt(tokens[j]));
                }
            }
            Collections.sort(newList);
            numbers.add(newList);
            //System.out.println(Arrays.toString(newList.toArray()));
        }
        int currentNumber = numbers.get(0).get(0);
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(currentNumber);
        for (int i = 1; i < numbers.size(); i++) {
            boolean foundBigger = false;
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (numbers.get(i).get(j) > currentNumber) {
                    currentNumber = numbers.get(i).get(j);
                    foundBigger = true;
                    result.add(currentNumber);
                    break;
                }
            }
            if (foundBigger == false) {
                currentNumber++;
            }
        }
        System.out.println(result.toString().substring(1, result.toString().length()-1));
    }
}