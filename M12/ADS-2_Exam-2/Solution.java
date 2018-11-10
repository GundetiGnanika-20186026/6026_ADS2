import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     * for taking input the complexity is O(E).
     * we are using dijxtras algorithm whose
     *  complexity in worst case is O(Elog(V)).
     *
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner scan = new Scanner(System.in);
        int vertexes = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
    EdgeWeightedGraph graphobj = new  EdgeWeightedGraph(vertexes);
        for (int i = 0; i < edges; i++) {
            String[] input = scan.nextLine().split(" ");
            Edge obj = new Edge(Integer.parseInt(input[0]),
                                Integer.parseInt(input[1]),
                                 Double.parseDouble(input[2]));
            graphobj.addEdge(obj);

        }
        String query = scan.nextLine();
        switch (query) {
        case "Graph":
            System.out.println(graphobj);
            break;

        case "DirectedPaths":
    // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] paths = scan.nextLine().split(" ");
            DijkstraSP dis = new DijkstraSP(graphobj,
             Integer.parseInt(paths[0]));
            if (!dis.hasPathTo(Integer.parseInt(paths[1]))) {
                System.out.println("No Path Found.");
            } else {
        System.out.println(dis.path(Integer.parseInt(paths[1])));
            }
            break;

        case "ViaPaths":

        // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is the via is the one
            // where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] path2 = scan.nextLine().split(" ");
            DijkstraSP dis1 = new DijkstraSP(graphobj,
             Integer.parseInt(path2[0]));
            if (!dis1.hasPathTo(Integer.parseInt(path2[2]))) {
                System.out.println("No Path Found.");
            } else {

            //System.out.println(Arrays.toString(dis1.my));
         System.out.println(dis1.path(Integer.parseInt(path2[2])));


            }


            break;

        default:
            break;
        }

    }
}
