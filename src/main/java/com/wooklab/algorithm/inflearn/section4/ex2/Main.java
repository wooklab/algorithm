package com.wooklab.algorithm.inflearn.section4.ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * <pre>
 * 2. 아나그램(해쉬)
 * 설명
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 *
 * 입력
 * 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
 * 단어의 길이는 100을 넘지 않습니다.
 *
 * 출력
 * 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
 *
 * 예시 입력 1
 * AbaAeCe
 * baeeACA
 *
 * 예시 출력 1
 * YES
 *
 *
 * 예시 입력 2
 * abaCC
 * Caaab
 *
 * 예시 출력 2
 * NO
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        System.out.println(m.solution(text1, text2));
        System.out.println(m.mySolution(text1, text2));
    }

    private String solution(String text1, String text2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (char x : text1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : text2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    private String mySolution(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return "NO";
        }
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < text1.length(); i++) {
            char text1Key = text1.charAt(i);
            m1.put(text1Key, m1.getOrDefault(text1Key, 0) + 1);

            char text2Key = text2.charAt(i);
            m2.put(text2Key, m2.getOrDefault(text2Key, 0) + 1);
        }

        for (char key : m1.keySet()) {
            if (!Objects.equals(m1.get(key), m2.get(key))) {
                return "NO";
            }
        }

        return "YES";
    }

}
