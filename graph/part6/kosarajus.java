package graph.part6;
import java.util.*;
import java.util.ArrayList;

//strongly connected components
public class kosarajus {
        // Edge class
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create Graph
    public static void createGraph(ArrayList<Edge> graph[]) {

        // Create an empty ArrayList for every vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // 0 -> 2
        graph[0].add(new Edge(0, 2));

        // 0 -> 3
        graph[0].add(new Edge(0, 3));

        // 1 -> 0
        graph[1].add(new Edge(1, 0));

        // 2 -> 1
        graph[2].add(new Edge(2, 1));

        // 3 -> 4
        graph[3].add(new Edge(3, 4));
    }


    public static void topsort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsort(graph,e.dest,vis,s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.print(curr + " ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int v){//o(V+E)
         //step 1
         Stack<Integer> s = new Stack<>();

         boolean vis[] = new boolean[v];
         for(int i=0;i<v;i++){
            if(!vis[i]){
                topsort(graph,i,vis,s);
            }
         }

         //step 2
            ArrayList<Edge> transpose[] = new ArrayList[v];
            for(int i=0;i<v;i++){
                vis[i] = false;
                transpose[i] = new ArrayList<>();
            }
            for(int i=0;i<v;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    transpose[e.dest].add(new Edge(e.dest,e.src));
                }
            }

            //step 3
            while(!s.isEmpty()){
                int curr = s.pop();
                if(!vis[curr]){
                    dfs(transpose,curr,vis);
                    System.out.println();
                }
            }
    }

    public static void main(String args[]) {

        int V = 5;

        // Create graph array
        ArrayList<Edge> graph[] = new ArrayList[V];

        // Build graph
        createGraph(graph);

        // // Print graph
        // for (int i = 0; i < graph.length; i++) {

        //     System.out.print("Vertex " + i + " -> ");

        //     for (Edge e : graph[i]) {
        //         System.out.print(e.dest + " ");
        //     }

        //     System.out.println();


       // }

        kosaraju(graph,V);
    }
}



// import java.util.*;

// public class Kosaraju {

//     static void dfs(int node, ArrayList<ArrayList<Integer>> graph,
//                     boolean[] visited, Stack<Integer> stack) {

//         visited[node] = true;

//         for (int neighbor : graph.get(node)) {
//             if (!visited[neighbor]) {
//                 dfs(neighbor, graph, visited, stack);
//             }
//         }

//         // Store according to finishing time
//         stack.push(node);
//     }

//     static void reverseDFS(int node,
//                            ArrayList<ArrayList<Integer>> reverseGraph,
//                            boolean[] visited) {

//         visited[node] = true;

//         System.out.print(node + " ");

//         for (int neighbor : reverseGraph.get(node)) {
//             if (!visited[neighbor]) {
//                 reverseDFS(neighbor, reverseGraph, visited);
//             }
//         }
//     }

//     static void kosaraju(int V, ArrayList<ArrayList<Integer>> graph) {

//         // Step 1: DFS on original graph
//         boolean[] visited = new boolean[V];
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i < V; i++) {
//             if (!visited[i]) {
//                 dfs(i, graph, visited, stack);
//             }
//         }

//         // Step 2: Create transpose graph
//         ArrayList<ArrayList<Integer>> reverseGraph =
//                 new ArrayList<>();

//         for (int i = 0; i < V; i++) {
//             reverseGraph.add(new ArrayList<>());
//         }

//         for (int u = 0; u < V; u++) {
//             for (int v : graph.get(u)) {
//                 reverseGraph.get(v).add(u);
//             }
//         }

//         // Step 3: DFS on transpose graph
//         Arrays.fill(visited, false);

//         System.out.println("Strongly Connected Components:");

//         while (!stack.isEmpty()) {

//             int node = stack.pop();

//             if (!visited[node]) {
//                 reverseDFS(node, reverseGraph, visited);
//                 System.out.println();
//             }
//         }
//     }

//     public static void main(String[] args) {

//         int V = 5;

//         ArrayList<ArrayList<Integer>> graph =
//                 new ArrayList<>();

//         for (int i = 0; i < V; i++) {
//             graph.add(new ArrayList<>());
//         }

//         graph.get(0).add(2);
//         graph.get(2).add(1);
//         graph.get(1).add(0);

//         graph.get(0).add(3);
//         graph.get(3).add(4);

//         kosaraju(V, graph);
//     }
// }