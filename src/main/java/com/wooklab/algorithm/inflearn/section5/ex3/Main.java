package com.wooklab.algorithm.inflearn.section5.ex3;

import java.util.Scanner;
import java.util.Stack;

/**
 * <pre>
 * 3. 크레인 인형뽑기 (카카오)
 *
 * 입력
 * 5
 * 0 0 0 0 0
 * 0 0 1 0 3
 * 0 2 5 0 1
 * 4 2 4 4 2
 * 3 5 1 3 1
 * 8
 * 1 5 3 5 1 2 1 4
 *
 * 출력
 * 4
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 5 || n > 30) {
            throw new IllegalArgumentException("n has range(5 <= n <= 30)");
        }
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int e = sc.nextInt();
                if (e < 0 || e > 100) {
                    throw new IllegalArgumentException("board has range(0 <= e <= 100)");
                }
                board[i][j] = e;
            }
        }
        int ms = sc.nextInt();
        if (ms < 1 || ms > 1_000) {
            throw new IllegalArgumentException("ms has range(1 <= ms <= 1_000");
        }
        int[] moves = new int[ms];
        for (int i = 0; i < ms; i++) {
            int e = sc.nextInt();
            if (e < 1 || e > ms) {
                throw new IllegalArgumentException("moves has range(1 <= e <= " + ms + ")");
            }
            moves[i] = e;
        }

        System.out.println(m.solution(board, moves));
//        System.out.println(m.mySolution(n, board, ms, moves));
    }

    private int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int row : moves) {
            for (int col = 0; col < board.length; col++) {
                if (board[col][row - 1] != 0) {
                    int currentVal = board[col][row - 1];
                    board[col][row - 1] = 0;
                    if (!stack.isEmpty() && currentVal == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(currentVal);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    private int mySolution(int boardSize, int[][] board, int moveSize, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int n = 0; n < moveSize; n++) {
            int row = moves[n] - 1;
            for (int col = 0; col < boardSize; col++) {
                int currentNumber = board[col][row];
                if (currentNumber != 0) {
                    if (bucket.isEmpty()) {
                        bucket.push(currentNumber);
                    } else {
                        if (currentNumber == bucket.peek()) {
                            bucket.pop();
                            answer += 2;
                        } else {
                            bucket.push(currentNumber);
                        }
                    }
                    board[col][row] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
