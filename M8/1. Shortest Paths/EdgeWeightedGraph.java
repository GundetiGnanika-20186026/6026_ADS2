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
     * vertexes;
     */
    private final int v;
    /**
     * edges.
     */
    private int e;
    /**
     * bag array.
     */
    private Bag<Edge>[] adj;
    /**
     * {Initializes an empty edge-weighted
     *  graph with V vertices and 0 edges}.
     *
     * @param  v1 the number of vertices

     */
    EdgeWeightedGraph(final int v1) {

        this.v = v1;
        this.e = 0;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int v = 0; v < v1; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * {Returns the number of
     * vertices in this edge-weighted graph}.
     *
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertex() {
        return v;
    }

    /**
     * {Returns the number of edges
     *  in this edge-weighted graph}.
     *
     * @return the number of edges in this edge-weighted graph
     */
    public int edge() {
        return e;
    }



    /**
     * {Adds the undirected edge e to
     *  this edge-weighted graph}.
     *
     * @param  e1 the edge

     */
    public void addEdge(final Edge e1) {
        int v1 = e1.either();
        int w1 = e1.other(v);
        //validateVertex(v);
        //validateVertex(w);
        adj[v1].add(e1);
        adj[w1].add(e1);
        e += 1;
    }

    /**
     * Returns the edges incident on vertex  v.
     *
     * @param  v2 the vertex
     * @return the edges incident on vertex  v as an Iterable

     */
    public Iterable<Edge> adj(final int v2) {
        //validateVertex(v);
        return adj[v2];
    }

    /**
     * Returns the degree of vertex v.
     *
     * @param  v the vertex
     * @return the degree of vertex  v

     */
    public int degree(final int v) {
        //validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns all edges in this edge-weighted graph.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vertex(); v++) {
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

}