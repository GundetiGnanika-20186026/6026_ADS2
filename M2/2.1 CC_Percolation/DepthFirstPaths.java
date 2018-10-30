/**
 * Class for depth first paths.
 */
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

    public DepthFirstPaths(final Graph G, final int s1) {
        this.s = s1;
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
    private void dfs(final Graph g1, final int v) {
        marked[v] = true;
        for (int w : g1.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g1, w);
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