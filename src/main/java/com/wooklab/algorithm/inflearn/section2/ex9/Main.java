package com.wooklab.algorithm.inflearn.section2.ex9;

import java.util.Scanner;

/**
 * <pre>
 * 9. 격자판 최대합
 * 설명
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 *
 * 예시 입력 1
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 *
 * 예시 출력 1
 * 155
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrs[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.solution(n, arrs));
    }

    private int solution(int n, int[][] arrs) {
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arrs[i][j];
                colSum += arrs[j][i];
            }
            int currentMaxSum = Math.max(rowSum, colSum);
            maxSum = Math.max(maxSum, currentMaxSum);
        }
        int leftHorSum = 0;
        int rightHorSum = 0;
        for (int i = 0; i < n; i++) {
            leftHorSum += arrs[i][i];
            rightHorSum += arrs[i][n - 1 - i];
        }
        int currentMaxHorSum = Math.max(leftHorSum, rightHorSum);
        maxSum = Math.max(maxSum, currentMaxHorSum);
        return maxSum;
    }
}
