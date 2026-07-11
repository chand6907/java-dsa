package graph.part1;
import java.util.*;

public class bfs {
    
        static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 1));
    graph[0].add(new Edge(0, 2, 1));

    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 3, 1));

    graph[2].add(new Edge(2, 0, 1));
    graph[2].add(new Edge(2, 4, 1));

    graph[3].add(new Edge(3, 1, 1));
    graph[3].add(new Edge(3, 4, 1));
    graph[3].add(new Edge(3, 5, 1));

    graph[4].add(new Edge(4, 2, 1));
    graph[4].add(new Edge(4, 3, 1));
    graph[4].add(new Edge(4, 5, 1));

    graph[5].add(new Edge(5, 3, 1));
    graph[5].add(new Edge(5, 4, 1));
}
// important -> bfs is used to traverse the graph in a breadth first manner. It uses a queue to keep track of the nodes to be visited next. The algorithm starts from a source node, marks it as visited, and then explores all its unvisited neighbors before moving on to the next level of neighbors. This process continues until all reachable nodes have been visited.
    public static void bfs(ArrayList<Edge> graph[]){//O(V+E)
        
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);//sourece = 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){//visit  curr
                System.out.print(curr+" ");
                vis[curr]= true;
                for(int i = 0 ; i < graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

public static void main (String args[]){

    int v  =7 ;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);

    bfs(graph);
}
}
