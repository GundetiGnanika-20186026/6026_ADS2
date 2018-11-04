/**
 * Class for directed cycle.
 */
class DirectedCycle {
    /**
     * marked[v] = has vertex v been marked?.
     */
    private boolean[] marked;
    /**
     * edgeTo[v] = previous vertex on path to v.
     */
    private int[] edgeTo;
    /**
     * onStack[v] = is vertex on the stack?.
     */
    private boolean[] onStack;
    /**
     * directed cycle (or null if no such cycle).
     */
    private Stack<Integer> cycle;

    /**
     * Constructs the object.
     *
     * @param      g1     { graph }
     */
    DirectedCycle(final Digraph g1) {
        marked  = new boolean[g1.V()];
        onStack = new boolean[g1.V()];
        edgeTo  = new int[g1.V()];
        for (int v = 0; v < g1.V(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(g1, v);
            }
        }
    }

    // check that algorithm computes either the topological
    // order or finds a directed cycle

    /**
     * depth first search.
     * Time complexity for this method is O(E)
     *
     * @param      g2     { graph }
     * @param      v     { vertex }
     */
    private void dfs(final Digraph g2, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g2.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g2, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    /**
     * Determines if it has cycle.
     * Time complexity for this method is O(1).
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }



}
