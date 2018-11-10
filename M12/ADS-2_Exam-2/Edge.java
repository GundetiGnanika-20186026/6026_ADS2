/**
 * Class for edge.
 */
class Edge implements Comparable<Edge> {
    /**
     * vertices.
     */
    private final int v;
    /**
     * edges.
     */
    private final int w;
    /**
     * weight.
     */
    private final double weight;
    /**
     * Constructs the object.
     * its time complexity is O(1).
     *
     * @param      v1       { vertex1 }
     * @param      w1       { vertex2 }
     * @param      weight1  The weight
     */
    Edge(final int v1, final int w1, final double weight1) {

        this.v = v1;
        this.w = w1;
        this.weight = weight1;
    }

    /**
     * Returns the weight of this edge.
     * its time complexity is O(1).
     *
     * @return the weight of this edge
     */
    public double weight() {
        return weight;
    }

    /**
     * Returns either endpoint of this edge.
     * its time complexity is O(1).
     *
     * @return either endpoint of this edge
     */
    public int either() {
        return v;
    }

    /**
     * {Returns the endpoint of this edge that is
     *  different from the given vertex}.
     *
     * @param  vertex one endpoint of this edge
     * @return the other endpoint of this edge
     * its time complexity is O(1).

     */
    public int other(final int vertex) {
        if      (vertex == v) {
            return w;
        } else {
         return v;
        }

    }

    /**
     * Compares two edges by weight.
     * Note that compareTo() is not consistent with equals()
     * which uses the reference equality
     *  implementation inherited from Object.
     * its time complexity is O(1).
     *
     * @param  that the other edge
     * @return a negative integer, zero, or positive
     *  integer depending on whether the weight of this
     *   is less than, equal to, or greater than the
     *         argument edge
     */
    @Override
    public int compareTo(final Edge that) {
        return Double.compare(this.weight, that.weight);
    }
}
