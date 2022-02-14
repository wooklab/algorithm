package com.wooklab.algorithm.stduy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BubbleSort {

    // 8 3 4 1 7 6 5 2
    // 4 3 2 1 5 7 8 9
    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] target = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(s.solution6(target.length, target));
    }

    private String solution(int count, int[] numbers) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = count - 1; j > i; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    swap(numbers, j - 1, j);
                }
            }
        }
        return arrayToString(numbers);
    }

    private String solution2(int count, int[] numbers) {
        int cursor = count - 1;
        while (0 < cursor) {
            int lastSwappedIndex = 0;
            for (int i = 0; i < cursor; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    lastSwappedIndex = i;
                }
            }
            cursor = lastSwappedIndex;
        }
        return arrayToString(numbers);
    }

    // 우측, 오름
    private String solution3(int count, int[] numbers) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }
        return arrayToString(numbers);
    }

    // 좌측, 내림
    private String solution4(int n, int[] a) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] < a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
        return arrayToString(a);
    }

    // 우측부터 오름차순
    private String solution5(int n, int[] a) {
        int sortedIndex = n - 1;
        while (sortedIndex > 0) {
            int lastSwappedIndex = 0;
            for (int i = 0; i < sortedIndex; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    lastSwappedIndex = i;
                }
            }
            sortedIndex = lastSwappedIndex;
        }
        return arrayToString(a);
    }

    // 좌측부터 오름차순
    private String solution6(int n, int[] a) {
        int sortedIndex = 0;
        while (sortedIndex < n - 1) {
            int lastSwappedIndex = n - 1;
            for (int i = n - 1; i > sortedIndex; i--) {
                if (a[i - 1] > a[i]) {
                    swap(a, i - 1, i);
                    lastSwappedIndex = i;
                }
            }
            sortedIndex = lastSwappedIndex;
        }
        return arrayToString(a);
    }

    private String arrayToString(int[] v) {
        return Arrays.stream(v)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
