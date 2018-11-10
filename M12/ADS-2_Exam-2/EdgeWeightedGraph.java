/**
 * Class for edge weighted graph.
 */
class EdgeWeightedGraph {
    /**
     * value.
     */
    private static final String
    NEWLINE = System.getProperty("line.separator");
    /**
     * vertexes.
     */
    private final int ver;
    /**
     * edges.
     */
    private int edg;
    /**
     * bag array.
     */
    private Bag<Edge>[] adj;
    /**
     * {Initializes an empty edge-weighted
     *  graph with V vertices and 0 edges}.
     *  time complexity is O(V).
     *
     * @param  v1 the number of vertices

     */
    EdgeWeightedGraph(final int v1) {

        this.ver = v1;
        this.edg = 0;
        adj = (Bag<Edge>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * {Returns the number of
     * vertices in this edge-weighted graph}.
     * its time complexity is O(1).
     *
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertex() {
        return ver;
    }

    /**
     * {Returns the number of edges
     *  in this edge-weighted graph}.
     *  its time complexity is O(1).
     *
     * @return the number of edges in this edge-weighted graph
     */
    public int edge() {
        return edg;
    }



    /**
     * {Adds the undirected edge e to
     *  this edge-weighted graph}.
     *  its time complexity is O(1).
     *
     *
     * @param  e the edge

     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        //validateVertex(v);
        //validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edg++;
    }

    /**
     * Returns the edges incident on vertex  v.
     * its time complexity is O(1).
     *
     * @param  v the vertex
     * @return the edges incident on vertex  v as an Iterable

     */
    public Iterable<Edge> adj(final int v) {
        //validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex v.
     * its time complexity is O(1).
     *
     * @param  v the vertex
     * @return the degree of vertex  v

     */
    public int degree(final int v) {
        //validateVertex(v);
        return adj[v].size();
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(ver + " " + "vertices" + " " + edg + " " + "edges" + NEWLINE);
        for (int v = 0; v < ver; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                int k = e.either();
                // NumberFormat formatter = new DecimalFormat("#0.0000");
//System.out.println(formatter.format(4.0));
                s.append(e.either() + "-" + e.other(k) + " " + e.weight() + "0000" + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


}
