package com.wooklab.algorithm.codingtest;

import java.util.ArrayList;
import java.util.List;

public class NSolution2 {

    public static void main(String[] args) {
        NSolution2 m = new NSolution2();
        /*int[] A = {1, 3, 2, 4};
        int[] B = {4, 1, 3, 2};*/
        /*int[] A = {1, 2, 3, 4};
        int[] B = {2, 1, 4, 3};*/
        /*int[] A = {1, 2, 1};
        int[] B = {2, 3, 3};*/
        /*int[] A = {1, 2, 3, 4};
        int[] B = {2, 1, 4, 4};*/
        int[] A = {1, 2, 2, 3, 3};
        int[] B = {2, 3, 3, 4, 5};

        System.out.println(m.solution(A, B));
    }

    static class Pair {

        private int current;
        private int next;
        private Pair nextNode;

        public Pair(int current, int next) {
            this.current = current;
            this.next = next;
            this.nextNode = null;
        }

        public void addNode(Pair pair) {
            this.nextNode = pair;
        }

        public int getCurrent() {
            return current;
        }

        public int getNext() {
            return next;
        }

        public Pair getNextNode() {
            return nextNode;
        }

        public int cycleSize() {
            if (nextNode == null) {
                return 0;
            }
            Pair tempPair = this;
            int cnt = 0;
            while (tempPair != null && nextNode != null) {
                tempPair = tempPair.getNextNode();
                cnt++;
                if (tempPair == this) {
                    return cnt;
                }
                if (tempPair != null && tempPair == tempPair.getNextNode()) {
                    return -1;
                }
            }
            return -1;
        }
    }

    private boolean solution(int[] A, int[] B) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            pairs.add(new Pair(A[i], B[i]));
        }

        for (Pair p1 : pairs) {
            for (Pair p2 : pairs) {
                if (p1.getNext() == p2.getCurrent()) {
                    p1.addNode(p2);
                }
            }
        }
        Integer result = pairs.stream().map(Pair::cycleSize).max(Integer::compare).get();
        return result > 2;
    }
}
