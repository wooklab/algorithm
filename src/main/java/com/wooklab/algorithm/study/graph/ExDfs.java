package com.wooklab.algorithm.study.graph;

import java.util.Scanner;

/**
 * '0' 영역 개수 구하기
 */
public class ExDfs {

    /*
    3 3
    0 0 1
    0 1 0
    1 0 1
     */
    public static void main(String[] args) {
        ExDfs m = new ExDfs();
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] graph = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.solution(graph));
    }

    private int solution(int[][] graph) {
        int result = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (dfs(graph, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean dfs(int[][] graph, int x, int y) {
        if (x <= -1 || x >= graph.length || y <= -1 || y >= graph[0].length) {
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;

            dfs(graph, x - 1, y);
            dfs(graph, x, y + 1);
            dfs(graph, x + 1, y);
            dfs(graph, x, y - 1);
            return true;
        }
        return false;
    }

}
