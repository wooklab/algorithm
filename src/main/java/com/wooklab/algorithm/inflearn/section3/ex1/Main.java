package com.wooklab.algorithm.inflearn.section3.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <pre>
 * 1. 두 배열 합치기
 * 설명
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 예시 입력 1
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * 예시 출력 1
 * 1 2 3 3 5 6 7 9
 * </pre>
 */
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
//        System.out.println(m.mySolution(a, b));
    }

    private String solution(int aCnt, int bCnt, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int aCursor = 0;
        int bCursor = 0;

        while (aCursor < aCnt && bCursor < bCnt) {
            if (a[aCursor] < b[bCursor]) {
                answer.add(a[aCursor++]);
            } else {
                answer.add(b[bCursor++]);
            }
        }

        while (aCursor < aCnt) {
            answer.add(a[aCursor++]);
        }
        while (bCursor < bCnt) {
            answer.add(b[bCursor++]);
        }

        return answer.stream()
                     .map(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    private String mySolution(int[] a, int[] b) {
        int sumArraySize = a.length + b.length;
        int[] result = new int[sumArraySize];

        int filledCursor = 0;
        int aCursor = 0;
        int bCursor = 0;
        while (filledCursor != sumArraySize) {
            if (aCursor == a.length) {
                result[filledCursor++] = b[bCursor++];
            } else if (bCursor == b.length) {
                result[filledCursor++] = a[aCursor++];
            } else if (a[aCursor] <= b[bCursor]) {
                result[filledCursor++] = a[aCursor++];
            } else {
                result[filledCursor++] = b[bCursor++];
            }
        }

        return Arrays.stream(result)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }
}
