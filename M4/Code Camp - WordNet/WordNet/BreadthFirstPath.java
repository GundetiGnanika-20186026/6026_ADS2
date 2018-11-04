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
     * Computes the shortest path between the source vertex {@code s}.
     * and every other vertex in the graph {@code G}.
     * @param graph the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public BreadthFirstPath(final Digraph graph, final int s) {
        marked = new boolean[graph.vertex()];
        distTo = new int[graph.vertex()];
        edgeTo = new int[graph.vertex()];
        //validateVertex(s);
        bfs(graph, s);

        // assert check(G, s);
    }
    /**
    *  // breadth-first search from a single source.
     *  its complexity is O(V+E).
    *
    * @param      graph     { graph }.
    * @param      s     {  sourse}.
    */
    private void bfs(final Digraph graph, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < graph.vertex(); v++) {
            distTo[v] = INFINITY;
        }
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }



    /**
     * Is there a path between the source.
     *  vertex {@code s} (or sources) and vertex {@code v}?
     * @param v the vertex
     *  its complexity is O(1).
     * @return {@code true} if there is a path, and {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(final int v) {
        //validateVertex(v);
        return marked[v];
    }

    /**
     * {Returns the number of edges in a shortest
     *  path between the source vertex {@code s}
     * (or sources) and vertex {@code v}?}.
     *  its complexity is O(1).
     * @param v the vertex
     * @return the number of edges in a shortest path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int distTo(final int v) {
        //validateVertex(v);
        return distTo[v];
    }






}

