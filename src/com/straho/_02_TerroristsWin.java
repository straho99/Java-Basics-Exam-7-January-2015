package com.straho;

import java.util.Scanner;

public class _02_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder(text);
        int bombStart, bombEnd;
        bombStart = result.indexOf("|");
        bombEnd = result.indexOf("|", bombStart + 1);
        while (bombStart >= 0 && bombEnd >= 0) {
            String bombContent = result.substring(bombStart + 1, bombEnd);
            int bombPower = calculateBombPower(bombContent);
            int destructionLeftEnd = (bombStart - bombPower) >= 0 ? (bombStart - bombPower) : 0;
            int destructionRightEnd = (bombEnd + bombPower + 1) <= text.length() ? (bombEnd + bombPower + 1) : text.length();
            String dots = String.format("%0" + (destructionRightEnd - destructionLeftEnd) + "d", 0).replace("0", ".");
            result = result.replace(destructionLeftEnd, destructionRightEnd, dots);

            bombStart = result.indexOf("|", bombEnd + 1);
            bombEnd = result.indexOf("|", bombStart + 1);
        }
        System.out.println(result);
    }

    public static int calculateBombPower(String bomb) {
        int sum = 0;
        for (int i = 0; i < bomb.length(); i++) {
            sum += (int) bomb.charAt(i);
        }
        if (sum < 10) {
            return sum;
        }
        return sum % 10;
    }
}