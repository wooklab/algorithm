package com.wooklab.algorithm.codingtest;

// unsolved..
public class KBSolution3 {

    public static void main(String[] args) {
        KBSolution3 m = new KBSolution3();
        boolean[] result = m.solution(new String[][]{
            {".....", ".XXX.", ".X.X.", ".XXX.", "....."},
            {"XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"},
            {"XXXXX", "X...X", "X.X.X", "X...X", "XXXXX"},
            {"....X", ".....", "XXX..", "X.X..", "XXX.."},
            {".......", "XXX.XXX", "X.X.X.X", "XXX.XXX", "......."},
            {"XXXXX", "XX.XX", "X...X", "XX.XX", "XXXXX"}});
        for (boolean x : result) {
            System.out.println(x);
        }
    }

    public boolean[] solution(String[][] grids) {
        boolean[] answer = new boolean[grids.length];
        for (int i = 0; i < grids.length; i++) {
            answer[i] = checkSquare(grids[i]);
        }
        return answer;
    }

    private boolean checkSquare(String[] grid) {
//        Character[][] arr = new Character[grid.length][grid[0].length()];
//        for (int x = 0; x < grid.length; x++) {
//            for (int y = 0; y < grid[0].length(); y++) {
//                arr[x][y] = grid[x].charAt(y);
//            }
//        }
        return false;
    }
}
