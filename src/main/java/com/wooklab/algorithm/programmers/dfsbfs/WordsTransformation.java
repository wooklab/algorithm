package com.wooklab.algorithm.programmers.dfsbfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class WordsTransformation {

    public static void main(String[] args) {
        WordsTransformation m = new WordsTransformation();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(m.solution(begin, target, words));
        System.out.println(m.solution(begin, target, words2));
        System.out.println(m.solutionWithDfs(begin, target, words));
        System.out.println(m.solutionWithDfs(begin, target, words2));
    }

    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        Map<String, Integer> levelMap = new HashMap<>();
        queue.add(begin);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            if (currentWord.equals(target)) {
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && checkDiff(currentWord, words[i])) {
                    visited[i] = true;
                    queue.add(words[i]);
                    levelMap.put(words[i], levelMap.getOrDefault(currentWord, 0) + 1);
                }
            }
        }

        return levelMap.getOrDefault(target, 0);
    }

    private boolean checkDiff(String currentWord, String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (currentWord.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int solutionWithDfs(String begin, String target, String[] words) {
        int result = dfs(begin, target, words, new boolean[words.length]);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int dfs(String begin, String target, String[] words, boolean[] visited) {
        if (begin.equals(target)) {
            int step = 0;
            for (boolean v : visited) {
                if (v) {
                    step++;
                }
            }
            return step;
        } else {
            int step = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int diffCount = 0;
                    for (int j = 0; j < begin.length(); j++) {
                        if (begin.charAt(j) != words[i].charAt(j)) {
                            diffCount++;
                        }
                    }
                    if (diffCount == 1) {
                        visited[i] = true;
                        int temp = dfs(words[i], target, words, visited);
                        visited[i] = false;
                        step = Math.min(step, temp);
                    }
                }
            }
            return step;
        }
    }
}
