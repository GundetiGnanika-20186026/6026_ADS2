public class DepthFirstPaths {
    /**
     * marked[v] = is there an s-v path?.
     */
    private boolean[] marked;
    /**
     * edgeTo[v] = last edge on s-v path.
     */
    private int[] edgeTo;
    /**
     * source vertex.
     */
    private final int s;
    /**
     * Constructs the object.
     *
     * @param      G     { graph }
     * @param      s     { source }
     */

    public DepthFirstPaths(final Graph G, final int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];

        dfs(G, s);
    }

    /**
     *  depth first search from v.
     *
     * @param      G     { Graph }
     * @param      v     { vertex }
     */
    private void dfs(final Graph G, final int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * Determines if it has path to.
     *
     * @param      v     { vertex }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {

        return marked[v];
    }


}