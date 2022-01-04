package com.wooklab.algorithm.inflearn.section1.ex2;

import java.util.Scanner;

/**
 * 2. 대소문자 변환
 * 설명
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 *
 * 예시 입력
 * StuDY
 *
 * 예시 출력
 * sTUdy
 */
public class Main {

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (isLowerCase(c)) {
                sb.append((char)(c + 32));
            } else if (isUpperCase(c)) {
                sb.append((char)(c - 32));
            } else {
                throw new IllegalArgumentException("알파뱃 문자열이 아닙니다.");
            }
        }
        return sb.toString();
    }

    private boolean isLowerCase(char c) {
        return 65 <= c && c <= 90;
    }

    private boolean isUpperCase(char c) {
        return 97 <= c && c <= 122;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(m.solution(str));
    }
}
