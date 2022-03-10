package com.wooklab.algorithm.inflearn.section4.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * 3. 매출액의 종류
 * 설명
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 *
 * 예시 입력 1
 * 7 4
 * 20 12 20 10 23 17 10
 *
 * 예시 출력 1
 * 3 4 4 3
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(m.solution(n, size, a));
//        System.out.println(m.mySolution2(n, size, a));
//        System.out.println(m.mySolution(n, size, a));
    }

    private String solution(int n, int size, int[] a) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size - 1; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int leftCursor = 0;
        for (int rightCursor = size - 1; rightCursor < n; rightCursor++) {
            map.put(a[rightCursor], map.getOrDefault(a[rightCursor], 0) + 1);
            answer.add(map.size());

            map.put(a[leftCursor], map.get(a[leftCursor]) - 1);
            if (map.get(a[leftCursor]) == 0) {
                map.remove(a[leftCursor]);
            }
            leftCursor++;
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    // 해설 설명 듣고 개선
    private String mySolution2(int n, int size, int[] a) {
        int leftCursor = 0;
        int rightCursor = size - 1;
        int[] answer = new int[n - size + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size - 1; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        while (rightCursor < n) {
            map.put(a[rightCursor], map.getOrDefault(a[rightCursor], 0) + 1);
            answer[leftCursor] = map.size();

            int cnt = map.get(a[leftCursor]);
            if (cnt > 1) {
                map.put(a[leftCursor], --cnt);
            } else {
                map.remove(a[leftCursor]);
            }
            rightCursor++;
            leftCursor++;
        }
        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    // 시간초과
    private String mySolution(int n, int size, int[] a) {
        int[] answer = new int[n - size + 1];
        for (int i = 0; i <= n - size; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + size; j++) {
                set.add(a[j]);
            }
            answer[i] = set.size();
        }
        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
