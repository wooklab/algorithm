package com.wooklab.algorithm.inflearn.section3.ex6;

import java.util.Scanner;

/**
 * <pre>
 * 6. 최대 길이 연속부분수열
 * 설명
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 1 1 0 0 [1 1 '1' 1 1 '1' 1 1 ] 0 1
 * 이며 그 길이는 8입니다.
 *
 * 입력
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 *
 * 예시 입력 1
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 예시 출력 1
 * 8
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(m.solution(n, k, arr));
//        System.out.println(m.mySolution(n, k, arr));
    }

    private int solution(int n, int k, int[] arr) {
        int answer = 0;
        int leftCursor = 0;
        int cnt = 0;

        for (int rightCursor = 0; rightCursor < n; rightCursor++) {
            if (arr[rightCursor] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[leftCursor] == 0) {
                    cnt--;
                }
                leftCursor++;
            }
            answer = Math.max(answer, rightCursor - leftCursor + 1);
        }

        return answer;
    }

    // failed.. 오답케이스 발생
    private int mySolution(int n, int k, int[] arr) {
        int answer = 0;
        int leftCursor = 0;
        int rightCursor = 0;
        int zeroCursor = 0;
        int change = 0;
        for (rightCursor = 0; rightCursor < n; rightCursor++) {
            if (arr[rightCursor] == 0 && change < k) {
                change++;
                if (change == 1) {
                    zeroCursor = rightCursor;
                }
            } else if (arr[rightCursor] == 0 && change == k) {
                System.out.println("left:" + leftCursor + ",right:" + rightCursor);
                answer = Math.max(answer, rightCursor - leftCursor);
                leftCursor = zeroCursor + 1;
                rightCursor = leftCursor;
                change = 0;
            }
        }
        System.out.println("left:" + leftCursor + ",right:" + rightCursor);
        answer = Math.max(answer, rightCursor - leftCursor);

        return answer;
    }
}
