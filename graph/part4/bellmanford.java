package graph.part4;

import java.util.ArrayList;

public class bellmanford {
    static class edge {
        int src;
        int dest;
        int weight;

        edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    static void createGraph(ArrayList<edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 2));
graph[0].add(new edge(0, 2, 4));

graph[1].add(new edge(1, 2, -4));

graph[2].add(new edge   (2, 3, 2));

graph[3].add(new edge(3, 4, 4));

graph[4].add(new edge(4, 1, -1));
    }


    public static void bellmanFord(ArrayList<edge> graph[], int src) {
        int V = graph.length;
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (i == src) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //algorithm
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    edge e = graph[j].get(k);
                    if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                        dist[e.dest] = dist[e.src] + e.weight;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < V; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                edge e = graph[j].get(k);
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        // Print the distances
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from source " + src + " to vertex " + i + " is " + dist[i]);
        }
    }
    public static void main(String args[]){
        int V = 5 ;
        ArrayList<edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph, 0); 
    }
}
