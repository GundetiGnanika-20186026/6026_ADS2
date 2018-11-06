// public class DijkstraSP {
//     private double[] distTo;          // distTo[v] = distance  of shortest s->v path
//     private Edge[] edgeTo;    // edgeTo[v] = last edge on shortest s->v path
//     private IndexMinPQ<Double> pq;    // priority queue of vertices

//     /**
//      * Computes a shortest-paths tree from the source vertex {@code s} to every other
//      * vertex in the edge-weighted digraph {@code G}.
//      *
//      * @param  G the edge-weighted digraph
//      * @param  s the source vertex
//      * @throws IllegalArgumentException if an edge weight is negative
//      * @throws IllegalArgumentException unless {@code 0 <= s < V}
//      */
//     public DijkstraSP(EdgeWeightedGraph G, int s) {
//         for (Edge e : G.edges()) {
//             if (e.weight() < 0)
//                 throw new IllegalArgumentException("edge " + e + " has negative weight");
//         }

//         distTo = new double[G.V()];
//         edgeTo = new Edge[G.V()];

//         validateVertex(s);

//         for (int v = 0; v < G.V(); v++)
//             distTo[v] = Double.POSITIVE_INFINITY;
//         distTo[s] = 0.0;

//         // relax vertices in order of distance from s
//         pq = new IndexMinPQ<Double>(G.V());
//         pq.insert(s, distTo[s]);
//         while (!pq.isEmpty()) {
//             int v = pq.delMin();
//             for (Edge e : G.adj(v))
//                 relax(e);
//         }

//         // check optimality conditions
//         //assert check(G, s);
//     }

//     // relax edge e and update pq if changed
//     private void relax(Edge e) {
//         int v = e.either(), w = e.other(v);
//         if (distTo[w] > distTo[v] + e.weight()) {
//             distTo[w] = distTo[v] + e.weight();
//             edgeTo[w] = e;
//             if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
//             else                pq.insert(w, distTo[w]);
//         }
//     }

