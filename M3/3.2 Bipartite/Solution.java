import java.util.Scanner;
/**
 * Class for bipartite.
 */
class Bipartite {
	/**
	 * is the graph bipartite?
	 */
    private boolean isBipartite;
    /**
     *  // color[v] gives vertices on one side of bipartition.
     */
    private boolean[] color;
    /**
     *  // marked[v] = true iff v has been visited in DFS.
     */
    private boolean[] marked;
    /**
     * // edgeTo[v] = last edge on path to v.
     */
    private int[] edgeTo;
    /**
     *  // odd-length cycle.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object.
     *
     * @param      G     { graph }
     */
    public Bipartite(Graph g1) {
        isBipartite = true;
        color  = new boolean[g1.V()];
        marked = new boolean[g1.V()];
        edgeTo = new int[g1.V()];

        for (int v = 0; v < g1.V(); v++) {
            if (!marked[v]) {
                dfs(g1, v);
            }
        }
        //assert check(G);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if odd-length cycle found
            if (cycle != null) return;

            // found uncolored vertex, so recur
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(G, w);
            }

            // if v-w create an odd-length cycle, find it
            else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);  // don't need this unless you want to include start vertex twice
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }


    public boolean color(int v1) {
       // validateVertex(v);
        if (!isBipartite)
            throw new UnsupportedOperationException("graph is not bipartite");
        return color[v1];
    }

    // public Iterable<Integer> oddCycle() {
    //     return cycle;
    // }


}

////////////////////////////////////////////////////////////////////////////////

/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution(){

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertexes = Integer.parseInt(scan.nextLine());
		int edges = Integer.parseInt(scan.nextLine());
		Graph graphobj = new Graph(vertexes);
		while(scan.hasNext()){
		    String[] array = scan.nextLine().split(" ");
		    graphobj.addEdge(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
		}
		Bipartite b = new Bipartite(graphobj);
		if(b.isBipartite()){
			System.out.println("Graph is bipartite");
		} else {
			System.out.println("Graph is not a bipartite");
		}

	}
}