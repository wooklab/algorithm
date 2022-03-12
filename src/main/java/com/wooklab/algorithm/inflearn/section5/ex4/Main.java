package com.wooklab.algorithm.inflearn.section5.ex4;

import java.util.Scanner;
import java.util.Stack;

/**
 * <pre>
 * 4. 후위식 연산(postfix)
 * 설명
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 * 출력
 * 연산한 결과를 출력합니다.
 *
 * 예시 입력 1
 * 352+*9-
 *
 * 예시 출력 1
 * 12
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

    private int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48); // '0'의 ascii number = 48
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == '*') {
                    stack.push(lt * rt);
                } else if (x == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        return stack.get(0);
    }

    private int mySolution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int y = stack.pop();
                int x = stack.pop();
                int result = calculate(x, y, c);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private int calculate(int x, int y, char c) {
        switch (c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                throw new IllegalArgumentException("Invalid char(" + c + ")");
        }
    }

}
