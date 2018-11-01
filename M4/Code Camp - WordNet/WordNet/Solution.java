import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

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
/////////////////////////////////////////////////////

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String file1 = scan.nextLine();
		String file2 = scan.nextLine();
		HashMap<Integer, String[]> synset = new HashMap<>();
		HashMap<String, ArrayList<Integer>> queries = new HashMap<>();
        //*****************************************************************
		try {
			Scanner firstscan = new Scanner(new File("Files/" + file1));
			//putting values into synset hashmap;
			while (firstscan.hasNextLine()) {

				String[] input = firstscan.nextLine().split(",");
				String[] letter = input[1].split(" ");
				synset.put(Integer.parseInt(input[0]), letter);
			}

			for (int key : synset.keySet()) {
				String[] values = synset.get(key);
				for (int i = 0; i < values.length; i++) {

					if (queries.containsKey(values[i])) {
						ArrayList<Integer> array2 = queries.get(values[i]);
						array2.add(key);
						queries.put(values[i], array2);
					} else {
						ArrayList<Integer> array1 = new ArrayList<>();
						array1.add(key);
						queries.put(values[i], array1);
					}

				}
			}

		} catch (FileNotFoundException e) {
			// System.out.println(e.message());
		}

        //**********************************************

        //**************** try catch block *******************8
		Digraph digraph = new Digraph(synset.size());

		try {

			Scanner scanner2 = new Scanner(new File("Files/" + file2));
			while (scanner2.hasNextLine()) {
				String[] graphinput = scanner2.nextLine().split(",");
				// System.out.println(graphinput[1]);
				digraph.addEdge(Integer.parseInt(graphinput[0]), Integer.parseInt(graphinput[1]));
			}
		}  catch (FileNotFoundException e) {

		}
		//*****************************************************

        // while(scan.hasNext()) {
        	String line1 = scan.nextLine();
        	switch(line1) {
        		case "Graph" :
        		      DirectedCycle finder = new DirectedCycle(digraph);
        		      if (finder.hasCycle()) {
                              System.out.println("Cycle detected");

                      } else {
                      	System.out.println(digraph);
                      }
        		break;
        		case "Queries":
        		     while(scan.hasNext()) {
        		     	String[] cmdlines = scan.nextLine().split(" ");
        		     	if(cmdlines[0].equals("null")) {
        		     		System.out.println("IllegalArgumentException");
        		     	}
        		     }
        		break;


        		default:

        		break;
        	}


        	}
        }