//     /**
//      * Returns the length of a shortest path from the source vertex {@code s} to vertex {@code v}.
//      * @param  v the destination vertex
//      * @return the length of a shortest path from the source vertex {@code s} to vertex {@code v};
//      *         {@code Double.POSITIVE_INFINITY} if no such path
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public double distTo(int v) {
//         validateVertex(v);
//         return distTo[v];
//     }

//     /**
//      * Returns true if there is a path from the source vertex {@code s} to vertex {@code v}.
//      *
//      * @param  v the destination vertex
//      * @return {@code true} if there is a path from the source vertex
//      *         {@code s} to vertex {@code v}; {@code false} otherwise
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public boolean hasPathTo(int v) {
//         validateVertex(v);
//         return distTo[v] < Double.POSITIVE_INFINITY;
//     }

//     /**
//      * Returns a shortest path from the source vertex {@code s} to vertex {@code v}.
//      *
//      * @param  v the destination vertex
//      * @return a shortest path from the source vertex {@code s} to vertex {@code v}
//      *         as an iterable of edges, and {@code null} if no such path
//      * @throws IllegalArgumentException unless {@code 0 <= v < V}
//      */
//     public Iterable<Edge> pathTo(int v) {
//         validateVertex(v);
//         if (!hasPathTo(v)) return null;
//         Stack<Edge> path = new Stack<Edge>();
//         for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.either()]) {
//             path.push(e);
//         }
//         return path;
//     }


//     // check optimality conditions:
//     // (i) for all edges e:            distTo[e.to()] <= distTo[e.from()] + e.weight()
//     // (ii) for all edge e on the SPT: distTo[e.to()] == distTo[e.from()] + e.weight()
//     // private boolean check(Digraph G, int s) {

//     //     // check that edge weights are nonnegative
//     //     for (Edge e : G.edges()) {
//     //         if (e.weight() < 0) {
//     //             System.err.println("negative edge weight detected");
//     //             return false;
//     //         }
//     //     }

//     //     // check that distTo[v] and edgeTo[v] are consistent
//     //     if (distTo[s] != 0.0 || edgeTo[s] != null) {
//     //         System.err.println("distTo[s] and edgeTo[s] inconsistent");
//     //         return false;
//     //     }
//     //     for (int v = 0; v < G.V(); v++) {
//     //         if (v == s) continue;
//     //         if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
//     //             System.err.println("distTo[] and edgeTo[] inconsistent");
//     //             return false;
//     //         }
//     //     }

//     //     // check that all edges e = v->w satisfy distTo[w] <= distTo[v] + e.weight()
//     //     for (int v = 0; v < G.V(); v++) {
//     //         for (Edge e : G.adj(v)) {
//     //             int w = e.to();
//     //             if (distTo[v] + e.weight() < distTo[w]) {
//     //                 System.err.println("edge " + e + " not relaxed");
//     //                 return false;
//     //             }
//     //         }
//     //     }

//     //     // check that all edges e = v->w on SPT satisfy distTo[w] == distTo[v] + e.weight()
//     //     for (int w = 0; w < G.V(); w++) {
//     //         if (edgeTo[w] == null) continue;
//     //         Edge e = edgeTo[w];
//     //         int v = e.from();
//     //         if (w != e.to()) return false;
//     //         if (distTo[v] + e.weight() != distTo[w]) {
//     //             System.err.println("edge " + e + " on shortest path not tight");
//     //             return false;
//     //         }
//     //     }
//     //     return true;
//     // }

//     // throw an IllegalArgumentException unless {@code 0 <= v < V}
//     private void validateVertex(int v) {
//         int V = distTo.length;
//         if (v < 0 || v >= V)
//             throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
//     }

//     // /**
//     //  * Unit tests the {@code DijkstraSP} data type.
//     //  *
//     //  * @param args the command-line arguments
//     //  */
//     // public static void main(String[] args) {
//     //     In in = new In(args[0]);
//     //     EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
//     //     int s = Integer.parseInt(args[1]);

//     //     // compute shortest paths
//     //     DijkstraSP sp = new DijkstraSP(G, s);


//     //     // print shortest path
//     //     for (int t = 0; t < G.V(); t++) {
//     //         if (sp.hasPathTo(t)) {
//     //             StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
//     //             for (DirectedEdge e : sp.pathTo(t)) {
//     //                 StdOut.print(e + "   ");
//     //             }
//     //             StdOut.println();
//     //         }
//     //         else {
//     //             StdOut.printf("%d to %d         no path\n", s, t);
//     //         }
//     //     }
//     // }

// }



/**
 *the class for dijkstra's algorithm.
 *to find the shortest path.
 */
class DijkstraSP {
    /**
     *the distTo array to store.
     *distance from one vertex to another.
     */
    private Double[] distTo;
    /**
     *edge to is to store the edge connected.
     */
    private Edge[] edgeTo;
    /**
     *indexed minpq to store the key value.
     *pair.
     */
    private IndexMinPQ<Double> pq;
    /**
     *the graph object.
     */
    private EdgeWeightedGraph graph;
    /**
     *the constructor to initialize the objects.
     *the time complexity is O(E + V).
     * @param      g  graph object.
     * @param      source  The source
     */
    DijkstraSP(final EdgeWeightedGraph g,
    final int source) {
        graph = g;
        distTo = new Double[graph.V()];
        edgeTo = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[source] = 0.0;
        pq = new IndexMinPQ<Double>(graph.V());
        pq.insert(source, distTo[source]);
        while (!pq.isEmpty()) {
            int vertex = pq.delMin();
            for (Edge edge : graph.adj(vertex)) {
                relax(edge, vertex);
            }
        }
    }

    private void relax(Edge edge, int vertex) {
        int vertexTwo = edge.other(vertex);
        if (distTo[vertexTwo] > distTo[vertex] + edge.weight()) {
            distTo[vertexTwo] = distTo[vertex] + edge.weight();
            edgeTo[vertexTwo] = edge;
            if (pq.contains(vertexTwo)) {
                pq.decreaseKey(vertexTwo, distTo[vertexTwo]);
            } else {
                pq.insert(vertexTwo, distTo[vertexTwo]);
            }
        }
    }
    public double distTo(int v) {
        return distTo[v];
    }
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }
    public double distance(int vertex) {
        double sum = 0;
        for (Edge each : pathTo(vertex)) {
            sum += each.weight();
        }
        return sum;
    }
}

