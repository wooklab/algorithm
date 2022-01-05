package com.wooklab.algorithm.inflearn.section1.ex9;

import java.util.Scanner;

/**
 * 9. 숫자만 추출
 * 설명
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 *
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 *
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 *
 * 입력
 * 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 *
 * 출력
 * 첫 줄에 자연수를 출력합니다.
 *
 *
 * 예시 입력
 * g0en2T0s8eSoft
 *
 * 예시 출력
 * 208
 */
public class Main {

    public int solution(String word) {
        String numberStr = "";
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                numberStr += c;
            }
        }

        return Integer.parseInt(numberStr);
    }

    /*public int solution(String word) {
        int result = 0;
        for (char c : word.toCharArray()) {
            if (48 <= c && c <= 57) {   // ASCII 기준 48('0') ~ 57('9')
                result = result * 10 + (c - 48);    // 처음 발견된 문자가 숫자의 앞자리로 오기 때문에 10을 계속 곱해줘야 함.
                // 아스키코드 기준 48번이 0 번을 뜻하기 때문에 캐스팅 없이 -48을 하게되면 0이된다.
            }
        }
        return result;
    }*/

    /*public int solution(String word) {
        String numberStr = word.toUpperCase().replaceAll("[A-Z]", "");
        return Integer.parseInt(numberStr);
    }*/

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(m.solution(input));
    }
}
