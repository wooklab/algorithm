package com.wooklab.algorithm.study.searchtext;

import java.util.Scanner;

/**
 * <pre>
 *     보이어 무어 알고리즘
 *     패턴 문자열의 오른쪽 끝 부분에서부터 왼쪽 앞부분 방향으로 문자를 비교
 *     문자열 앞부분 보다 뒷부분이 불일치가 일어날 확률이 높다는 성질이용
 * </pre>
 */
public class BoyerMooreSearch {

    public static void main(String[] args) {
        BoyerMooreSearch main = new BoyerMooreSearch();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

        int result = main.bmMatch(text, pattern);
        switch (result) {
            case -1:
                System.out.println("일치하는 문자열이 없습니다.");
                break;
            default:
                System.out.println("일치하는 문자열이 " + result + "부터 시작됩니다.");
        }
    }

    private int bmMatch(String text, String pattern) {
        int pointerText;
        int pointerPattern;
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for (pointerText = 0; pointerText <= Character.MAX_VALUE; pointerText++) {
            skip[pointerText] = patternLength;
        }
        for (pointerText = 0; pointerText < patternLength - 1; pointerText++) {
            System.out.println("pt: " + pointerText + ", skip[" + pattern.charAt(pointerText) + "]");
            skip[pattern.charAt(pointerText)] = patternLength - pointerText - 1;
        }

        while (pointerText < textLength) {
            pointerPattern = patternLength - 1; // pattern 끝 문자열부터 비교

            while (text.charAt(pointerText) == pattern.charAt(pointerPattern)) {
                if (pointerPattern == 0) {
                    return pointerText;
                }
                pointerPattern--;
                pointerText--;
            }
            pointerText += Math.max(skip[text.charAt(pointerText)], patternLength - pointerPattern);
        }
        return -1;
    }
}
