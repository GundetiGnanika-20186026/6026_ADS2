/**
 * Class for kruskal mst.
 */
public class KruskalMST {
    /**
     * value.
     */
private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**
     * // weight of MST.
     */
    private double weight;
    /**
     * // edges in MST.
     */
    private Queue<Edge> mst = new Queue<Edge>();
     /**
     * {Compute a minimum spanning tree
      *  (or forest) of an edge-weighted graph}.
     * @param graph the edge-weighted graph
     */
    public KruskalMST(final EdgeWeightedGraph graph) {
        // more efficient to build heap by passing
        // array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : graph.edges()) {
            pq.insert(e);
        }

        // run greedy algorithm
        UF uf = new UF(graph.vertex());
        while (!pq.isEmpty() && mst.size() < graph.vertex() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            // v-w does not create a cycle
            if (!uf.connected(v, w)) {
                // merge v and w components
                uf.union(v, w);
                 // add edge e to mst
                mst.enqueue(e);
                weight += e.weight();
            }
        }

    }

    /**
     * {Returns the edges in a minimum
     *  spanning tree (or forest)}.
     * @return the edges in a minimum
     *  spanning tree (or forest) as
     *    an iterable of edges
     * its complexity is O(E).
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * {Returns the sum of the edge weights
     *  in a minimum spanning tree (or forest)}.
     * @return the sum of the edge weights in a
     *  minimum spanning tree (or forest).
     *  its complexity is O(1).
     */
    public double weight() {
        return weight;
    }

}
