/**
 * Class for digraph.
 */
public class Digraph {
	/**
	 *  number of vertices in this digraph.
	 */

	private final int v;
	/**
	 * number of edges in this digraph.
	 */
	private int E;
	/**
	 * adj[v] = adjacency list for vertex v.
	 */
	private Bag<Integer>[] adj;
	// /**
	//  * indegree[v] = indegree of vertex v.
	//  */
	// private int[] indegree;
	/**
	 * Constructs the object.
	 *
	 * @param      v1     { vertex }
	 */
	public Digraph(final int v1) {

		this.v = v1;
		this.E = 0;
		//indegree = new int[V];
		adj = (Bag<Integer>[]) new Bag[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	/**
	 * returns no. of vertexes.
	 *
	 * @return     { vertexes }
	 */
	public int V() {
		return v;
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
		//indegree[w]++;
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





}