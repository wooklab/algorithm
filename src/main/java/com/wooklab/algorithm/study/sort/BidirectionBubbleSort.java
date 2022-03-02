package com.wooklab.algorithm.study.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BidirectionBubbleSort {

    // 9 1 3 4 6 7 8
    public static void main(String[] args) {
        BidirectionBubbleSort sort = new BidirectionBubbleSort();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] target = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sort.solution(target.length, target));
    }

    private String solution(int n, int[] a) {
        int leftCursor = 0;
        int rightCursor = n - 1;
        while (leftCursor < n - 1 && rightCursor > 0) {
            int leftLastSwappedIndex = n - 1;
            int rightLastSwappedIndex = 0;

            int remainedCount = rightCursor - leftCursor + 1;
            if (remainedCount % 2 == 0) {
                for (int i = 0; i < rightCursor; i++) {
                    if (a[i] > a[i + 1]) {
                        swap(a, i, i + 1);
                        rightLastSwappedIndex = i;
                    }
                }
                rightCursor = rightLastSwappedIndex;
            } else {
                for (int i = n - 1; i > leftCursor; i--) {
                    if (a[i - 1] > a[i]) {
                        swap(a, i - 1, i);
                        leftLastSwappedIndex = i;
                    }
                }
                leftCursor = leftLastSwappedIndex;
            }
        }
        return Arrays.stream(a)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(","));
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
