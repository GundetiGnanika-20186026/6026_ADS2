// /*************************************************************************
//  *  Compilation:  javac Graph.java
//  *  Execution:    java Graph input.txt
//  *  Dependencies: Bag.java In.java StdOut.java
//  *  Data files:   http://algs4.cs.princeton.edu/41undirected/tinyG.txt
//  *
//  *  A graph, implemented using an array of sets.
//  *  Parallel edges and self-loops allowed.
//  *
//  *  % java Graph tinyG.txt
//  *  13 vertices, 13 edges
//  *  0: 6 2 1 5
//  *  1: 0
//  *  2: 0
//  *  3: 5 4
//  *  4: 5 6 3
//  *  5: 3 4 0
//  *  6: 0 4
//  *  7: 8
//  *  8: 7
//  *  9: 11 10 12
//  *  10: 9
//  *  11: 9 12
//  *  12: 11 9
//  *
//  *  % java Graph mediumG.txt
//  *  250 vertices, 1273 edges
//  *  0: 225 222 211 209 204 202 191 176 163 160 149 114 97 80 68 59 58 49 44 24 15
//  *  1: 220 203 200 194 189 164 150 130 107 72
//  *  2: 141 110 108 86 79 51 42 18 14
//  *  ...
//  *
//  *************************************************************************/


// /**
//  *  The <tt>Graph</tt> class represents an undirected graph of vertices
//  *  named 0 through V-1.
//  *  It supports the following operations: add an edge to the graph,
//  *  iterate over all of the neighbors adjacent to a vertex.
//  *  Parallel edges and self-loops are permitted.
//  *  <p>
//  *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/51undirected">Section 5.1</a> of
//  *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
//  */
// public class Graph {
//     private final int V;
//     private int E;
//     private Bag<Integer>[] adj;

//    /**
//      * Create an empty graph with V vertices.
//      */
//     public Graph(int V) {
//         if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
//         this.V = V;
//         this.E = 0;
//         adj = (Bag<Integer>[]) new Bag[V];
//         for (int v = 0; v < V; v++) {
//             adj[v] = new Bag<Integer>();
//         }
//     }

//    /**
//      * Create a random graph with V vertices and E edges.
//      * Expected running time is proportional to V + E.
//      */
//     public Graph(int V, int E) {
//         this(V);
//         if (E < 0) throw new RuntimeException("Number of edges must be nonnegative");
//         for (int i = 0; i < E; i++) {
//             int v = (int) (Math.random() * V);
//             int w = (int) (Math.random() * V);
//             addEdge(v, w);
//         }
//     }

//    /**
//      * Create a digraph from input stream.
//      */
// /*    public Graph(In in) {
//         this(in.readInt());
//         int E = in.readInt();
//         for (int i = 0; i < E; i++) {
//             int v = in.readInt();
//             int w = in.readInt();
//             addEdge(v, w);
//         }
//     }*/

//    /**
//      * Copy constructor.
//      */
// /*    public Graph(Graph G) {
//         this(G.V());
//         this.E = G.E();
//         for (int v = 0; v < G.V(); v++) {
//             // reverse so that adjacency list is in same order as original
//             Stack<Integer> reverse = new Stack<Integer>();
//             for (int w : G.adj[v]) {
//                 reverse.push(w);
//             }
//             for (int w : reverse) {
//                 adj[v].add(w);
//             }
//         }
//     }*/

//    /**
//      * Return the number of vertices in the graph.
//      */
//     public int V() { return V; }

//    /**
//      * Return the number of edges in the graph.
//      */
//     public int E() { return E; }


//    /**
//      * Add the edge v-w to graph.
//      */
//     public void addEdge(int v, int w) {
//         E++;
//         adj[v].add(w);
//         adj[w].add(v);
//     }


//    /**
//      * Return the list of neighbors of vertex v as in Iterable.
//      */
//     public Iterable<Integer> adj(int v) {
//         return adj[v];
//     }


//    /**
//      * Return a string representation of the graph.
//      */
//     public String toString() {
//         StringBuilder s = new StringBuilder();
//         String NEWLINE = System.getProperty("line.separator");
//         s.append(V + " vertices, " + E + " edges " + NEWLINE);
//         for (int v = 0; v < V; v++) {
//             s.append(v + ": ");
//             for (int w : adj[v]) {
//                 s.append(w + " ");
//             }
//             s.append(NEWLINE);
//         }
//         return s.toString();
//     }

// }

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
     * its complexity is O(1).
     *
     * @return     { v }
     */
    public int V() { return V; }
    /**
     * {  number of edges }.
     * its complexity is O(1).
     *
     * @return     { e }
     */
    public int E() { return E; }


    // add undirected edge v-w

    /**
     * Adds an edge.
     * its complexity is O(1).
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     */
    public void addEdge(final int v, final int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }



    // /**
    //  * does the graph contain the edge v-w?.
    //  * its complexity is O(1).
    //  *
    //  * @param      v     { vertex1 }
    //  * @param      w     { vertex2 }
    //  *
    //  * @return     { boolean }
    //  */
    // public boolean contains(final int v, final int w) {
    //     return adj[v][w];
    // }

    // // return list of neighbors of v

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
         * its complexity is O(n).
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

    }



}
