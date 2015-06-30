package com.straho;

import java.util.Scanner;

public class _03_FireTheArrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder[] matrix = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = new StringBuilder(scanner.nextLine());
        }

        boolean hasMoreMoves = true;
        while (hasMoreMoves) {
            hasMoreMoves = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length(); j++) {
                    String type = getArrowType(matrix[i].charAt(j));
                    if (type.equals("left")) {
                        if (j > 0 && getArrowType(matrix[i].charAt(j-1)).equals("none")) {
                            matrix[i].setCharAt(j, (char)111);
                            matrix[i].setCharAt(j-1, (char)60);
                            hasMoreMoves = true;
                        }
                    } else if (type.equals("right")) {
                        if (j < matrix[i].length() - 1 && getArrowType(matrix[i].charAt(j+1)).equals("none")) {
                            matrix[i].setCharAt(j, (char)111);
                            matrix[i].setCharAt(j+1, (char)62);
                            hasMoreMoves = true;
                        }
                    } else if (type.equals("up")) {
                        if (i > 0 && getArrowType(matrix[i-1].charAt(j)).equals("none")) {
                            matrix[i].setCharAt(j, (char)111);
                            matrix[i-1].setCharAt(j, (char)94);
                            hasMoreMoves = true;
                        }
                    } else if (type.equals("down")) {
                        if (i < matrix.length - 1 && getArrowType(matrix[i+1].charAt(j)).equals("none")) {
                            matrix[i].setCharAt(j, (char)111);
                            matrix[i+1].setCharAt(j, (char)118);
                            hasMoreMoves = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
        }
    }

    public static String getArrowType (char arrow) {
        if ((int)arrow == 60) {
            return "left";
        } else if ((int)arrow == 62) {
            return "right";
        } else if ((int)arrow == 94) {
            return "up";
        } else  if ((int)arrow == 118) {
            return "down";
        } else {
            return "none";
        }
    }
}
