package com.wooklab.algorithm.inflearn.section3.ex4;

import java.util.Scanner;

/**
 * <pre>
 * 4. 연속 부분수열
 * 설명
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 * 입력
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 *
 * 출력
 * 첫째 줄에 경우의 수를 출력한다.
 *
 * 예시 입력 1
 * 8 6
 * 1 2 1 3 1 1 1 2
 *
 * 예시 출력 1
 * 3
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(m.solution(n, v, a));
//        System.out.println(m.solution2(n, v, a));
//        System.out.println(m.mySolution(n, v, a));
    }

    private int solution(int n, int v, int[] a) {
        int answer = 0;
        int sum = 0;
        int leftCursor = 0;
        int rightCursor = 0;

        for (rightCursor = 0; rightCursor < n; rightCursor++) {
            sum += a[rightCursor];
            if (sum == v) {
                answer++;
            }
            while (sum >= v) {
                sum -= a[leftCursor++];
                if (sum == v) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private int solution2(int n, int v, int[] a) {
        int answer = 0;
        int leftCursor = 0;
        int rightCursor = 0;
        int sum = 0;
        while (leftCursor != n || rightCursor != n) {
            if (sum == v) {
                answer++;
                sum -= a[leftCursor++];
            } else if (sum > v) {
                sum -= a[leftCursor++];
            } else if (rightCursor < n) {
                sum += a[rightCursor++];
            } else {
                break;
            }
        }
        return answer;
    }

    // failed.. 오답
    private int mySolution(int n, int v, int[] a) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int sum = a[i];
            for (int j = i + 1; j < n - 1; j++) {
                sum += a[j];
                if (sum >= v) {
                    break;
                }
            }
            if (sum == v) {
                answer++;
            }
        }
        return answer;
    }
}
