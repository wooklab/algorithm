package com.wooklab.algorithm.stduy.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] target = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(s.solution(target.length, target));
    }

    private String solution(int count, int[] numbers) {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (numbers[min] > numbers[j]) {
                    min = j;
                }
            }
            swap(numbers, i, min);
        }
        return Arrays.stream(numbers)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(", "));
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
