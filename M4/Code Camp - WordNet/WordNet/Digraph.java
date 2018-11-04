/**
 * Class for digraph.
 */
public class Digraph {
    /**
     *  number of vertices in this digraph.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * vertex.
     */
    private final int v;
    /**
     * number of edges in this digraph.
     */
    private int e;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      v1     { vertex }
     */
    public Digraph(final int v1) {

        this.v = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    /**
     * returns no. of vertexes.
     * Time complexity is O(1).
     *
     * @return     { vertexes }
     */
    public int vertex() {
        return v;
    }

    /**
     * no. of edges.
     * Time complexity is O(1).
     *
     * @return     { edges }
     */
    public int edges() {
        return e;
    }

    /**
     * Adds an edge.
     * Time complexity is O(1).
     *
     * @param      v1    { vertex1 }
     * @param      w1     { vertex2 }
     */
    public void addEdge(final int v1, final int w1) {

        adj[v1].add(w1);
        e++;
    }

    /**
     * returns every value using iterator.
     * Time complexity is O(v).
     *
     * @param      v1     { vertex }
     *
     * @return     { a value }
     */
    public Iterable<Integer> adj(final int v1) {

        return adj[v1];
    }

     /**
      * Returns the number of directed edges incident from vertex {@code v}.
      * This is known as the <em>outdegree</em> of vertex {@code v}.
      *ime complexity is O(1).
      * @param  v1 the vertex
      * @return the outdegree of vertex {@code v}
      * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
     public int outdegree(final int v1) {
        //validateVertex(v);
        return adj[v1].size();
    }

    /**
     * finds if multiple roots are present.
     * ime complexity is O(V).
     *
     * @return     { true or false }.
     */
    public boolean multipleroots() {
        int num = 0;
        for (int i = 0; i < vertex(); i++) {
            if (outdegree(i) == 0) {
                num++;

            }
        }
        if (num > 1) {
            return true;
        }
        return false;

    }

    /**
     * Returns a string representation of the object.
     *ime complexity is O(V+E).
     *
     * @return     String representation of the object.
     */
     public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v + " vertices, " + e + " edges " + NEWLINE);
        for (int i = 0; i < v; i++) {
            s.append(String.format("%d: ", i));
            for (int w : adj[i]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}








