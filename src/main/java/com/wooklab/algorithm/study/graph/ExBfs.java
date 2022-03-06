package com.wooklab.algorithm.study.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ExBfs {

    /*
5 6
1 0 1 0 1 0
1 1 1 1 1 1
0 0 0 0 0 1
1 1 1 1 1 1
1 1 1 1 1 1

    시작점은 (0,0)
    최단거리 구하기
     */
    public static void main(String[] args) {
        ExBfs m = new ExBfs();
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
        System.out.println("시작");
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        return bfs(graph, 0, 0, dx, dy);
    }

    class Node {

        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

    private int bfs(int[][] graph, int x, int y, int[] dx, int[] dy) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) {
                    continue;
                }
                if (graph[nx][ny] == 0) {
                    continue;
                }
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return graph[graph.length - 1][graph[0].length - 1];
    }

}
