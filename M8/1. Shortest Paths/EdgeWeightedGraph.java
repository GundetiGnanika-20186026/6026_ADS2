/**
 * Class for edge weighted graph.
 */
class EdgeWeightedGraph {
    /**
     * value.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * vertexes;
     */
    private final int V;
    /**
     * edges.
     */
    private int E;
    /**
     * bag array.
     */
    private Bag<Edge>[] adj;
    /**
     * Initializes an empty edge-weighted graph with V vertices and 0 edges.
     *
     * @param  V the number of vertices

     */
    EdgeWeightedGraph(int V) {

        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }




    /**
     * Returns the number of vertices in this edge-weighted graph.
     *
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertex() {
        return V;
    }

    /**
     * Returns the number of edges in this edge-weighted graph.
     *
     * @return the number of edges in this edge-weighted graph
     */
    public int edge() {
        return E;
    }



    /**
     * Adds the undirected edge e to this edge-weighted graph.
     *
     * @param  e the edge

     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        //validateVertex(v);
        //validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * Returns the edges incident on vertex  v.
     *
     * @param  v the vertex
     * @return the edges incident on vertex  v as an Iterable

     */
    public Iterable<Edge> adj(int v) {
        //validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex v.
     *
     * @param  v the vertex
     * @return the degree of vertex  v

     */
    public int degree(int v) {
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