package com.wooklab.algorithm.inflearn.section2.ex2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2. 보이는 학생
 *
 * 설명
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 *
 * 입력
 * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 *
 * 출력
 * 선생님이 볼 수 있는 최대학생수를 출력한다.
 *
 * 예시 입력 1
 * 8
 * 130 135 148 140 145 150 150 153
 *
 * 예시 출력 1
 * 5
 */
public class Main {

    public int solution2(int n, int[] arr) {
        int answer = 1, max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }

    public int solution(String studentCount, String input) {
        int answer = 0;
        int count = Integer.parseInt(studentCount);
        int[] studentsHeight = Arrays.stream(input.split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .toArray();
        if (studentsHeight.length > count) {
            throw new IllegalStateException("매개변수 상태가 불일치 합니다.");
        }

        int currentMaxHeight = 0;
        for (int i = 0; i < studentsHeight.length; i++) {
            if (currentMaxHeight < studentsHeight[i]) {
                answer++;
                currentMaxHeight = studentsHeight[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String studentCount = scanner.nextLine();
        String input = scanner.nextLine();
        System.out.println(m.solution(studentCount, input));
    }
}
