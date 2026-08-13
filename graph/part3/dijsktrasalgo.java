package graph.part3;

import java.util.*;

public class dijsktrasalgo {

    // Edge class
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Create Graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Pair class
    static class pair {
        int n;
        int path;

        public pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
    }

    // Comparator for PriorityQueue
    static class pairComparator implements Comparator<pair> {

        @Override
        public int compare(pair p1, pair p2) {
            return Integer.compare(p1.path, p2.path);
        }
    }

    // Dijkstra's Algorithm
    public static void dijsktra(ArrayList<Edge> graph[], int src) {

        int dist[] = new int[graph.length];

        // Initialize distances
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];

        // Priority Queue using Comparator
        PriorityQueue<pair> pq = new PriorityQueue<>(new pairComparator());

        // Add source
        pq.add(new pair(src, 0));

        while (!pq.isEmpty()) {

            // Get node with minimum distance
            pair curr = pq.remove();

            if (!vis[curr.n]) {

                vis[curr.n] = true;

                // Visit all adjacent edges
                for (int i = 0; i < graph[curr.n].size(); i++) {

                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation
                    if (dist[u] + wt < dist[v]) {

                        dist[v] = dist[u] + wt;

                        pq.add(new pair(v, dist[v]));
                    }
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");

        for (int i = 0; i < dist.length; i++) {
            System.out.print("To " + i + ": " + dist[i] + " ");
        }
    }

    // Main method
    public static void main(String args[]) {

        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 0;

        dijsktra(graph, src);
    }
}
//tc= v+Elogv