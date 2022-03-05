package com.wooklab.algorithm.codingtest;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int[] a = new int[]{1, 1, 2, 3, 4};
        int k = 3;
        System.out.println(s.solution(a, k));
    }

    private boolean solution(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        if (a[0] != 1 || a[n - 1] != k) {
            return false;
        } else {
            return true;
        }
    }
}
