package com.wooklab.algorithm.stduy;

import java.util.Arrays;
import java.util.Scanner;

public class BidirectionBubbleSort {

    public static void main(String[] args) {
        BidirectionBubbleSort sort = new BidirectionBubbleSort();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] target = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sort.solution(target.length, target));
    }

    private String solution(int length, int[] target) {
        return "";
    }
}
