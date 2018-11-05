public class EdgeWeightedGraph {
    /**
     * value.
     */
    private static final String
     NEWLINE = System.getProperty("line.separator");
    /**
     * vertex.
     */
    private final int V;
    /**
     * edge.
     */
    private int E;
    /**
     * bag.
     */
    private Bag<Edge>[] adj;

    /**
     * {Initializes an empty edge-weighted
     *  graph with {@code V} vertices and 0 edges}.
     *
     * @param  V the number of vertices

     */
    public EdgeWeightedGraph(final int V) {

        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    /**
     * {Returns the number
     *  of vertices in this edge-weighted graph}.
     *
     * @return the number of
     *  vertices in this edge-weighted graph
     */
    public int V() {
        return V;
    }

    /**
     * {Returns the number of edges
     *  in this edge-weighted graph}.
     *
     * @return the number of edges
     *  in this edge-weighted graph.
     */
    public int E() {
        return E;
    }


    /**
     * {Adds the undirected edge
     *  {@code e} to this edge-weighted graph}.
     *
     * @param  e the edge

     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * {Returns the edges incident on vertex {@code v}}.
     *
     * @param  v the vertex
     * @return the edges incident on
     *  vertex {@code v} as an Iterable
     *
     */
    public Iterable<Edge> adj(final int v) {
        //validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}

     */
    public int degree(final int v) {
        //validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this
     *  edge-weighted graph, use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
// add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

  /**
   * Returns a string representation of the object.
   * its complexity is O(V+E).
   *
   * @return String representation of the object.
   */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}


