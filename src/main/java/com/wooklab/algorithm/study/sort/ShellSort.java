package com.wooklab.algorithm.study.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShellSort {

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sort.solution(n, a));
    }

    private String solution(int n, int[] a) {
        for (int h = n / 2; h > 0; h = h / 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j = j - h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
        return Arrays.stream(a)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(","));
    }
}
