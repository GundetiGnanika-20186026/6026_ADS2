/**
 * Class for digraph.
 */
public class Digraph {
	/**
	 *  number of vertices in this digraph.
	 */

	private final int V;
	/**
	 * number of edges in this digraph.
	 */
	private int E;
	/**
	 * adj[v] = adjacency list for vertex v.
	 */
	private Bag<Integer>[] adj;
	/**
	 * indegree[v] = indegree of vertex v.
	 */
	private int[] indegree;
	/**
	 * Constructs the object.
	 *
	 * @param      V     { vertex }
	 */
	public Digraph(final int V) {

		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	/**
	 * returns no. of vertexes.
	 *
	 * @return     { vertexes }
	 */
	public int V() {
		return V;
	}

	/**
	 * no. of edges.
	 *
	 * @return     { edges }
	 */
	public int E() {
		return E;
	}

	/**
	 * Adds an edge.
	 *
	 * @param      v     { vertex1 }
	 * @param      w     { vertex2 }
	 */
	public void addEdge(final int v, final int w) {

		adj[v].add(w);
		indegree[w]++;
		E++;
	}

	/**
	 * returns every value using iterator.
	 *
	 * @param      v     { vertex }
	 *
	 * @return     { a value }
	 */
	public Iterable<Integer> adj(final int v) {

		return adj[v];
	}

	// public int outdegree(final int v) {

	//     return adj[v].size();
	// }


	// public int indegree(final int v) {

	//     return indegree[v];
	// }



}