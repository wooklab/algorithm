package com.wooklab.algorithm.inflearn.section5.ex2;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <pre>
 * 2. 괄호문자제거
 * 설명
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 남은 문자만 출력한다.
 *
 * 예시 입력 1
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 *
 * 예시 출력 1
 * EFLM
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
        System.out.println(m.mySolution(str));
    }

    private String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') {
                }
            } else {
                stack.push(x);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private String mySolution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    answer.append(x);
                }
            }
        }
        return answer.toString();
    }


}
