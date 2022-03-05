package com.wooklab.algorithm.inflearn.section3.ex5;

import java.util.Scanner;

/**
 * <pre>
 * 5. 연속된 자연수의 합
 * 설명
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 * 예시 입력 1
 * 15
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
        System.out.println(m.solution(n));
        System.out.println(m.solution2(n));
//        System.out.println(m.mySolution(n));
    }

    // 수학적으로 풀기
    private int solution2(int n) {
        int answer = 0;
        int cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n -= cnt;
            if (n % cnt == 0) {
                answer++;
            }
        }
        return answer;
    }

    private int solution(int n) {
        int answer = 0;

        int validRange = (n / 2) + 1;     //  1~15 순차적으로 나열 되어 있을때 (n / 2) + 1 범위 이상으로는 유효한 값이 없다.
        int[] arr = new int[validRange];
        for (int i = 0; i < validRange; i++) {
            arr[i] = i + 1;
        }

        int leftCursor = 0;
        int sum = 0;

        for (int rightCursor = 0; rightCursor < validRange; rightCursor++) {
            sum += arr[rightCursor];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[leftCursor++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private int mySolution(int n) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int leftCursor = 0;
        int rightCursor = 0;
        int sum = 0;

        for (rightCursor = 0; rightCursor < n - 1; rightCursor++) {
            sum += arr[rightCursor];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[leftCursor++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
