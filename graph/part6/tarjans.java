package graph.part6;

import java.util.*;

public class tarjans {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static int time = 0;

    public static void dfs(
            ArrayList<Edge> graph[],
            int curr,
            int par,
            int dt[],
            int low[],
            boolean vis[]) {

        // Mark current vertex as visited
        vis[curr] = true;

        // Discovery time and low value
        dt[curr] = low[curr] = ++time;

        // Visit all neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            int neigh = e.dest;

            // Ignore parent
            if (neigh == par) {
                continue;
            }

            // If neighbour is not visited
            if (!vis[neigh]) {

                dfs(graph, neigh, curr, dt, low, vis);

                // Update low value
                low[curr] = Math.min(low[curr], low[neigh]);

                // Bridge condition
                if (dt[curr] < low[neigh]) {
                    System.out.println(
                            "Bridge : " + curr + " ---- " + neigh
                    );
                }

            } else {

                // Back edge
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(
            ArrayList<Edge> graph[],
            int V) {

        int dt[] = new int[V];
        int low[] = new int[V];

        boolean vis[] = new boolean[V];

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        tarjanBridge(graph, V);
    }
}