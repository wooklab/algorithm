package com.wooklab.algorithm.codingtest;

public class NSolution1 {

    public static void main(String[] args) {
        NSolution1 m = new NSolution1();
        System.out.println(m.solution(6, 1, 1));
        System.out.println(m.solution(1, 3, 1));
        System.out.println(m.solution(0, 1, 8));
    }

    private String solution(int A, int B, int C) {
        int posA = 0;
        int posB = 0;
        int posC = 0;
        int dupA = 0;
        int dupB = 0;
        int dupC = 0;
        String answer = "";

        StringBuilder sb = new StringBuilder();
        while (posA != A || posA != B || posC != C) {
            if (posA != A && dupA != 2) {
                sb.append("a");
                posA++;
                dupA++;
                dupB = dupC = 0;
            } else if (posB != B && dupB != 2) {
                sb.append("b");
                posB++;
                dupB++;
                dupA = dupC = 0;
            } else if (posC != C && dupC != 2) {
                sb.append("c");
                posC++;
                dupC++;
                dupA = dupB = 0;
            }
            if (answer.equals(sb.toString())) {
                break;
            }
            answer = sb.toString();
        }

        return answer;
    }

}
