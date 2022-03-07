package com.wooklab.algorithm.codingtest;

public class NSolution3 {

    public static void main(String[] args) {
        NSolution3 m = new NSolution3();

        int[] a = {4, 9, 8, 2, 6};
        int k = 3;
        /*int[] a = {5, 6, 3, 4, 2};
        int k = 5;*/
        /*int[] a = {7, 7, 7, 7, 7};
        int k = 1;*/
        /*int[] a = {10000};
        int k = 2;*/
        /*int[] a = {2, 3, 3, 5, 5};
        int k = 3;*/

        System.out.println(m.solution(a, k));

    }

    private int solution(int[] A, int K) {
        boolean[] visited = new boolean[A.length];
        int answer = comb(A, visited, 0, K);
        return answer < 0 ? -1 : answer;
    }

    private int comb(int[] a, boolean[] visited, int start, int k) {
        if (k == 0) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                if (visited[i]) {
                    System.out.print(a[i] + " ");
                    sum += a[i];
                }
            }
            System.out.println();
            return sum;
        } else {
            int max = 0;
            for (int i = start; i < a.length; i++) {
                visited[i] = true;
                int result = comb(a, visited, i + 1, k - 1);
                System.out.println(k + ":" + result);
                if (result % 2 == 0) {
                    max = Math.max(result, max);
                }
                visited[i] = false;
            }
            return max;
        }
    }
}
