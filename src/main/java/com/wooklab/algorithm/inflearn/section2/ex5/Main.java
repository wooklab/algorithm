package com.wooklab.algorithm.inflearn.section2.ex5;

import java.util.Scanner;

/**
 * 5. 소수(에라토스테네스 체)
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 * 예시 입력 1
 * 20
 * 예시 출력 1
 * 8
 */
public class Main {

    /**
     * 소수의 개수를 구하는 문제이기 때문에 실제 숫자로 초기화 불필요
     * 배열의 기본 초기화 0을 그대로 사용하여 마킹에 대한 플래그로 사용
     * 배수의 숫자들에 대해 마킹을 할 때 배수만큼만 반복하여 처리
     */
    public int solution(int input) {
        int answer = 0;
        int[] numbers = new int[input + 1];
        for (int i = 2; i <= input; i++) {
            if (numbers[i] == 0) {
                answer++;
                for (int j = i; j <= input; j = j + i) {
                    numbers[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(m.solution(input));
    }

    // 이중 for문 시간 초과 됨
    /*public long solution(int input) {
        int[] numbers = new int[input];
        for (int i = 0; i < input - 1; i++) {
            numbers[i] = i + 2;
        }

        for (int i = 0; i< numbers.length; i++) {
            if (numbers[i] != 0) {
                calculate(i, numbers);
            }
        }
        return Arrays.stream(numbers)
                     .filter(v -> v != 0)
                     .count();

    }

    private void calculate(int currentPosition, int[] numbers) {
        int flagNumber = numbers[currentPosition];
        for (int i = currentPosition + 1; i < numbers.length; i++) {
            if (numbers[i] > 0 && numbers[i] % flagNumber == 0) {
                numbers[i] = 0;
            }
        }
    }*/
}
