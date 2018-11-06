/**
 *dijkstra's algorithm.
 *
 */
class DijkstraSP {
    /**
     *{array to store distance from
     * one vertex to another}.
     */
    private Double[] distTo;
    /**
     *store the edge connected.
     */
    private Edge[] edgeTo;
    /**
     *store the key value pair.
     */
    private IndexMinPQ<Double> pq;
    /**
     *the graph object.
     */
    private EdgeWeightedGraph graph;
    /**
     *the constructor to initialize the objects.
     *time complexity is O(E + V).
     * @param      g  graph object.
     * @param      source  The source
     */
    DijkstraSP(final EdgeWeightedGraph g,
               final int source) {
        graph = g;
        distTo = new Double[graph.V()];
        edgeTo = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;
        pq = new IndexMinPQ<Double>(graph.V());
        pq.insert(source, distTo[source]);
        while (!pq.isEmpty()) {
            int vertex = pq.delMin();
            for (Edge edge : graph.adj(vertex)) {
                relax(edge, vertex);
            }
        }
    }

    /**
     * will connect the edge with less weight.
     *
     * @param      edge    The edge
     * @param      vertex  The vertex
     */
    private void relax(Edge edge, int vertex) {
        int vertexTwo = edge.other(vertex);
        if (distTo[vertexTwo] > distTo[vertex] + edge.weight()) {
            distTo[vertexTwo] = distTo[vertex] + edge.weight();
            edgeTo[vertexTwo] = edge;
            if (pq.contains(vertexTwo)) {
                pq.decreaseKey(vertexTwo, distTo[vertexTwo]);
            } else {
                pq.insert(vertexTwo, distTo[vertexTwo]);
            }
        }
    }
    /**
     * distance of given vertex from source.
     *
     * @param      v     { vertex }
     *
     * @return     { distance }
     */
    public double distTo(final int v) {
        return distTo[v];
    }
    /**
     * Determines if it has path to.
     *
     * @param      v     { vertex }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    /**
     * finds path from source to given vertex.
     *
     * @param      v     { vertex }
     *
     * @return     { path }
     */
    public Iterable<Edge> pathTo(final int v) {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }
    /**
     * will return the path.
     *
     * @param      vertex  The vertex
     *
     * @return     { path }
     */
    public double path(final int vertex) {
        double sum = 0;
        for (Edge each : pathTo(vertex)) {
            sum += each.weight();
        }
        return sum;
    }
}

