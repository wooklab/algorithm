package com.wooklab.algorithm.inflearn.section4.ex5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * 5. K번째 큰 수
 * 설명
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 *
 * 출력
 * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 *
 * 예시 입력 1
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 *
 * 예시 출력 1
 * 143
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(m.solution(size, k, numbers));
//        System.out.println(m.mySolution(size, k, numbers));
    }

    private int solution(int size, int k, int[] numbers) {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int l = j + 1; l < size; l++) {
                    set.add(numbers[i] + numbers[j] + numbers[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : set) {
            cnt++;
            if (cnt == k) {
                return x;
            }
            if (cnt > k) {
                break;
            }
        }
        return -1;
    }

    // failed... 시간초과
    private int mySolution(int size, int k, int[] numbers) {
        Set<Integer> sumSet = new TreeSet<>(Comparator.reverseOrder());

        getCombination(numbers, k, new boolean[size], sumSet, 0);

        if (sumSet.size() < k) {
            return -1;
        }

        return new ArrayList<>(sumSet).get(k - 1);
    }

    private void getCombination(int[] numbers, int k, boolean[] filter, Set<Integer> sumSet, int depth) {
        if (depth == k) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (filter[i]) {
                    sum += numbers[i];
                    cnt++;
                }
                if (cnt == k) {
                    break;
                }
            }
            sumSet.add(sum);
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (!filter[i]) {
                    filter[i] = true;
                    getCombination(numbers, k, filter, sumSet, depth + 1);
                    filter[i] = false;
                }
            }
        }
    }
}
