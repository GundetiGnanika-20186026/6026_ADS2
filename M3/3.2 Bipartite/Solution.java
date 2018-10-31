import java.util.Scanner;
class Bipartite {
    private boolean isBipartite;   // is the graph bipartite?
    private boolean[] color;       // color[v] gives vertices on one side of bipartition
    private boolean[] marked;      // marked[v] = true iff v has been visited in DFS
    private int[] edgeTo;          // edgeTo[v] = last edge on path to v
    private Stack<Integer> cycle;  // odd-length cycle
    public Bipartite(Graph G) {
        isBipartite = true;
        color  = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
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


    public boolean color(int v) {
       // validateVertex(v);
        if (!isBipartite)
            throw new UnsupportedOperationException("graph is not bipartite");
        return color[v];
    }

    public Iterable<Integer> oddCycle() {
        return cycle;
    }

    // private boolean check(ginal Graph G) {
    //     // graph is bipartite
    //     if (isBipartite) {
    //         for (int v = 0; v < G.V(); v++) {
    //             for (int w : G.adj(v)) {
    //                 if (color[v] == color[w]) {
    //                     System.err.printf("edge %d-%d with %d and %d in same side of bipartition\n", v, w, v, w);
    //                     return false;
    //                 }
    //             }
    //         }
    //     } else {
    //         // verify cycle
    //         int first = -1, last = -1;
    //         for (int v : oddCycle()) {
    //             if (first == -1) first = v;
    //             last = v;
    //         }
    //         if (first != last) {
    //             System.err.printf("cycle begins with %d and ends with %d\n", first, last);
    //             return false;
    //         }
    //     }

    //     return true;
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