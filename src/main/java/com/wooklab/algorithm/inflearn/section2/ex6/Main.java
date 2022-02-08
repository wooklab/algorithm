package com.wooklab.algorithm.inflearn.section2.ex6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6. 뒤집은 소수
 * 설명
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 * 첫 자리부터의 연속된 0은 무시한다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 *
 * 출력
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 *
 * 예시 입력 1
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 * 예시 출력 1
 * 23 2 73 2 3
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(m.solution(Integer.parseInt(input1),
                                      Arrays.stream(input2.split(" "))
                                            .mapToInt(Integer::parseInt)
                                            .toArray()));
    }

    private String solution(int numberCount, int[] numbers) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numberCount; i++) {
            int number = reverse(numbers[i]);
            if (isPrime(number)) {
                answer.append(number).append(" ");
            }
        }

        return answer.toString();
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int reverse(int number) {
        int result = 0;
        while (number > 0) {
            int tmp = number % 10;
            result = result * 10 + tmp;
            number /= 10;
        }
        return result;
    }
}
