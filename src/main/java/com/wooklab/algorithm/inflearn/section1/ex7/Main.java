package com.wooklab.algorithm.inflearn.section1.ex7;

import java.util.Scanner;

/**
 * 7. 회문 문자열
 * 설명
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 *
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 *
 * 예시 입력
 * gooG
 *
 * 예시 출력
 * YES
 */
public class Main {

    public String solution(String word) {
        if (word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())) {
            return "YES";
        }
        return "NO";
    }

    /*public String solution(String word) {
        String str = word.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }*/

    /*public String solution(String word) {
        char[] wordArray = word.toCharArray();
        int left = 0;
        int right = wordArray.length - 1;

        while (left < right) {
            if (Character.toLowerCase(wordArray[left]) != Character.toLowerCase(wordArray[right])) {
                return "NO";
            }
            left++;
            right--;
        }
        return "YES";
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(m.solution(input));
    }
}
