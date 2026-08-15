package graph.part5;

import java.util.*;

public class cheapestflights {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // Create graph
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    // Cheapest flight within K stops
    public static int cheapestFlight(
            int n,
            int flights[][],
            int src,
            int dest,
            int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];

        createGraph(flights, graph);

        int dis[] = new int[n];

        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        dis[src] = 0;

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {

            Info curr = q.remove();

            // More than K stops
            if (curr.stops > k) {
                continue;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edge e = graph[curr.v].get(i);

                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dis[v]
                        && curr.stops <= k) {

                    dis[v] = curr.cost + wt;

                    q.add(new Info(
                            v,
                            dis[v],
                            curr.stops + 1
                    ));
                }
            }
        }

        if (dis[dest] == Integer.MAX_VALUE) {
            return -1;
        }

        return dis[dest];
    }

    public static void main(String args[]) {

        int n = 4;

        int flights[][] = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };

        int src = 0;
        int dest = 3;
        int k = 1;

        System.out.println(
            cheapestFlight(n, flights, src, dest, k)
        );
    }
}