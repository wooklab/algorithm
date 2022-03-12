package com.wooklab.algorithm.programmers.graph;

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

}
