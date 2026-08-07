package graph.part2;

import java.util.ArrayList;

public class cycledetection {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
    // for cycle detection -> true
    // 0
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 3));

    // 1
    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));
    graph[1].add(new Edge(1, 4));

    // 2
    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 4));

    // 3
    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));

    // 4
    graph[4].add(new Edge(4, 1));
    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    // 0

    //for no cyle detection -> false
// graph[0].add(new Edge(0, 1));

// // 1
// graph[1].add(new Edge(1, 0));
// graph[1].add(new Edge(1, 2));
// graph[1].add(new Edge(1, 3));

// // 2
// graph[2].add(new Edge(2, 1));

// // 3
// graph[3].add(new Edge(3, 1));
// graph[3].add(new Edge(3, 4));

// // 4
// graph[4].add(new Edge(4, 3));
    }

    public static boolean detectcycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for(int i = 0 ; i < graph.length;i++){
            if(!vis[i]){
                if(detectcycleutil(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
   //o(V+E) 
    public static boolean detectcycleutil(ArrayList<Edge>[] graph,boolean[]vis,int curr,int par){
            vis[curr]=true;

            for(int i = 0 ; i < graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                //case3
        if (!vis[e.dest]) {
            if (detectcycleutil(graph, vis, e.dest, curr)) {
                return true;
            }
        }
                //case1
                else if(vis[e.dest]&&e.dest!=par){
                    return true;
                }
                //case2 -> do nothing  , continue
            }

            return false;
    }
    

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectcycle(graph));
    }
}
