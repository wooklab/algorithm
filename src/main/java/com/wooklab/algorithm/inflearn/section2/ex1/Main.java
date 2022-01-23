package com.wooklab.algorithm.inflearn.section2.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 1. 큰 수 출력하기
 * 설명
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 * <p>
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 * <p>
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 * <p>
 * 예시 입력 1
 * 6
 * 7 3 9 5 6 12
 * <p>
 * 예시 출력 1
 * 7 9 6 12
 */
public class Main {

    public List<Integer> solution(int[] input) {
        List<Integer> answer = new ArrayList<>();
        answer.add(input[0]);

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                answer.add(input[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int numCnt = sc.nextInt();
        int[] input = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(m.solution(input).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    /*public String solution(int[] input) {
        String answer = "" + input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                answer += " " + input[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int numCnt = sc.nextInt();
        int[] input = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(m.solution(input));
    }*/
}
