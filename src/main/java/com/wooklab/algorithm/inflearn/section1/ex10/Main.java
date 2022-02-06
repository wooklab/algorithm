package com.wooklab.algorithm.inflearn.section1.ex10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 10. 가장 짧은 문자거리
 *
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 예시 입력 1
 * teachermode e
 * 예시 출력 1
 * 1 0 1 2 1 0 1 2 2 1 0
 */
public class Main {

    public String solution(String word, String target) {
        int p = 100;
        int[] answer = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(0)) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }
        p = 100;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == target.charAt(0)) {
                p = 0;
            } else {
                p++;
            }
            if (answer[i] > p) {
                answer[i] = p;
            }
        }
        return Arrays.stream(answer)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    /*public String solution(String word, String target) {
        int[] result = new int[word.length()];
        for (int idx = 0; idx < result.length; idx++) {
            result[idx] = 100;
        }

        int fromIndex = 0;
        while (word.indexOf(target, fromIndex) != -1) {
            int currentIndex = word.indexOf(target, fromIndex);
            fromIndex = currentIndex + 1;

            int d = 0;
            for (int i = currentIndex; i >= 0; i--) {
                if (result[i] > d) {
                    result[i] = d;
                }
                d++;
            }
            d = 0;
            for (int i = currentIndex; i < result.length; i++) {
                if (result[i] > d) {
                    result[i] = d;
                }
                d++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v + " ");
        }
        return sb.toString();
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();
        System.out.println(m.solution(input1, input2));
    }
}
