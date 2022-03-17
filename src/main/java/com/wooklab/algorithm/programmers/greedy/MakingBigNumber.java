package com.wooklab.algorithm.programmers.greedy;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class MakingBigNumber {

    public static void main(String[] args) {
        MakingBigNumber m = new MakingBigNumber();

        // 시간초과
//        System.out.println(m.solution("1924", 2));          // answer: "94"
//        System.out.println(m.solution("1231234", 3));       // answer: "3234"
//        System.out.println(m.solution("4177252841", 4));    // answer: "775841"

        System.out.println(m.solution2("1924", 2));          // answer: "94"
        System.out.println(m.solution2("1231234", 3));       // answer: "3234"
        System.out.println(m.solution2("4177252841", 4));    // answer: "775841"
        System.out.println(m.solution2("1", 1));    // answer: "775841"

    }

    public String solution(String number, int k) {
        int[] numbers = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        int answer = combine(numbers, new boolean[numbers.length], 0, 0, numbers.length - k);
        return String.valueOf(answer);
    }

    private int combine(int[] numbers, boolean[] visited, int startIndex, int depth, int maxDepth) {
        int maxNumber = 0;
        if (depth == maxDepth) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                if (visited[i]) {
                    sb.append(numbers[i]);
                }
            }
            return Integer.parseInt(sb.toString());
        } else {
            for (int i = startIndex; i < numbers.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    int returnedNumber = combine(numbers, visited, i + 1, depth + 1, maxDepth);
                    maxNumber = Math.max(maxNumber, returnedNumber);
                    visited[i] = false;
                }
            }
        }
        return maxNumber;
    }

    public String solution2(String number, int k) {
        if (number.length() == k) {
            return "0";
        }
        int length = number.length() - k;
        String targetNumber = number.substring(0, length);

        int cnt = 0;
        for (int i = length; i < number.length(); i++) {
            if (cnt == k) {
                break;
            }
            targetNumber = removeMinNumber(targetNumber) + number.charAt(i);
            cnt++;
        }
        return targetNumber;
    }

    private String removeMinNumber(String targetNumber) {
        int[] numbers = Arrays.stream(targetNumber.split("")).mapToInt(Integer::parseInt).toArray();
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < targetNumber.length(); i++) {
            if (minValue > numbers[i]) {
                minValue = numbers[i];
                minIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                sb.append(numbers[i]);
            }
        }
        return sb.toString();
    }

}
