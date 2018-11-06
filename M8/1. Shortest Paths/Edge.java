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
     *
     * @param      v       { vertex1 }
     * @param      w       { vertex2 }
     * @param      weight  The weight
     */
    Edge(int v, int w, double weight) {

        this.v = v;
        this.w = w;
        this.weight = weight;
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
    public int other(int vertex) {
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
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    // /**
    //  * Returns a string representation of this edge.
    //  *
    //  *
    //  * @return a string representation of this edge
    //  */
    // public String toString() {
    //     return String.format("%d-%d %.5f", v, w, weight);
    // }


}