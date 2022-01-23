package com.wooklab.algorithm.inflearn.section1.ex10;

import java.util.Scanner;

/**
 * 11. 문자열 압축
 * 설명
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 * <p>
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * <p>
 * 출력
 * 첫 줄에 압축된 문자열을 출력한다.
 * <p>
 * 예시 입력 1
 * KKHSSSSSSSE
 * 예시 출력 1
 * K2HS7E
 * 예시 입력 2
 * KSTTTSEEKFKKKDJJGG
 * 예시 출력 2
 * KST3SE2KFK3DJ2G2
 */
public class Main {

    public String solution(String word) {
        String answer = "";
        word += " ";
        int cnt = 1;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                cnt++;
            } else {
                answer += word.charAt(i);
                if (cnt > 1) {
                    answer += cnt;
                    cnt = 1;
                }
            }
        }
        return answer;
    }

    /*public String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char dupChar = ' ';
        int dupCharCount = 1;
        for (int i = 0; i < word.length(); i++) {
            if (dupChar == word.charAt(i)) {
                dupCharCount++;
            } else {
                if (dupCharCount > 1) {
                    sb.append(dupCharCount);
                    dupCharCount = 1;
                }
                sb.append(word.charAt(i));
                dupChar = word.charAt(i);
            }
        }
        if (dupCharCount > 1) {
            sb.append(dupCharCount);
        }

        return sb.toString();
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(m.solution(input));
    }
}
