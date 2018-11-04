/**
 * Class for breadth first path.
 */
class BreadthFirstPath {
    /**
     * max value.
     */
    private static final int INFINITY = Integer.MAX_VALUE;

    /**
     * // marked[v] = is there an s-v path.
     */
    private boolean[] marked;
    /**
     * // edgeTo[v] = previous edge on shortest s-v path.
     */
    private int[] edgeTo;
    /**
     * // distTo[v] = number of edges shortest s-v path.
     */
    private int[] distTo;

    /**
     * Computes the shortest path between the source vertex {@code s}
     * and every other vertex in the graph {@code G}.
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public BreadthFirstPath(final Digraph G, final int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        //validateVertex(s);
        bfs(G, s);

        // assert check(G, s);
    }
    /**
    *  // breadth-first search from a single source
    *
    * @param      G     { graph }.
    * @param      s     {  sourse}.
    */
    private void bfs(final Digraph G, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    // breadth-first search from multiple sources
    // private void bfs(Digraph G, Iterable<Integer> sources) {
    //     Queue<Integer> q = new Queue<Integer>();
    //     for (int s : sources) {
    //         marked[s] = true;
    //         distTo[s] = 0;
    //         q.enqueue(s);
    //     }
    //     while (!q.isEmpty()) {
    //         int v = q.dequeue();
    //         for (int w : G.adj(v)) {
    //             if (!marked[w]) {
    //                 edgeTo[w] = v;
    //                 distTo[w] = distTo[v] + 1;
    //                 marked[w] = true;
    //                 q.enqueue(w);
    //             }
    //         }
    //     }
    // }

    /**
     * Is there a path between the source vertex {@code s} (or sources) and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, and {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        //validateVertex(v);
        return marked[v];
    }

    /**
     * Returns the number of edges in a shortest path between the source vertex {@code s}
     * (or sources) and vertex {@code v}?
     * @param v the vertex
     * @return the number of edges in a shortest path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int distTo(int v) {
        //validateVertex(v);
        return distTo[v];
    }







    // // throw an IllegalArgumentException unless {@code 0 <= v < V}
    // private void validateVertices(Iterable<Integer> vertices) {
    //     if (vertices == null) {
    //         throw new IllegalArgumentException("argument is null");
    //     }
    //     int V = marked.length;
    //     for (int v : vertices) {
    //         if (v < 0 || v >= V) {
    //             throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    //         }
    //     }
    // }
}

