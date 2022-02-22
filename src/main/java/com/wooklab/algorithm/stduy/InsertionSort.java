package com.wooklab.algorithm.stduy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] target = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(s.solution2(target.length, target));
    }

    private String solution(int count, int[] numbers) {
        for (int i = 1; i < count; i++) {
            int tmp = numbers[i];
            int j;
            for (j = i; j > 0 && tmp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = tmp;
        }
        return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

    private String solution2(int n, int[] a) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int c = i;
            while (c > 0 && tmp < a[c - 1]) {
                a[c] = a[c - 1];
                c--;
            }
            a[c] = tmp;
        }
        return Arrays.stream(a)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(", "));
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
