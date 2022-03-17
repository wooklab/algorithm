package com.wooklab.algorithm.programmers.greedy;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class MakingBigNumber {

    public static void main(String[] args) {
        MakingBigNumber m = new MakingBigNumber();

        System.out.println(m.solution("1924", 2));          // answer: "94"
        System.out.println(m.solution("1231234", 3));       // answer: "3234"
        System.out.println(m.solution("4177252841", 4));    // answer: "775841"
        System.out.println(m.solution("1", 1));    // answer: ""
        System.out.println(m.solution("111112", 4));    // answer: "12"
        System.out.println(m.solution("333111333", 3));    // answer: "3333333"

        System.out.println("==");
        System.out.println(m.solution2("1924", 2));          // answer: "94"
        System.out.println(m.solution2("1231234", 3));       // answer: "3234"
        System.out.println(m.solution2("4177252841", 4));    // answer: "775841"
        System.out.println(m.solution2("1", 1));    // answer: ""
        System.out.println(m.solution2("111112", 4));    // answer: "12"
        System.out.println(m.solution2("333111333", 3));    // answer: "3333333"
    }


    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int startIndex = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = startIndex; j <= k + i; j++) {
                int current = number.charAt(j) - '0';
                if (max < current) {
                    max = current;
                    startIndex = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

    // 베스트 솔루션
    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
