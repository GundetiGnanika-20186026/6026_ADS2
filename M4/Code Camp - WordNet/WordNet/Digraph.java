// public class Digraph {

//     private static final String NEWLINE = System.getProperty("line.separator");

//     private final int V;           // number of vertices in this digraph
//     private int E;                 // number of edges in this digraph
//     private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
//     private int[] indegree;        // indegree[v] = indegree of vertex v

//     /**
//      * Initializes an empty digraph with <em>V</em> vertices.
//      *
//      * @param  V the number of vertices
//      * @throws IllegalArgumentException if {@code V < 0}
//      */
//     public Digraph(int V) {
//         if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
//         this.V = V;
//         this.E = 0;
//         indegree = new int[V];
//         adj = (Bag<Integer>[]) new Bag[V];
//         for (int v = 0; v < V; v++) {
//             adj[v] = new Bag<Integer>();
//         }
//     }




//     /**
//      * Returns the number of vertices in this digraph.
//      *
//      * @return the number of vertices in this digraph
//      */
//     public int V() {
//         return V;
//     }

//     /**
//      * Returns the number of edges in this digraph.
//      *
//      * @return the number of edges in this digraph
//      */
//     public int E() {
//         return E;
//     }


//     // throw an IllegalArgumentException unless {@code 0 <= v < V}
//     private void validateVertex(int v) {
//         if (v < 0 || v >= V)
//             throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
//     }

//     /**
//      * Adds the directed edge v→w to this digraph.
//      *
//      * @param  v the tail vertex
//      * @param  w the head vertex
//      * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
//      */
//     public void addEdge(int v, int w) {
//         validateVertex(v);
//         validateVertex(w);
//         adj[v].add(w);
//         indegree[w]++;
//         E++;
//     }

//     /**
//      * Returns the vertices adjacent from vertex {@code v} in this digraph.
//      *
//      * @param  v the vertex
//      * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public Iterable<Integer> adj(int v) {
//         validateVertex(v);
//         return adj[v];
//     }

//     /**
//      * Returns the number of directed edges incident from vertex {@code v}.
//      * This is known as the <em>outdegree</em> of vertex {@code v}.
//      *
//      * @param  v the vertex
//      * @return the outdegree of vertex {@code v}
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public int outdegree(int v) {
//         validateVertex(v);
//         return adj[v].size();
//     }




//     public boolean multipleroots() {
//         int num = 0;
//         for (int i = 0; i < V(); i++) {
//             if (outdegree(i) == 0) {
//                 num ++;

//             }
//         }
//         if(num > 1)
//             return true;
//         return false;

//     }

//     public String toString() {
//         StringBuilder s = new StringBuilder();
//         s.append(V + " vertices, " + E + " edges " + NEWLINE);
//         for (int v = 0; v < V; v++) {
//             s.append(String.format("%d: ", v));
//             for (int w : adj[v]) {
//                 s.append(String.format("%d ", w));
//             }
//             s.append(NEWLINE);
//         }
//         return s.toString();
//     }
// }
//
//
/**
 * Class for digraph.
 */
public class Digraph {
    /**
     *  number of vertices in this digraph.
     */
    private static final String NEWLINE = System.getProperty("line.separator");

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
      *
      * @param  v the vertex
      * @return the outdegree of vertex {@code v}
      * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
     public int outdegree(int v) {
        //validateVertex(v);
        return adj[v].size();
    }

    public boolean multipleroots() {
        int num = 0;
        for (int i = 0; i < vertex(); i++) {
            if (outdegree(i) == 0) {
                num ++;

            }
        }
        if(num > 1)
            return true;
        return false;

    }

    /**
     * Returns a string representation of the object.
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

