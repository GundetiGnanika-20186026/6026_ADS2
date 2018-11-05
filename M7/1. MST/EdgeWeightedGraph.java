/**
 * Class for edge weighted graph.
 */
public class EdgeWeightedGraph {
    /**
     * value.
     */
    private static final String
     NEWLINE = System.getProperty("line.separator");
    /**
     * vertex.
     */
    private final int v;
    /**
     * edge.
     */
    private int e;
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

        this.v = V;
        this.e = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Edge>();
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
        return v;
    }

    /**
     * {Returns the number of edges
     *  in this edge-weighted graph}.
     *
     * @return the number of edges
     *  in this edge-weighted graph.
     */
    public int E() {
        return e;
    }


    /**
     * {Adds the undirected edge
     *  {@code e} to this edge-weighted graph}.
     *
     * @param  e1 the edge

     */
    public void addEdge(final Edge e1) {
        int u = e1.either();
        int q = e1.other(v);

        adj[u].add(e1);
        adj[q].add(e1);
        e++;
    }

    /**
     * {Returns the edges incident on vertex {@code v}}.
     *
     * @param  v1 the vertex
     * @return the edges incident on
     *  vertex {@code v} as an Iterable
     *
     */
    public Iterable<Edge> adj(final int v1) {
        //validateVertex(v);
        return adj[v1];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}

     */
    public int degree(final int v2) {
        //validateVertex(v);
        return adj[v2].size();
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
        for (int i = 0; i < v; i++) {
            int selfLoops = 0;
            for (Edge e : adj(i)) {
                if (e.other(i) > i) {
                    list.add(e);
                } else if (e.other(i) == i) {
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
        s.append(v + " " + e + NEWLINE);
        for (int i = 0; i < v; i++) {
            s.append(i + ": ");
            for (Edge e : adj[i]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}


