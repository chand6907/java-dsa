package graph.part4;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsalgo {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    // Create Graph
    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    // Prim's Algorithm
    public static void prims(ArrayList<Edge> graph[]) {

        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Edge> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // Starting vertex = 0
        pq.add(new Edge(0, 0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {

            Edge curr = pq.remove();

            // If vertex is not visited
            if (!vis[curr.dest]) {

                vis[curr.dest] = true;

                // Add edge weight to MST cost
                finalCost += curr.weight;

                // Add all adjacent edges
                for (int i = 0; i < graph[curr.dest].size(); i++) {

                    Edge e = graph[curr.dest].get(i);

                    if (!vis[e.dest]) {
                        pq.add(e);
                    }
                }
            }
        }

        System.out.println("Minimum Cost Spanning Tree: " + finalCost);
    }

    public static void main(String args[]) {

        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        prims(graph);
    }
}