package com.wooklab.algorithm.programmers.greedy;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class GymSuit {

    public static void main(String[] args) {
        GymSuit m = new GymSuit();
        System.out.println(m.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // answer: 5
        System.out.println(m.solution(5, new int[]{2, 4}, new int[]{3})); // answer: 4
        System.out.println(m.solution(3, new int[]{3}, new int[]{1})); // answer: 2
        System.out.println(m.solution(5, new int[]{2, 4}, new int[]{2, 4})); // answer: 5

        System.out.println(m.solution2(5, new int[]{2, 4}, new int[]{1, 3, 5})); // answer: 5
        System.out.println(m.solution2(5, new int[]{2, 4}, new int[]{3})); // answer: 4
        System.out.println(m.solution2(3, new int[]{3}, new int[]{1})); // answer: 2
        System.out.println(m.solution2(5, new int[]{2, 4}, new int[]{2, 4})); // answer: 5
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int defeatStudentCounts = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] lostFilter = new boolean[lost.length];
        boolean[] reserveFilter = new boolean[reserve.length];

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (!reserveFilter[j] && lost[i] == reserve[j]) {
                    lostFilter[i] = true;
                    reserveFilter[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lostFilter[i]) {
                continue;
            }
            int getCount = 0;
            for (int j = 0; j < reserve.length; j++) {
                if (!reserveFilter[j] && (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1)) {
                    reserveFilter[j] = true;
                    getCount++;
                    break;
                }
            }
            if (getCount == 0) {
                defeatStudentCounts++;
            }
        }
        return n - defeatStudentCounts;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--;
        }
        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                if (i - 1 >= 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                } else if (i + 1 < people.length && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}
