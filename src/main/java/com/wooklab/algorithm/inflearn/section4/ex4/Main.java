package com.wooklab.algorithm.inflearn.section4.ex4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * <pre>
 * 4. 모든 아나그램 찾기
 * 설명
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 *
 * 예시 입력 1
 * bacaAacba
 * abc
 *
 * 예시 출력 1
 * 3
 *
 * 힌트
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();

        if (input1.length() < 10_000 && input1.length() < input2.length()) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }

        System.out.println(m.solution(input1, input2));
//        System.out.println(m.mySolution(input1, input2));
    }

    private int solution(String a, String b) {
        int answer = 0;
        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        for (char c : b.toCharArray()) {
            bMap.put(c, bMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < b.length() - 1; i++) {
            aMap.put(a.charAt(i), aMap.getOrDefault(a.charAt(i), 0) + 1);
        }

        int leftCursor = 0;
        for (int rightCursor = b.length() - 1; rightCursor < a.length(); rightCursor++) {
            aMap.put(a.charAt(rightCursor), aMap.getOrDefault(a.charAt(rightCursor), 0) + 1);

            if (Objects.equals(aMap, bMap)) {
                answer++;
            }

            aMap.put(a.charAt(leftCursor), aMap.get(a.charAt(leftCursor)) - 1);

            if (aMap.get(a.charAt(leftCursor)) == 0) {
                aMap.remove(a.charAt(leftCursor));
            }

            leftCursor++;
        }
        return answer;
    }


    // failed... two-point 알고리즘으로 풀어야 함.
    private int mySolution(String input1, String input2) {
        Set<Character> sameCharSet = new HashSet<>();
        for (int i = 0; i < input1.length(); i++) {
            for (int j = 0; j < input2.length(); j++) {
                if (input1.charAt(i) == input2.charAt(j)) {
                    sameCharSet.add(input1.charAt(i));
                }
            }
        }
        return sameCharSet.size();
    }
}
