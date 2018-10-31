public class Digraph {
    //private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v


    public Digraph(int V) {
        //if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }


    public int V() {
        return V;
    }

    public int E() {
        return E;
    }


    // // throw an IllegalArgumentException unless {@code 0 <= v < V}
    // private void validateVertex(int v) {
    //     if (v < 0 || v >= V)
    //         throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    // }


    public void addEdge(int v, int w) {
        //validateVertex(v);
        //validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }


    public Iterable<Integer> adj(int v) {
        //validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v) {
        //validateVertex(v);
        return adj[v].size();
    }


    public int indegree(int v) {
        //validateVertex(v);
        return indegree[v];
    }

    // public Digraph reverse() {
    //     Digraph reverse = new Digraph(V);
    //     for (int v = 0; v < V; v++) {
    //         for (int w : adj(v)) {
    //             reverse.addEdge(w, v);
    //         }
    //     }
    //     return reverse;
    // }

    // /**
    //  * Returns a string representation of the graph.
    //  *
    //  * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
    //  *         followed by the <em>V</em> adjacency lists
    //  */
    // public String toString() {
    //     StringBuilder s = new StringBuilder();
    //     s.append(V + " vertices, " + E + " edges " + NEWLINE);
    //     for (int v = 0; v < V; v++) {
    //         s.append(String.format("%d: ", v));
    //         for (int w : adj[v]) {
    //             s.append(String.format("%d ", w));
    //         }
    //         s.append(NEWLINE);
    //     }
    //     return s.toString();
    // }

    // /**
    //  * Unit tests the {@code Digraph} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {
    //     In in = new In(args[0]);
    //     Digraph G = new Digraph(in);
    //     StdOut.println(G);
    // }

}