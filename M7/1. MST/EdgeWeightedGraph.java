// public class EdgeWeightedGraph {
//     private static final String NEWLINE = System.getProperty("line.separator");

//     private final int V;
//     private int E;
//     private Bag<Edge>[] adj;

//     /**
//      * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
//      *
//      * @param  V the number of vertices
//      * @throws IllegalArgumentException if {@code V < 0}
//      */
//     public EdgeWeightedGraph(int V) {
//         if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
//         this.V = V;
//         this.E = 0;
//         adj = (Bag<Edge>[]) new Bag[V];
//         for (int v = 0; v < V; v++) {
//             adj[v] = new Bag<Edge>();
//         }
//     }








//     /**
//      * Returns the number of vertices in this edge-weighted graph.
//      *
//      * @return the number of vertices in this edge-weighted graph
//      */
//     public int V() {
//         return V;
//     }

//     /**
//      * Returns the number of edges in this edge-weighted graph.
//      *
//      * @return the number of edges in this edge-weighted graph
//      */
//     public int E() {
//         return E;
//     }

//     // throw an IllegalArgumentException unless {@code 0 <= v < V}
//     private void validateVertex(int v) {
//         if (v < 0 || v >= V)
//             throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
//     }

//     /**
//      * Adds the undirected edge {@code e} to this edge-weighted graph.
//      *
//      * @param  e the edge
//      * @throws IllegalArgumentException unless both endpoints are between {@code 0} and {@code V-1}
//      */
//     public void addEdge(Edge e) {
//         int v = e.either();
//         int w = e.other(v);
//         validateVertex(v);
//         validateVertex(w);
//         adj[v].add(e);
//         adj[w].add(e);
//         E++;
//     }

//     /**
//      * Returns the edges incident on vertex {@code v}.
//      *
//      * @param  v the vertex
//      * @return the edges incident on vertex {@code v} as an Iterable
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public Iterable<Edge> adj(int v) {
//         validateVertex(v);
//         return adj[v];
//     }

//     /**
//      * Returns the degree of vertex {@code v}.
//      *
//      * @param  v the vertex
//      * @return the degree of vertex {@code v}
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public int degree(int v) {
//         validateVertex(v);
//         return adj[v].size();
//     }

//     /**
//      * Returns all edges in this edge-weighted graph.
//      * To iterate over the edges in this edge-weighted graph, use foreach notation:
//      * {@code for (Edge e : G.edges())}.
//      *
//      * @return all edges in this edge-weighted graph, as an iterable
//      */
//     public Iterable<Edge> edges() {
//         Bag<Edge> list = new Bag<Edge>();
//         for (int v = 0; v < V; v++) {
//             int selfLoops = 0;
//             for (Edge e : adj(v)) {
//                 if (e.other(v) > v) {
//                     list.add(e);
//                 }
//                 // add only one copy of each self loop (self loops will be consecutive)
//                 else if (e.other(v) == v) {
//                     if (selfLoops % 2 == 0) list.add(e);
//                     selfLoops++;
//                 }
//             }
//         }
//         return list;
//     }

//     /**
//      * Returns a string representation of the edge-weighted graph.
//      * This method takes time proportional to <em>E</em> + <em>V</em>.
//      *
//      * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
//      *         followed by the <em>V</em> adjacency lists of edges
//      */
//     public String toString() {
//         StringBuilder s = new StringBuilder();
//         s.append(V + " " + E + NEWLINE);
//         for (int v = 0; v < V; v++) {
//             s.append(v + ": ");
//             for (Edge e : adj[v]) {
//                 s.append(e + "  ");
//             }
//             s.append(NEWLINE);
//         }
//         return s.toString();
//     }

//     // /**
//     //  * Unit tests the {@code EdgeWeightedGraph} data type.
//     //  *
//     //  * @param args the command-line arguments
//     //  */
//     // public static void main(String[] args) {
//     //     In in = new In(args[0]);
//     //     EdgeWeightedGraph G = new EdgeWeightedGraph(in);
//     //     StdOut.println(G);
//     // }

// }


/**
 * Class for edge weighted graph.
 */
public class EdgeWeightedGraph {
    /**
     * newline.
     */
    private static final String NEWLINE
        = System.getProperty("line.separator");
    /**
     * integer variable.
     */
    private final int vertices;
    /**
     * integer variable.
     */
    private int edges;
    /**
     * adj array of bag type.
     */
    private Bag<Edge>[] adj;

    /**
     * Initializes an empty edge-weighted
     * graph with {@code V} vertices and 0 edges.
     *
     * @param  ve the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(final int ve) {
        if (ve < 0) {
            throw new IllegalArgumentException(
                "Number of vertices must be nonnegative");
        }
        this.vertices = ve;
        this.edges = 0;
        adj = (Bag<Edge>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    /**
     * Returns the number of vertices in this edge-weighted graph.
     *
     * @return the number of vertices in this edge-weighted graph
     */
    public int v() {
        return vertices;
    }

    /**
     * Returns the number of edges in this edge-weighted graph.
     *
     * @return the number of edges in this edge-weighted graph
     */
    public int e() {
        return edges;
    }
    /**
     *throw an IllegalArgumentException unless {@code 0 <= v < V}.
     *
     * @param      v     { integer variable. }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (vertices - 1));
        }
    }

    /**
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     *
     * @param  e the edge
     * @throws IllegalArgumentException
     * unless both endpoints are between {@code 0} and {@code V-1}
     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edges++;
    }

    /**
     * Returns the edges incident on vertex {@code v}.
     *
     * @param  v the vertex
     * @return the edges incident on vertex {@code v} as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this edge-weighted
     * graph, use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vertices; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

    /**
     * Returns a string representation of the edge-weighted graph.
     * This method takes time proportional to <em>E</em> + <em>V</em>.
     *
     * @return the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists of edges
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " " + edges + NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}