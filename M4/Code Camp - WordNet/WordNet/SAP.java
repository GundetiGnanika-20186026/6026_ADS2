import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
/**
 * Class for sap.
 */
public class SAP {
    /**
     * graph
     */
    private Digraph graph;

    // constructor takes a digraph (not necessarily a DAG)

    /**
     * Constructs the object.
     *
     * @param      graph1  The graph
     */
    public SAP(Digraph graph1) {
        this.graph = graph1;

    }



    /**
    // length of shortest ancestral path between v and w; -1 if no such path
     *
     *
     * @param      arraylist1  The arraylist 1
     * @param      arraylist2  The arraylist 2
     * @param      synset      The synset
     */
    public void length(final ArrayList<Integer> arraylist1, final ArrayList<Integer> arraylist2,
                      final  HashMap<Integer, String[]> synset) {
        int distance = 0;
        int max = Integer.MAX_VALUE;
        String[] a = null;
        for (int i = 0; i < arraylist1.size(); i++) {
            for (int j = 0; j < arraylist2.size(); j++) {
BreadthFirstPath bfsVer1 = new BreadthFirstPath(graph, arraylist1.get(i));
BreadthFirstPath bfsVer2 = new BreadthFirstPath(graph, arraylist2.get(j));
                for (int k = 0; k < graph.vertex(); k++) {
                    if (bfsVer1.hasPathTo(k) && bfsVer2.hasPathTo(k)) {
                        distance = bfsVer1.distTo(k) + bfsVer2.distTo(k);
                        // System.out.println(distance);
                        if (distance < max) {
                            max = distance;
                            a = synset.get(k);

                        }
                    }

                }

            }
        }
        StringBuilder ancestor = new StringBuilder();

        for (int i = 0; i < a.length - 1; i++) {
            ancestor.append(a[i]).append(" ");
        }
        ancestor.append(a[a.length - 1]);


        System.out.println("distance = " + max + ", ancestor = " + ancestor);


    }
}