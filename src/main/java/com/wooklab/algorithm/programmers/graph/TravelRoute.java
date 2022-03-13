package com.wooklab.algorithm.programmers.graph;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class TravelRoute {

    public static void main(String[] args) {
        TravelRoute m = new TravelRoute();
        String[][] ticket = {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
        };
        String[][] ticket2 = {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL", "SFO"}};
        String[] result = m.solution(ticket);
        System.out.println(Arrays.stream(result).collect(Collectors.joining(",")));
        String[] result2 = m.solution(ticket2);
        System.out.println(Arrays.stream(result2).collect(Collectors.joining(",")));
    }

    public String[] solution(String[][] ticket) {
        String[] answer = new String[ticket.length + 1];
        dfs(ticket, new boolean[ticket.length], 0, 0, answer);
        return answer;
    }

    private void dfs(String[][] ticket, boolean[] visited, int x, int pos, String[] answer) {
        visited[x] = true;
        answer[pos++] = ticket[x][0];
        String dest = ticket[x][1];
        for (int i = 0; i < ticket.length; i++) {
            if (!visited[i] && dest.equals(ticket[i][0])) {
                dfs(ticket, visited, i, pos, answer);
            }
        }
        answer[pos] = ticket[x][1];
    }
}
