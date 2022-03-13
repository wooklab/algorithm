package com.wooklab.algorithm.programmers.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class TargetNumber {

    public static void main(String[] args) {
        TargetNumber m = new TargetNumber();

        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        System.out.println(m.solutionWithBFS(numbers1, target1));
        System.out.println(m.solutionWithBFS(numbers2, target2));
        System.out.println(m.solutionWithDFS(numbers1, target1));
        System.out.println(m.solutionWithDFS(numbers2, target2));
    }

    private int solutionWithDFS(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        int result = 0;
        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        } else {
            result += dfs(numbers, target, depth + 1, sum + numbers[depth]);
            result += dfs(numbers, target, depth + 1, sum - numbers[depth]);
            return result;
        }
    }

    private int solutionWithBFS(int[] numbers, int target) {
        int answer = 0;
        List<Integer> results = new ArrayList<>();
        results.add(0);

        for (int currentValue : numbers) {
            List<Integer> appendResults = new ArrayList<>();
            for (Integer preValue : results) {
                appendResults.add(preValue + currentValue);
                appendResults.add(preValue - currentValue);
            }
            results = appendResults;
        }

        for (int num : results) {
            if (num == target) {
                answer++;
            }
        }
        return answer;
    }
}
