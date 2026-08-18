package graph.part5;

public class disjoint {

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // Initialize every element as its own parent
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    // Find parent with path compression
    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    // Union using rank
    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        // Already in the same set
        if (parA == parB) {
            return;
        }

        if (rank[parA] < rank[parB]) {
            par[parA] = parB;

        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;

        } else {
            par[parB] = parA;
            rank[parA]++;
        }
    }

    public static void main(String args[]) {

        init();

        union(1, 2);
        union(2, 3);

        union(4, 5);
        union(6, 5);

        union(3, 6);

        System.out.println(find(1));
        System.out.println(find(2));
        System.out.println(find(3));
        System.out.println(find(4));
        System.out.println(find(5));
        System.out.println(find(6));
    }
}