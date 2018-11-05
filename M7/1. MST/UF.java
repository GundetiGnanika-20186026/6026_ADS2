// public class UF {

//     private int[] parent;  // parent[i] = parent of i
//     private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
//     private int count;     // number of components

//     /**
//      * Initializes an empty union–find data structure with {@code n} sites
//      * {@code 0} through {@code n-1}. Each site is initially in its own
//      * component.
//      *
//      * @param  n the number of sites
//      * @throws IllegalArgumentException if {@code n < 0}
//      */
//     public UF(int n) {
//         if (n < 0) throw new IllegalArgumentException();
//         count = n;
//         parent = new int[n];
//         rank = new byte[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//             rank[i] = 0;
//         }
//     }

//     /**
//      * Returns the component identifier for the component containing site {@code p}.
//      *
//      * @param  p the integer representing one site
//      * @return the component identifier for the component containing site {@code p}
//      * @throws IllegalArgumentException unless {@code 0 <= p < n}
//      */
//     public int find(int p) {
//         validate(p);
//         while (p != parent[p]) {
//             parent[p] = parent[parent[p]];    // path compression by halving
//             p = parent[p];
//         }
//         return p;
//     }

//     /**
//      * Returns the number of components.
//      *
//      * @return the number of components (between {@code 1} and {@code n})
//      */
//     public int count() {
//         return count;
//     }

//     /**
//      * Returns true if the the two sites are in the same component.
//      *
//      * @param  p the integer representing one site
//      * @param  q the integer representing the other site
//      * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
//      *         {@code false} otherwise
//      * @throws IllegalArgumentException unless
//      *         both {@code 0 <= p < n} and {@code 0 <= q < n}
//      */
//     public boolean connected(int p, int q) {
//         return find(p) == find(q);
//     }

//     /**
//      * Merges the component containing site {@code p} with the
//      * the component containing site {@code q}.
//      *
//      * @param  p the integer representing one site
//      * @param  q the integer representing the other site
//      * @throws IllegalArgumentException unless
//      *         both {@code 0 <= p < n} and {@code 0 <= q < n}
//      */
//     public void union(int p, int q) {
//         int rootP = find(p);
//         int rootQ = find(q);
//         if (rootP == rootQ) return;

//         // make root of smaller rank point to root of larger rank
//         if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
//         else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
//         else {
//             parent[rootQ] = rootP;
//             rank[rootP]++;
//         }
//         count--;
//     }

//     // validate that p is a valid index
//     private void validate(int p) {
//         int n = parent.length;
//         if (p < 0 || p >= n) {
//             throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
//         }
//     }

//     // /**
//     //  * Reads in a an integer {@code n} and a sequence of pairs of integers
//     //  * (between {@code 0} and {@code n-1}) from standard input, where each integer
//     //  * in the pair represents some site;
//     //  * if the sites are in different components, merge the two components
//     //  * and print the pair to standard output.
//     //  *
//     //  * @param args the command-line arguments
//     //  */
//     // public static void main(String[] args) {
//     //     int n = StdIn.readInt();
//     //     UF uf = new UF(n);
//     //     while (!StdIn.isEmpty()) {
//     //         int p = StdIn.readInt();
//     //         int q = StdIn.readInt();
//     //         if (uf.connected(p, q)) continue;
//     //         uf.union(p, q);
//     //         StdOut.println(p + " " + q);
//     //     }
//     //     StdOut.println(uf.count() + " components");
//     // }
// }
//
//


/**
 * Class for uf.
 */
public class UF {
    /**
     * parent array of integer type.
     */
    private int[] parent;
    /**
     * rank array of byte type.
     */
    private byte[] rank;
    /**
     * integer variable.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      n   integer variable.
     */
    public UF(final int n) {
        if (n < 0) {
            throw new
            IllegalArgumentException();
        }
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    /**
     * Searches for the first match.
     *
     * @param      p     integer variable.
     *
     * @return parent.
     */
    public int find(final int p) {
        validate(p);
        int x = p;
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites
     *  {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(final int p, final int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }
    /**
     * validate method.
     *
     * @param      p     { parameter_description }
     */
    private void validate(final int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException(
                "index " + p + " is not between 0 and "
                 + (n - 1));
        }
    }
}


