package com.wooklab.algorithm.programmers.greedy;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Boat {

    public static void main(String[] args) {
        Boat m = new Boat();

        System.out.println(m.solution(new int[]{70, 50, 80, 50}, 100)); // answer: 3
        System.out.println(m.solution(new int[]{70, 80, 50}, 100));     // answer: 3
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        boolean[] check = new boolean[people.length];
        int startPos = 0;
        int endPos = people.length - 1;
        int checkCount = 0;
        while (checkCount < check.length) {
            while (startPos < people.length - 1 && check[startPos]) {
                startPos++;
            }
            int x = people[startPos];
            check[startPos] = true;
            checkCount++;

            while (endPos > startPos && (check[endPos] || (!check[endPos] && x + people[endPos] > limit))) {
                endPos--;
            }

            if (startPos < endPos) {
                check[endPos] = true;
                checkCount++;
            }
            answer++;
        }
        return answer;
    }
}
