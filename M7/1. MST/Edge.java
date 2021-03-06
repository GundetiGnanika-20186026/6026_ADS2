/**
 * Class for edge.
 */
public class Edge implements Comparable<Edge> {
   /**
    * vertex v.
    */
    private final int v;
    /**
     * vertex w.
     */
    private final int w;
    /**
     * weight.
     */
    private final double weight;

    /**
     * Initializes an edge.
     *
     * @param  v1 one vertex
     * @param  w1 the other vertex
     * @param  weight1 the weight of this edge

     */
    public Edge(final int v1, final int w1, final double weight1) {

        this.v = v1;
        this.w = w1;
        this.weight = weight1;
    }

    /**
     * Returns the weight of this edge.
     * its complexity is O(1).
     *
     * @return the weight of this edge
     */
    public double weight() {
        return weight;
    }

    /**
     * Returns either endpoint of this edge.
     * its complexity is O(1).
     *
     * @return either endpoint of this edge
     */
    public int either() {
        return v;
    }

    /**
     * Returns the endpoint of this edge that is different
     * from the given vertex.
     * its complexity is O(1).
     *
     * @param  vertex one endpoint of this edge
     * @return the other endpoint of this edge
     * @throws IllegalArgumentException if the
     *  vertex is not one of the
     *         endpoints of this edge
     */
    public int other(final int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new IllegalArgumentException("Illegal endpoint");
        }
    }
    /**
     * Compares two edges by weight.

     *its complexity is O(1).
     * @param  that the other edge
     * @return a negative integer, zero, or positive
     * integer depending on whether
     *         the weight of this is less than,
     *          equal to, or greater than the
     *         argument edge
     */
    @Override
    public int compareTo(final Edge that) {
        return Double.compare(this.weight, that.weight);
    }
}
