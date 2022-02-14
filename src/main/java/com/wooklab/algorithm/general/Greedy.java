package com.wooklab.algorithm.general;

import java.util.Arrays;

public class Greedy {

    public static void main(String[] args) {
        Greedy instance = new Greedy();
        instance.solution();
    }

    public void solution() {
        int[][] activity = {
            {7, 9, 11}, {8, 11, 14}, {1, 1, 3}, {9, 13, 16},
            {4, 1, 8}, {2, 2, 5}, {3, 4, 7}, {5, 5, 9}, {6, 8, 10}
        };

        for (int i = 0; i < activity.length; i++) {
            for (int j = i + 1; j < activity.length; j++) {
                if (activity[i][2] > activity[j][2]) {
                    int[] temp = activity[i];
                    activity[i] = activity[j];
                    activity[j] = temp;
                }
            }
        }
        System.out.println("정렬결과: ");
        Arrays.stream(activity).forEach(a -> System.out.println(a[0] + "," + a[1] + "," + a[2]));

        int[] result = new int[10];
        int pos = 0;
        int last = 0;
        for (int[] item : activity) {
            if (last < item[1]) {
                last = item[2];
                result[pos++] = item[0];
            }
        }

        System.out.println("<최대 범위 결과>");
        Arrays.stream(result)
            .filter(v -> v != 0)
            .forEach(v -> {
                for (int[] item : activity) {
                    if (v == item[0]) {
                        System.out.println(v + ":" + item[1] + "~" + item[2]);
                    }
                }
            });
    }

}
