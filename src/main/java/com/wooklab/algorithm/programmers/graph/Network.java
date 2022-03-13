package com.wooklab.algorithm.programmers.graph;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Network {

    public static void main(String[] args) {
        Network m = new Network();
        int[][] computer1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int[][] computer2 = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println(m.solution(computer1[0].length, computer1));
        System.out.println(m.solution(computer2[0].length, computer2));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
//                dfsWithStack(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, boolean[] visited, int pos) {
        visited[pos] = true;
        for (int i = 0; i < computers[pos].length; i++) {
            if (!visited[i] && computers[pos][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }

    private void dfsWithStack(int[][] computers, boolean[] visited, int pos) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pos);

        while (!stack.isEmpty()) {
            int currentPos = stack.pop();
            if (!visited[currentPos]) {
                visited[currentPos] = true;
                for (int i = 0; i < computers[currentPos].length; i++) {
                    if (!visited[i] && computers[currentPos][i] == 1) {
                        stack.push(i);
                    }
                }
            }
        }
    }

}
