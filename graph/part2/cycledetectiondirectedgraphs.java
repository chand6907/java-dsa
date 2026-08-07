package graph.part2;

import java.util.ArrayList;

public class cycledetectiondirectedgraphs {
    static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

static void createGraph(ArrayList<Edge> graph[]) {

    // Initialize adjacency list
    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }

    // Directed edges
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 0));
}


    public static boolean isCyclicUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean rec[]) {
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!vis[e.dest] && isCyclicUtil(graph, e.dest, vis, rec)) {
                return true;
            }
        }

        rec[curr] = false;
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean rec[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, i, vis, rec)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main (String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCyclic(graph));


    }
}
