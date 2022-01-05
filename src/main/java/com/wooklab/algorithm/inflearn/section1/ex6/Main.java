package com.wooklab.algorithm.inflearn.section1.ex6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 6. 중복문자제거
 * 설명
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 *
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 *
 * 예시 입력
 * ksekkset
 *
 * 예시 출력
 * kset
 */
public class Main {

    public String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i)) == i) {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }

    /*public String solution(String word) {
        Set<Character> cSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!cSet.contains(c)) {
                cSet.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(m.solution(input));
    }
}
