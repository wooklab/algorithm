package com.wooklab.algorithm.inflearn.section1.ex8;

import java.util.Scanner;

/**
 * 8. 유효한 팰린드롬
 * 설명
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 *
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 *
 * 알파벳 이외의 문자들의 무시합니다.
 *
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 *
 *
 * 예시 입력
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * 예시 출력
 * YES
 */
public class Main {

    public String solution(String word) {
        word = word.toUpperCase().replaceAll("[^A-Z]", ""); // 대괄호 안의 '^' 부정
        if (word.equals(new StringBuilder(word).reverse().toString())) {
            return "YES";
        }
        return "NO";
    }

    /*public String solution(String word) {
        StringBuilder alphabetStr = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                alphabetStr.append(c);
            }
        }
        if (alphabetStr.toString().equalsIgnoreCase(alphabetStr.reverse().toString())) {
            return "YES";
        }
        return "NO";
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(m.solution(input));
    }
}
