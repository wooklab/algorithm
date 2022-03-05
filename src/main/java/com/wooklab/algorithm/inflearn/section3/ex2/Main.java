package com.wooklab.algorithm.inflearn.section3.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int aCnt = sc.nextInt();
        int[] a = new int[aCnt];
        for (int i = 0; i < aCnt; i++) {
            a[i] = sc.nextInt();
        }

        int bCnt = sc.nextInt();
        int[] b = new int[bCnt];
        for (int i = 0; i < bCnt; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println(m.solution(aCnt, bCnt, a, b));
//        System.out.println(m.mySolution(aCnt, bCnt, a, b));
    }

    private String solution(int aCnt, int bCnt, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int aCursor = 0;
        int bCursor = 0;

        while (aCursor < aCnt && bCursor < bCnt) {
            if (a[aCursor] > b[bCursor]) {  // 작은 수가 큰수로 증가 되어야 같은지 알 수 있기 때문에 작은 수의 커서를 증가
                bCursor++;
            } else if (a[aCursor] < b[bCursor]) {
                aCursor++;
            } else {
                answer.add(a[aCursor]);
                aCursor++;
                bCursor++;
            }
        }

        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }


    // failed.. 시간 초과
    private String mySolution(int aCnt, int bCnt, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < aCnt; i++) {
            for (int j = 0; j < bCnt; j++) {
                if (a[i] == b[j]) {
                    answer.add(a[i]);
                }
            }
        }
        return answer.stream()
                     .sorted()
                     .map(String::valueOf)
                     .collect(Collectors.joining(" "));
    }
}
