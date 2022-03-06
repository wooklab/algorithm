package com.wooklab.algorithm.study.graph;

import java.util.Stack;

/**
 * <pre>
 * 8
 * 2 3 8
 * 1 7
 * 1 4 5
 * 3 5
 * 3 4
 * 7
 * 2 6 8
 * 1 7
 * </pre>
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        DepthFirstSearch m = new DepthFirstSearch();
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
        m.solution(visited, graph);
    }

    private void solution(boolean[] visited, int[][] graph) {
        System.out.print("재귀: ");
        dfsWithRecursive(visited, 1, graph);
        System.out.println();
        System.out.print("스택: ");
        dfsWithStack(new boolean[graph.length + 1], graph);
    }

    private void dfsWithRecursive(boolean[] visited, int x, int[][] graph) {
        visited[x] = true;
        System.out.print(x + " ");
        for (int i = 0; i < graph[x].length; i++) {
            int y = graph[x][i];
            if (!visited[y]) {
                dfsWithRecursive(visited, y, graph);
            }
        }
    }

    private void dfsWithStack(boolean[] visited, int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (!visited[x]) {
                System.out.print(x + " ");
                visited[x] = true;
                for (int i = graph[x].length - 1; i >= 0; i--) {
                    int y = graph[x][i];
                    if (!visited[y]) {
                        stack.push(y);
                    }
                }
            }
        }
    }
}
