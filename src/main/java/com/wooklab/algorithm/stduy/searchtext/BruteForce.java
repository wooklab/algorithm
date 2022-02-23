package com.wooklab.algorithm.stduy.searchtext;

import java.util.Scanner;

public class BruteForce {

    public static void main(String[] args) {
        BruteForce main = new BruteForce();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

//        int result = main.bfMatch(text, pattern);
        int result = main.bfMatchLast(text, pattern);
        switch (result) {
            case -1:
                System.out.println("일치하는 문자열이 없습니다.");
                break;
            default:
                System.out.println("일치하는 문자열이 " + result + "부터 시작됩니다.");
        }
    }

    private int bfMatch(String text, String pattern) {
        int textCursor = 0;
        int patternCursor = 0;

        while (textCursor != text.length() && patternCursor != pattern.length()) {
            if (text.charAt(textCursor) == pattern.charAt(patternCursor)) {
                printStatus(text, textCursor, pattern, patternCursor, '+');
                textCursor++;
                patternCursor++;
            } else {
                printStatus(text, textCursor, pattern, patternCursor, '|');
                textCursor = textCursor - patternCursor + 1;
                patternCursor = 0;
            }
        }
        if (patternCursor == pattern.length()) {
            return textCursor - patternCursor;
        }
        return -1;
    }

    private int bfMatchLast(String text, String pattern) {
        int textCursor = 0;
        int patternCursor = 0;

        while (text.length() + textCursor != 0 && pattern.length() + patternCursor != 0) {
            if (text.charAt(text.length() + textCursor - 1) == pattern.charAt(pattern.length() + patternCursor - 1)) {
                textCursor--;
                patternCursor--;
            } else {
                textCursor = textCursor - patternCursor - 1;
                patternCursor = 0;
            }
        }
        if (pattern.length() + patternCursor == 0) {
            return text.length() + textCursor;
        }
        return -1;
    }

    private void printStatus(String text, int textCursor, String pattern, int patternCursor, char flag) {
        int currentLocation = textCursor - patternCursor;
        StringBuilder whiteSpace = new StringBuilder();
        for (int i = 0; i < currentLocation; i++) {
            whiteSpace.append(" ");
        }
        StringBuilder flagWhiteSpace = new StringBuilder();
        for (int i = 0; i < patternCursor; i++) {
            flagWhiteSpace.append(" ");
        }
        System.out.println(text);
        System.out.println(whiteSpace.toString() + flagWhiteSpace.toString() + flag);
        System.out.println(whiteSpace.toString() + pattern);
    }
}
