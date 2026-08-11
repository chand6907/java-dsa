package graph.part3;

import java.util.*;
//using bfs 
public class topologicalsortingusingbfs {
    static class Edge {
        int src ;
        int dest;

        public Edge(int s , int d ){
            this.src = s ;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
    // Create an empty ArrayList for every vertex
    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }

    // Add edges
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 1));

    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
}


    public static void topsort(ArrayList<Edge> graph[]) {
        int indegree[] = new int[graph.length];

        // Calculate indegree of each vertex
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }

        // Create a queue and enqueue all vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Perform BFS
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

public static void main (String args []){
    int V = 6 ;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    topsort(graph);
}

}
