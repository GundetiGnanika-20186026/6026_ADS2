import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for graph.
 */
public class Graph {
    /**
     * { newline }.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * { vertexes }.
     */
    private final int V;
    /**
     * { edges }.
     */
    private int E;
    /**
     * { matrix of two dimensional }.
     */
    private boolean[][] adj;

    // empty graph with V vertices

    /**
     * Constructs the object.
     *
     * @param      V     { parameter_description }
     */
    public Graph(final int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    // and edges

    /**
     * {  number of vertices }.
     *
     * @return     { v }
     */
    public int V() { return V; }
    /**
     * {  number of edges }.
     *
     * @return     { e }
     */
    public int E() { return E; }


    // add undirected edge v-w

    /**
     * Adds an edge.
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     */
    public void addEdge(final int v, final int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }



    /**
     * does the graph contain the edge v-w?.
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     *
     * @return     { boolean }
     */
    public boolean contains(final int v, final int w) {
        return adj[v][w];
    }

    // return list of neighbors of v

    /**
     * return list of neighbors of v.
     *
     * @param      v     { vertex }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return new AdjIterator(v);
    }

    // support iteration over graph vertices

    /**
     * Class for adj iterator.
     */
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        /**
         * { vertex }
         */
        private int v;
        /**
         * { edge }
         */
        private int w = 0;
        /**
         * Constructs the object.
         *
         * @param      v     { vertex }
         */
        AdjIterator(int v) {
            this.v = v;
        }

        /**
         * { iterates through the graph }.
         *
         * @return     { item present }
         */
        public Iterator<Integer> iterator() {
            return this;
        }

        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        /**
         * { returns next value }
         *
         * @return     { integer }
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
        // /**
        //  * {  }
        //  */
        // public void remove()  {
        //     throw new UnsupportedOperationException();
        // }
    }


    // string representation of Graph - takes quadratic time
    // public String toString() {
    //     StringBuilder s = new StringBuilder();
    //     s.append(V + " " + E + NEWLINE);
    //     for (int v = 0; v < V; v++) {
    //         s.append(v + ": ");
    //         for (int w : adj(v)) {
    //             s.append(w + " ");
    //         }
    //         s.append(NEWLINE);
    //     }
    //     return s.toString();
    // }

}