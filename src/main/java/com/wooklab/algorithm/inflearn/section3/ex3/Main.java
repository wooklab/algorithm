package com.wooklab.algorithm.inflearn.section3.ex3;

import java.util.Scanner;

/**
 * <pre>
 * 3. 최대 매출
 * 설명
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 15 11 20 25 10 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 * 예시 입력 1
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * 예시 출력 1
 * 56
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        int repeatDays = sc.nextInt();
        int[] sales = new int[days];
        for (int i = 0; i < days; i++) {
            sales[i] = sc.nextInt();
        }

        System.out.println(m.solution(days, repeatDays, sales));
//        System.out.println(m.mySolution(days, repeatDays, sales));
    }

    private int solution(int days, int repeatDays, int[] sales) {
        int maxSalesForRepeatDays = 0;
        for (int i = 0; i < repeatDays; i++) {
            maxSalesForRepeatDays += sales[i];
        }

        int currentMaxSales = maxSalesForRepeatDays;
        for (int i = repeatDays; i < days; i++) {
            currentMaxSales = currentMaxSales + sales[i] - sales[i - repeatDays];   // 창을 이동하는 것처럼 사용(이중 for문 X)
            maxSalesForRepeatDays = Math.max(currentMaxSales, maxSalesForRepeatDays);
        }
        return maxSalesForRepeatDays;
    }

    // failed.. 시간초과
    private int mySolution(int days, int repeatDays, int[] sales) {
        int maxSalesForRepeatDays = 0;

        for (int i = 0; i < days - repeatDays; i++) {
            int currentMaxSales = 0;
            for (int j = i; j < i + repeatDays; j++) {
                currentMaxSales += sales[j];
            }
            if (maxSalesForRepeatDays < currentMaxSales) {
                maxSalesForRepeatDays = currentMaxSales;
            }
        }
        return maxSalesForRepeatDays;
    }
}
