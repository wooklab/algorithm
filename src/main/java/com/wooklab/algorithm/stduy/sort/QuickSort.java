package com.wooklab.algorithm.stduy.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sort.solution(n, a));
    }

    private String solution(int n, int[] a) {
        quicksort(a, 0, n - 1);
        return arrayToString(a);
    }

    private void quicksort(int[] a, int left, int right) {
        int leftCursor = left;
        int rightCursor = right;
        int pivot = a[(left + right) / 2];

        do {
            while (a[leftCursor] < pivot) {
                leftCursor++;
            }
            while (a[rightCursor] > pivot) {
                rightCursor--;
            }
            if (leftCursor <= rightCursor) {
                swap(a, leftCursor++, rightCursor--);
            }
        } while (leftCursor <= rightCursor);

        if (left < rightCursor) {
            quicksort(a, left, rightCursor);
        }
        if (leftCursor < right) {
            quicksort(a, leftCursor, right);
        }
    }

    private void swap(int[] a, int pl, int pr) {
        String asis = arrayToString(a, pl, pr);
        int temp = a[pl];
        a[pl] = a[pr];
        a[pr] = temp;
        String tobe = arrayToString(a, pl, pr);
        System.out.println(asis + " => " + tobe);
    }

    private String arrayToString(int[] a, int... index) {
        if (index.length == 0) {
            return arrayToString(a, Collections.emptySet());
        }
        return arrayToString(a, Arrays.stream(index)
                                      .map(idx -> a[idx])
                                      .boxed()
                                      .collect(Collectors.toSet()));
    }

    private String arrayToString(int[] a, Set<Integer> changedNumberSet) {
        return Arrays.stream(a)
                     .mapToObj(x -> {
                         if (changedNumberSet.contains(x)) {
                             return "*" + x;
                         }
                         return String.valueOf(x);
                     })
                     .collect(Collectors.joining(", "));
    }
}
