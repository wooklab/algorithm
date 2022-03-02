package com.wooklab.algorithm.study.searchtext;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KMPSearch {

    /**
     * <pre>
     * e.g.
     * zabcabcabdzdf
     * abcabd
     * </pre>
     */
    public static void main(String[] args) {
        KMPSearch m = new KMPSearch();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

        int index = m.kmpSearch(text, pattern);
        switch (index) {
            case -1:
                System.out.println("일치하는 텍스트가 없습니다.");
                break;
            default:
                System.out.println("일치하는 텍스트의 시작위치:" + index);
        }
    }

    private int kmpSearch(String text, String pattern) {
        int pointerText = 1;
        int pointerPattern = 0;
        int[] skip = new int[pattern.length() + 1];

        skip[pointerText] = 0;
        while (pointerText != pattern.length()) {
            if (pattern.charAt(pointerText) == pattern.charAt(pointerPattern)) {
                skip[++pointerText] = ++pointerPattern;
            } else if (pointerPattern == 0) {
                skip[++pointerText] = pointerPattern;
            } else {
                pointerPattern = skip[pointerPattern];
            }
        }
        String skipArrAsString = Arrays.stream(skip).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(skipArrAsString);

        pointerText = 0;
        pointerPattern = 0;
        while (pointerText != text.length() && pointerPattern != pattern.length()) {
            if (text.charAt(pointerText) == pattern.charAt(pointerPattern)) {
                printStatus(text, pointerText, pattern, pointerPattern, '+');
                pointerText++;
                pointerPattern++;
            } else if (pointerPattern == 0) {
                printStatus(text, pointerText, pattern, pointerPattern, '|');
                pointerText++;
            } else {
                pointerPattern = skip[pointerPattern];
            }
        }

        if (pointerPattern == pattern.length()) {
            return pointerText - pointerPattern;
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
        System.out.println();
    }
}
