package com.straho;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, ArrayList<Double>>> students = new TreeMap<String, TreeMap<String, ArrayList<Double>>>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String fullName = tokens[0] + " " + tokens[1];
            String subject = tokens[2];
            double score = Double.parseDouble(tokens[3]);
            if (!students.containsKey(fullName)) {
                ArrayList<Double> scores = new ArrayList<Double>();
                TreeMap<String, ArrayList<Double>> subjectsAndScores = new TreeMap<String, ArrayList<Double>>();
                scores.add(score);
                subjectsAndScores.put(subject, scores);
                students.put(fullName, subjectsAndScores);
            } else {
                if (!students.get(fullName).containsKey(subject)) {
                    ArrayList<Double> scores = new ArrayList<Double>();
                    scores.add(score);
                    students.get(fullName).put(subject, scores);
                } else {
                    students.get(fullName).get(subject).add(score);
                }
            }
        }

        for (String studentName : students.keySet()) {
            String output = studentName + ": [";
            for (String subjectName : students.get(studentName).keySet()) {
                output += subjectName + " - ";
                double averageScore = 0;
                for (Double score : students.get(studentName).get(subjectName)) {
                    averageScore += score;
                }
                averageScore = averageScore / students.get(studentName).get(subjectName).size();
                output += String.format("%.2f", averageScore) + ", ";
            }
            output = output.substring(0, output.length() - 2) + "]";
            System.out.println(output);
        }
    }
}