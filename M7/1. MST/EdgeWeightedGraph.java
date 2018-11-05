// /**
//  * Class for edge weighted graph.
//  */
// public class EdgeWeightedGraph {
//     /**
//      * value.
//      */
//     private static final String
//      NEWLINE = System.getProperty("line.separator");
//     /**
//      * vertex.
//      */
//     private final int v;
//     /**
//      * edge.
//      */
//     private int e;
//     /**
//      * bag.
//      */
//     private Bag<Edge>[] adj;

//     /**
//      * {Initializes an empty edge-weighted
//      *  graph with {@code V} vertices and 0 edges}.
//      *
//      * @param  V the number of vertices

//      */
//     public EdgeWeightedGraph(final int V) {

//         this.v = V;
//         this.e = 0;
//         adj = (Bag<Edge>[]) new Bag[V];
//         for (int i = 0; i < V; i++) {
//             adj[i] = new Bag<Edge>();
//         }
//     }
//     /**
//      * {Returns the number
//      *  of vertices in this edge-weighted graph}.
//      *
//      * @return the number of
//      *  vertices in this edge-weighted graph
//      */
//     public int V() {
//         return v;
//     }

//     /**
//      * {Returns the number of edges
//      *  in this edge-weighted graph}.
//      *
//      * @return the number of edges
//      *  in this edge-weighted graph.
//      */
//     public int E() {
//         return e;
//     }


//     /**
//      * {Adds the undirected edge
//      *  {@code e} to this edge-weighted graph}.
//      *
//      * @param  e the edge

//      */
//     public void addEdge(final Edge e) {
//         int u = e.either();
//         int q = e.other(v);

//         adj[u].add(e);
//         adj[w].add(e);
//         E++;
//     }

//     /**
//      * {Returns the edges incident on vertex {@code v}}.
//      *
//      * @param  v the vertex
//      * @return the edges incident on
//      *  vertex {@code v} as an Iterable
//      *
//      */
//     public Iterable<Edge> adj(final int v) {
//         //validateVertex(v);
//         return adj[v];
//     }

//     /**
//      * Returns the degree of vertex {@code v}.
//      *
//      * @param  v the vertex
//      * @return the degree of vertex {@code v}

//      */
//     public int degree(final int v) {
//         //validateVertex(v);
//         return adj[v].size();
//     }

//     /**
//      * Returns all edges in this edge-weighted graph.
//      * To iterate over the edges in this
//      *  edge-weighted graph, use foreach notation:
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
//                 } else if (e.other(v) == v) {
//                     if (selfLoops % 2 == 0) list.add(e);
//                     selfLoops++;
//                 }
//             }
//         }
//         return list;
//     }

//   /**
//    * Returns a string representation of the object.
//    * its complexity is O(V+E).
//    *
//    * @return String representation of the object.
//    */
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
// }

/**
 * Class for edge weighted graph.
 */
public class EdgeWeightedGraph {
    /**
     * line separator.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * vertices.
     *
     */

    private final int vertex;
    /**
     * edges.
     */
    private int edge;
    /**
     * bags class of edge type.
     */
    private Bag<Edge>[] adj;

    /**
     * Initializes an empty edge-weighted.
     *  graph with {@code V} vertices and 0 edges.
     *
     * @param  vertex1 the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(final int vertex1) {

        this.vertex = vertex1;
        this.edge = 0;
        adj = (Bag<Edge>[]) new Bag[vertex];
        for (int v = 0; v < vertex; v++) {
            adj[v] = new Bag<Edge>();
        }
    }




    /**
     * Returns the number of vertices.
     *  in this edge-weighted graph.
     * The time complexity is O(1).
     *
     *
     * @return the number of vertices.
     *  in this edge-weighted graph
     */
    public int vertex() {
        return vertex;
    }

    /**
     * Returns the number of edges.
     *  in this edge-weighted graph.
     * The time complexity is O(1).
     *
     *
     * @return the number of edges.
     *  in this edge-weighted graph
     */
    public int edge() {
        return edge;
    }



    /**
     * Adds an edge.
     * The time complexity is O(1).
     *
     *
     * @param      e     { Edge }
     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        // validateVertex(v);
        // validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edge++;
    }

    /**
     * iterable.
     * The time complexity is O(degree(V)).
     *
     *
     * @param      v     { vertex }
     *
     * @return     { iterable }
     */
    public Iterable<Edge> adj(final int v) {
        // validateVertex(v);
        return adj[v];
    }

    /**
     * degree.
     * The time complexity is O(1).
     *
     *
     * @param      v     { v }
     *
     * @return     { int }
     */
    public int degree(final int v) {
        // validateVertex(v);
        return adj[v].size();
    }

    /**
     * iterable.
     * The time complexity is O(V+E).
     *
     *
     * @return     { edges }
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vertex; v++) {
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
     * Returns a string representation of the object.
     * The time complexity is O(V+E).
     *
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertex + " " + edge + NEWLINE);
        for (int v = 0; v < vertex; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
