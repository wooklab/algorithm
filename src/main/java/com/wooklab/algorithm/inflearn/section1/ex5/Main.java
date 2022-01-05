package com.wooklab.algorithm.inflearn.section1.ex5;

import java.util.Scanner;

/**
 * 5. 특정 문자 뒤집기
 * 설명
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 *
 * 예시 입력
 * a#b!GE*T@S
 *
 * 예시 출력
 * S#T!EG*b@a
 */
public class Main {

    public String solution(String word) {
        int left = 0;
        int right = word.length() - 1;
        char[] wordArray = word.toCharArray();

        while (left < right) {
            if (isNotAlphabet(wordArray[left])) {
                left++;
            } else if (isNotAlphabet(wordArray[right])) {
                right--;
            } else {
                swap(wordArray, left, right);
                left++;
                right--;
            }
        }
        return String.valueOf(wordArray);
    }

    private boolean isNotAlphabet(char c) {
        return !isAlphabet(c);
    }

    private boolean isAlphabet(char c) {
        return (65 <= c && c <= 90) || (97 <= c && c <= 122);
    }

    private void swap(char[] wordArray, int lt, int rt) {
        char temp = wordArray[lt];
        wordArray[lt] = wordArray[rt];
        wordArray[rt] = temp;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(m.solution(input));
    }
}
