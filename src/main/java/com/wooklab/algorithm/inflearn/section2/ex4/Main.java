package com.wooklab.algorithm.inflearn.section2.ex4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 4. 피보나치 수열 설명
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * <p>
 * 입력
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 * 출력
 * 첫 줄에 피보나치 수열을 출력합니다.
 * <p>
 * 예시 입력 1
 * 10
 * 예시 출력
 * 1 1 1 2 3 5 8 13 21 34 55
 */
public class Main {

    public String solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return Arrays.stream(answer)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    private void directPrintNotUseArrays(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    /*public String solution(int fibonacciLength) {
        int[] fibonacciSequence = new int[fibonacciLength];
        int startNumber = 1;
        fibonacciSequence[0] = startNumber;

        for (int i = 1; i < fibonacciLength; i++) {
            if (i == 1) {
                fibonacciSequence[i] = fibonacciSequence[i - 1];
            } else {
                fibonacciSequence[i] = fibonacciSequence[i - 2] + fibonacciSequence[i - 1];
            }
        }
        return Arrays.stream(fibonacciSequence)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(m.solution(input));
    }
}
