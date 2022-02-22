package com.wooklab.algorithm.stduy.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeSort {
    private int[] buff;

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sort.solution(n, a));
    }

    private String solution(int n, int[] a) {
        buff = new int[n];
        mergeSort(a, 0, n - 1);
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    private void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            int bufferIndex = 0;
            int rightIndex;
            int leftIndex = 0;
            int cursor = left;

            mergeSort(a, left, center);
            mergeSort(a, center + 1, right);

            for (rightIndex = left; rightIndex <= center; rightIndex++) {
                buff[bufferIndex++] = a[rightIndex];   // center 중심으로 왼쪽 배열 복사
            }

            while (rightIndex <= right && leftIndex < bufferIndex) {
                a[cursor++] = (buff[leftIndex] <= a[rightIndex]) ? buff[leftIndex++] : a[rightIndex++]; // 작은 수를 순서대로 병합
            }

            while (leftIndex < bufferIndex) {
                a[cursor++] = buff[leftIndex++];
            }
        }
    }
}
