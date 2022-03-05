package com.wooklab.algorithm.codingtest;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.solution(1000));
    }

    private int solution(int A) {
        int sum = calculateSum(A);
        int nexSameSum = 0;
        while (sum != nexSameSum) {
            nexSameSum = calculateSum(++A);
        }
        return A;
    }

    private int calculateSum(int number) {
        char[] numbersAsChar = String.valueOf(number).toCharArray();
        int sum = 0;
        for (char c : numbersAsChar) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

}
