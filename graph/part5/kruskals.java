package graph.part5;

import java.util.*;

public class kruskals {

    // Edge class
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        // Sort edges based on weight
        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    // Create graph
    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Number of vertices
    static int n = 4;

    // Parent array
    static int par[] = new int[n];

    // Rank array
    static int rank[] = new int[n];

    // Initialize DSU
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    // Find parent with path compression
    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    // Union by rank
    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        // If both belong to the same set
        if (parA == parB) {
            return;
        }

        // Same rank
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }

        // parA has smaller rank
        else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        }

        // parB has smaller rank
        else {
            par[parB] = parA;
        }
    }
    //o(V+ElogE)
    public static void kruskalsmst(ArrayList<Edge> edges, int v){
        init();
         Collections.sort(edges);
         int mstcost = 0;
         int count =0;

         for(int i = 0; count<v-1;i++){
            Edge e = edges.get(i);

            int para = find(e.src);
            int parb = find(e.dest);
            if(para!=parb){
                union(e.src,e.dest);
                mstcost += e.wt;
                count++;

            }
         }
         System.out.println("MST cost: "+mstcost);
    }

    // Main method
    public static void main(String args[]) {

        int V = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        // Create graph
        createGraph(edges);

        // Initialize DSU
        init();

        // Example union operations
        union(0, 1);
        union(2, 3);

        System.out.println("Parent of 0: " + find(0));
        System.out.println("Parent of 1: " + find(1));
        System.out.println("Parent of 2: " + find(2));
        System.out.println("Parent of 3: " + find(3));

        kruskalsmst(edges, V);
    }
}