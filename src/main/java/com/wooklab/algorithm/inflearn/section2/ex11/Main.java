package com.wooklab.algorithm.inflearn.section2.ex11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <pre>
 * 11. 임시반장 정하기
 * 설명
 * 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
 * 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
 * 예를 들어 학생 수가 5명일 때의 표를 살펴보자.
 *
 * (이미지 생략)
 *
 * 위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
 * 2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
 * 같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
 * 이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
 * 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
 * 둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
 * 주어지는 정수는 모두 1 이상 9 이하의 정수이다.
 *
 * 출력
 * 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int studentCount = sc.nextInt();
        if (studentCount < 3 || studentCount > 1_000) {
            throw new IllegalArgumentException("학생수의 범위는 3 ~ 1,000 입니다.");
        }

        int[][] classInfoByGrade = new int[studentCount + 1][6];
        for (int i = 1; i <= studentCount; i++) {
            for (int j = 1; j <= 5; j++) {
                classInfoByGrade[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.solution(studentCount, classInfoByGrade));
    }

    private int solution(int studentCount, int[][] classInfoByGrade) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= studentCount; i++) {   // i 번 학생
            int cnt = 0;
            for (int j = 1; j <= studentCount; j++) {   // j 번 학생
                for (int k = 1; k <= 5; k++) {
                    if (classInfoByGrade[i][k] == classInfoByGrade[j][k]) {
                        cnt++;
                        break;  // 같은 반은 한번만 체크(단순 같은 반 횟수가 아닌 학생별 같은 반 이기 때문)
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    // failed..!
    private int solution2(int studentCount, int[][] classInfoByGrade) {
        int result = 0;
        int maxCountForSameClass = 0;

        Map<String, Integer> classMapByGrade = new HashMap<>();
        for (int i = 0; i < studentCount; i++) {
            for (int grade = 0; grade < 5; grade++) {
                int classNum = classInfoByGrade[i][grade];
                String key = (grade + 1) + "_" + classNum;
                classMapByGrade.put(key, classMapByGrade.getOrDefault(key, -1) + 1);
            }
        }

        for (int i = 0; i < studentCount; i++) {
            int sameCount = 0;
            for (int grade = 0; grade < 5; grade++) {
                String key = (grade + 1) + "_" + (classInfoByGrade[i][grade]);
                sameCount += classMapByGrade.get(key);
            }
            if (maxCountForSameClass < sameCount) {
                maxCountForSameClass = sameCount;
                result = i + 1;
            }
        }
        return result;
    }
}
