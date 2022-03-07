package com.wooklab.algorithm.study.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        BreadthFirstSearch m = new BreadthFirstSearch();
        int[][] graph = {
            {},
            {2, 3, 8},   // 1번 노드와 인접한 노드
            {1, 7},      // 2번 노드와 인접한 노드
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}       // 8번 노드와 인접한 노드
        };
        boolean[] visited = new boolean[graph.length + 1];
        System.out.print("큐: ");
        m.bfsWithQueue(visited, graph);
        System.out.println();
        System.out.print("재귀: ");
        m.bfsWithRecursive(new boolean[graph.length + 1], graph, 1);
    }

    private void bfsWithQueue(boolean[] visited, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < graph[x].length; i++) {
                int y = graph[x][i];
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    private void bfsWithRecursive(boolean[] visited, int[][] graph, int x) {
        // TODO: incorrect..!
        visited[x] = true;
        System.out.print(x + " ");
        for (int i = 0; i < graph[x].length; i++) {
            int y = graph[x][i];
            if (!visited[y]) {
                bfsWithRecursive(visited, graph, y);
            }
        }
    }
}
