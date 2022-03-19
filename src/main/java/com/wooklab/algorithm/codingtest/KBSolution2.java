package com.wooklab.algorithm.codingtest;

import java.util.Arrays;
import java.util.stream.Collectors;

// unsolved..
public class KBSolution2 {

    public static void main(String[] args) {
        KBSolution2 m = new KBSolution2();
        m.print(m.solution(new int[]{1, 1, 2, 0})); // answer: 1,1,2,1
        m.print(m.solution(new int[]{1, 1, 1})); // answer: 0,1,0
    }

    // 매개변수: 자기 위치에서 보이는 앞뒤사람의 검은모자 개수
    // 결과로 나타낼 모자 색 => 검: 1, 흰: 2, 모름: 0
    public int[] solution(int[] black_caps) {
        int[] answer = new int[black_caps.length];

        check(black_caps, answer);
        check(black_caps, answer);

        return answer;
    }

    private void check(int[] black_caps, int[] answer) {
        for (int i = 0; i < black_caps.length; i++) {
            if (i == 0) {
                answer[1] = black_caps[i] == 1 ? 1 : 2;
            } else if (i == black_caps.length - 1) {
                answer[black_caps.length - 2] = black_caps[i] == 1 ? 1 : 2;
            } else {
                int blackCount = black_caps[i];
                if (blackCount == 2) {
                    answer[i - 1] = 1;
                    answer[i + 1] = 1;
                } else if (blackCount == 0) {
                    answer[i - 1] = 2;
                    answer[i + 1] = 2;
                } else {
                    if (answer[i - 1] == 2) {
                        answer[i + 1] = 1;
                    } else if (answer[i + 1] == 2) {
                        answer[i - 1] = 1;
                    }
                }
            }
        }
    }

    private void print(int[] answer) {
        String log = Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(log);
    }
}
