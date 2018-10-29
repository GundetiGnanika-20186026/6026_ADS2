import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     *  function for number of vertices .
     *
     * @return     { vertices }
     */
    int totalVertices();
    /**
     *  function for number of edges .
     *
     * @return     { total edges }
     */
    int totalEdges();
    /**
     * Adds an edge.
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     */
    void addEdge(int v, int w);
    /**
     *  function to get vertices adjacent to v .
     *
     * @param      v     { vertex }
     *
     * @return     { vertex }
     */
    Iterable<Integer> adj(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}

//////////////////////////////////////////////////////////////////////////////

/**
 * List of adjacencies.
 */
class AdjacencyList implements Graph {
    /**
     *  Bags array .
     */
    private Bag<Integer>[] bags;
    /**
     *  vertex value .
     */
    private int vertices;
    /**
     * edge num .
     */
    private int edges;
    /**
     * Constructs the object.
     *
     * @param      vertex  The vertex
     */
    AdjacencyList(final int vertex) {
        this.vertices = vertex;
        bags = (Bag<Integer>[]) new Bag[vertex];
        for (int l = 0; l < vertex; l++) {
            bags[l] = new Bag();
        }
        this.edges = 0;
    }
    /**
     * number of vertices .
     * its complexity is O(1).
     *
     * @return     { total vertices }
     */
    public int totalVertices() {
        return this.vertices;
    }
    /**
     *  function for number of edges .
     *  its complexity is O(1).
     *
     * @return     { total edges }
     */
    public int totalEdges() {
        return this.edges;
    }
    /**
     * Adds an edge.
     * its complexity is O(1).
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     */
    public void addEdge(final int v, final int w) {
        edges++;
        if (v == w || hasEdge(v, w)) {
            edges--;
        }
        bags[v].add(w);
        bags[w].add(v);
    }
    /**
     * Determines if it has edge.
     * its complexity is O(N).
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (Integer val : bags[v]) {
            if (val == w) {
                return true;
            }
        }
        return false;
    }
    /**
     * { function for Iterator }.
     * its complexity is O(N).
     *
     * @param      v     { vertex }
     *
     * @return     {queue}
     */
    public Iterable<Integer> adj(final int v) {
        Queue<Integer> queue = new Queue<>();
        for (Integer val : bags[v]) {
            queue.enqueue(val);
        }
        return queue;
    }
    /**
     * Returns a string representation of the object.
     * its complexity is O(1).
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (edges == 0) {
            System.out.println(vertices + " vertices, "
                               + edges + " edges");
            System.out.println("No edges");
            return null;
        }
        System.out.println(vertices + " vertices, "
                           + edges + " edges");
        return null;
    }
}






//////////////////////////////////////////////////////////////////////////////
/**
 * Class for adj matrix graph.
 */
class AdjMatrixGraph implements Graph {
    /**
     * No. of vertixes.
     */
    private int vertices;
    /**
     * No. of edges.
     */
    private int edges;
    /**
     * two dimensional matrix.
     */
    private int[][] matrix;
    /**
     * Constructs the object.
     *
     * @param      vertical  The vertical
     */
    AdjMatrixGraph(final int vertical) {
        this.vertices = vertical;
        this.edges = 0;
        matrix = new int[vertical][vertical];
    }

    /**
     * returns no. of vertixes.
     * its complexity is O(1).
     *
     * @return  count of vertices.
     */
    public int totalVertices() {
        return vertices;
    }

    /**
     * returns no. of edges.
     * its complexity is O(1).
     *
     * @return  count of edges.
     */
    public int totalEdges() {
        return edges;
    }

    /**
     * Adds an edge.
     * its complexity is O(1).
     *
     * @param      v     { vertex v }
     * @param      w     {  vertex w }
     */
    public void addEdge(final int v, final int w) {
        if (v == w || hasEdge(v, w)) {
            return;
        }
        matrix[v][w] = 1;
        matrix[w][v] = 1;
        edges++;

    }

    /**
     * { will iterate through the vertexes }
     * its complexity is O(N).
     *
     * @param      v     { vertexes }
     *
     * @return     { null }
     */
    public Iterable<Integer> adj(final int v) {
        return null;
    }

    /**
     * Determines if it has edge.
     * its complexity is O(1).
     *
     * @param      v     { vertex1 }
     * @param      w     { vertex2 }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        return matrix[v][w] == 1;
    }

    /**
     * prints the matrix.
     * its complexity is O(n^2).
     */
    public void print() {
        if (edges == 0) {
            System.out.println(vertices + " vertices, " + edges + " edges");
            System.out.println("No edges");
            return;

        }
        System.out.println(vertices + " vertices, " + edges + " edges");
        for (int i = 0; i < vertices; i++) {
            String str = "";
            for (int j = 0; j < vertices; j++) {
                str += matrix[i][j] + " ";

            }
            System.out.println(str);
        }
    }



}



/**
 * Solution class.
 */
final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cmd = scan.nextLine();
        int vertexNum = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
        String[] places = scan.nextLine().split(",");
        switch (cmd) {
        case "List" :
            AdjacencyList listobj = new AdjacencyList(vertexNum);
            for (int k = 0; k < edges; k++) {
                String[] edgesval = scan.nextLine().split(" ");
                listobj.addEdge(Integer.parseInt(edgesval[0]),
                                Integer.parseInt(edgesval[1]));
            }
            listobj.toString();
            for (int j = 0; j < vertexNum; j++) {
                String str = "";
                if (listobj.totalEdges() == 0) {
                    break;
                }
                str = str + places[j] + ": ";
                for (Integer each : listobj.adj(j)) {
                    str = str + places[each] + " ";
                }
                System.out.println(str);
            }

            break;
        case "Matrix" :

            AdjMatrixGraph obj = new AdjMatrixGraph(vertexNum);

            for (int i = 0; i < edges; i++) {
                String[] input = scan.nextLine().split(" ");
obj.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }
            obj.print();
            break;
        default:
            break;

        }
    }
}






