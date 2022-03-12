package com.wooklab.algorithm.inflearn.section5.ex1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * <pre>
 * 1. 올바른 괄호
 * 설명
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * 입력
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * 출력
 * 첫 번째 줄에 YES, NO를 출력한다.
 *
 * 예시 입력 1
 * (()(()))(()
 *
 * 예시 출력 1
 * NO
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(m.solution(input));
        System.out.println(m.mySolution(input));
    }

    private String solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (char x : input.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private String mySolution(String input) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (c == ')') {
                if (dq.isEmpty()) {
                    return "NO";
                }
                char headChar = dq.pop();
                if (headChar != '(') {
                    return "NO";
                }
            } else {
                dq.push(c);
            }
        }
        return dq.isEmpty() ? "YES" : "NO";
    }

}
