package com.wooklab.algorithm.programmers.greedy;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Joystick {

    public static void main(String[] args) {
        Joystick m = new Joystick();

        // failed
        System.out.println(m.solution("JEROEN"));   // answer 56
        System.out.println(m.solution("JAN"));   // answer 23
        System.out.println(m.solution("BAAABB"));   // answer 23

        // success
        System.out.println(m.solution2("JEROEN"));   // answer 56
        System.out.println(m.solution2("JAN"));   // answer 23
        System.out.println(m.solution2("BAAABB"));   // answer 23
    }

    // A = 65 / Z = 90 (차 25 / 2 = 12 + 1 = 13)
    // 12(77/78)
    // 13(78/77)
    // x - A > 13 ? Z - x + 1 : x - A
    // 모든 테스트 케이스를 통과하지 못함
    public int solution(String name) {
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            int c = name.charAt(i);
            answer += Math.min(c - 65, 90 - c + 1);
        }

        int forwardPos = 0;
        int backwardPos = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                forwardPos = i;
            }
        }
        for (int i = name.length() - 1; i > 0; i--) {
            if (name.charAt(i) != 'A') {
                backwardPos = i;
            }
        }
        backwardPos = name.length() - backwardPos;
        answer += Math.min(forwardPos, backwardPos);
        return answer;
    }

    public int solution2(String name) {
        int answer = 0;
        int move = name.length();

        for (int i = 0; i < name.length(); i++) {
            int c = name.charAt(i);
            answer += Math.min(c - 65, 90 - c + 1);

            int index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, i * 2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
        }

        return answer + move;
    }
}
