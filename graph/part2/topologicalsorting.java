package graph.part2;

import java.util.*;
//this was using the concepet of DFS and stack to store the elements in reverse order of their finishing time
public class topologicalsorting{
    static class Edge{
        int src ;
        int dest;

        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,5));
        graph[2].add(new Edge(2,6));
    }

    //O(V+E)
    public static void topsort(ArrayList<Edge>[] graph){

        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0 ; i < graph.length ; i++){
            if(!vis[i]){
                topsortutil(graph , i , vis , s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    public static void topsortutil(ArrayList<Edge>[] graph , int curr , boolean vis[] , Stack<Integer> s){
        vis[curr] = true;

        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsortutil(graph , e.dest , vis , s);
            }
        }
        s.push(curr);
    }
    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph (graph);

        topsort(graph);
    }
}