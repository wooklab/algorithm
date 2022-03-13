package com.wooklab.algorithm.programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        String[][] ticket3 = {{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"},
                              {"COO", "BOO"}, {"BOO", "AOO"}};
        // ["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]
        String[] result = m.solution(ticket);
        System.out.println(Arrays.stream(result).collect(Collectors.joining(",")));
        String[] result2 = m.solution(ticket2);
        System.out.println(Arrays.stream(result2).collect(Collectors.joining(",")));
        String[] result3 = m.solution(ticket3);
        System.out.println(Arrays.stream(result3).collect(Collectors.joining(",")));
    }

    public String[] solution(String[][] ticket) {
        Arrays.sort(ticket, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });

        List<String> routes = new ArrayList<>();
        boolean[] visited = new boolean[ticket.length];
        dfs(ticket, "ICN", routes, visited, 0);
        return routes.toArray(new String[ticket.length + 1]);
    }

    private void dfs(String[][] ticket, String departure, List<String> routes, boolean[] visited, int depth) {
        if (depth == ticket.length) {
            routes.add(departure);
        } else {
            for (int i = 0; i < ticket.length; i++) {
                if (!visited[i] && ticket[i][0].equals(departure)) {
                    visited[i] = true;
                    routes.add(ticket[i][0]);
                    dfs(ticket, ticket[i][1], routes, visited, depth + 1);
                    if (routes.size() == ticket.length + 1) {
                        return;
                    }
                    visited[i] = false;
                    if (!routes.isEmpty()) {
                        int removeIndex = routes.lastIndexOf(ticket[i][0]);
                        routes.remove(removeIndex);
                    }
                }
            }
        }
    }
}
