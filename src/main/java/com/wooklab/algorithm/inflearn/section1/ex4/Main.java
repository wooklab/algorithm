package com.wooklab.algorithm.inflearn.section1.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 * 설명
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 *
 * 예시 입력
 * 3
 * good
 * Time
 * Big
 *
 * 예시 출력
 * doog
 * emiT
 * giB
 */
public class Main {

    public List<String> solution(int n, String[] words) {
        List<String> results = new ArrayList<>();
        for (String word : words) {
            // results.add(reverse(word));
            results.add(new StringBuilder(word).reverse().toString());
        }
        return results;
    }

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length(); i > 0; i--) {
            sb.append(word.charAt(i - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        String[] words = new String[inputCount];
        for (int i = 0; i < inputCount; i++) {
            words[i] = sc.next();
        }
        m.solution(inputCount, words).forEach(System.out::println);
    }
}
