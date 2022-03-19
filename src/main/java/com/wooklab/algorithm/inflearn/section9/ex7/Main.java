package com.wooklab.algorithm.inflearn.section9.ex7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 9-7. 원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용)
 */
public class Main {

    /*
    입력
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
     */
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int maxNode = sc.nextInt();
        int lineCount = sc.nextInt();
        int[][] arr = new int[lineCount][3];
        for (int i = 0; i < lineCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        System.out.println(m.solution(maxNode, arr));
    }

    private int solution(int nodeCount, int[][] arr) {
        int answer = 0;
        int[] vertexSet = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            vertexSet[i] = i;
        }

        List<Edge> vertexList = new ArrayList<>();
        for (int[] x : arr) {
            vertexList.add(new Edge(x[0], x[1], x[2]));
        }
        Collections.sort(vertexList);

        int route = 0;
        for (Edge edge : vertexList) {
            int findVtx1 = find(vertexSet, edge.vertex1);
            int findVtx2 = find(vertexSet, edge.vertex2);
            if (findVtx1 != findVtx2) {
                answer += edge.cost;
                union(vertexSet, edge.vertex1, edge.vertex2);
                route++;
            }
            if (route == nodeCount - 1) {
                break;
            }
        }

        return answer;
    }

    private void union(int[] vertexSet, int v1, int v2) {
        int fa = find(vertexSet, v1);
        int fb = find(vertexSet, v2);
        if (fa != fb) {
            vertexSet[fa] = fb;
        }
    }

    private int find(int[] vertexSet, int v) {
        if (v == vertexSet[v]) {
            return vertexSet[v];
        } else {
            vertexSet[v] = find(vertexSet, vertexSet[v]);
            return vertexSet[v];
        }
    }

    static class Edge implements Comparable<Edge> {

        private final int vertex1;
        private final int vertex2;
        private final int cost;

        public Edge(int vertex1, int vertex2, int cost) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}
