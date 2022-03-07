package com.wooklab.algorithm.inflearn.section6.ex4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * LRU(Least Recently Used) Cache 구현
 * <pre>
 * 입력
 * 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
 * 두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
 *
 * 출력
 * 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
 *
 * 예시 입력 1
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 *
 * 예시 출력 1
 * 7 5 3 2 6
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int inputSize = sc.nextInt();
        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(m.solution(cacheSize, input));
//        System.out.println(m.mySolution(cacheSize, input));
    }

    private String solution(int cacheSize, int[] input) {
        int[] cache = new int[cacheSize];
        for (int x : input) {
            int pos = -1;
            for (int i = 0; i < cacheSize; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = cacheSize - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return Arrays.stream(cache).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    // runtime error, 배열로 풀어볼 것..!
    private String mySolution(int cacheSize, int[] input) {
        int usedSize = 0;
        List<Integer> cache = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            int x = input[i];
            if (cache.contains(x)) {
                cache.remove(x);
                cache.add(0, x);
            } else if (usedSize < cacheSize) {
                cache.add(0, x);
                usedSize++;
            } else {
                cache.remove(cacheSize - 1);
                cache.add(0, x);
            }
        }

        return cache.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
