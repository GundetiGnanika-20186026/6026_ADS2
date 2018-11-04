import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
	private Digraph extragraph;
	private Double[] pageranks;
	private Double[] updated;
	private Double value;
	private int vertexes;
	/**
	 * Constructs the object.
	 *
	 * @param      graph  The graph
	 */
	PageRank(Digraph graph) {
		this.extragraph = graph;
		this.vertexes = graph.V();
        pageranks = new Double[graph.V()];
        updated = new Double[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			pageranks[i] = (double)1 / (double)graph.V();
		}

		Digraph revdigraph = extragraph.reverse();
		//System.out.println(originalgraph.V());
		//System.out.println(Arrays.toString(pageranks));
	}


	/**
	 * method to calculate page rank.
	 * its complexity is O(n*n*n*n) as I am using 3 for loops and one while loop.
	 *
	 * @return     { array with page rank }
	 */
	public Double[] pageRank() {

			Digraph revdigraph = extragraph.reverse();
			for (int i = 0; i < 1000; i++) {

				for (int j = 0; j < vertexes; j++) {
					value = 0.0;

						for (int v : revdigraph.adj(j)) {

								//System.out.println(originalgraph.outdegree(j)+"out");
								value += ((pageranks[v]) /(double)  extragraph.outdegree(v));

						}
						updated[j] = value;
						//System.out.print(updated[j] + " j \n");
				}
				if(Arrays.equals(pageranks, updated)) {
						break;
				} else {
						pageranks = updated.clone();

				}
			}
			return updated;
    }




	/**
	 * Gets the pagerank;
	 *
	 * @param      v     { index }
	 *
	 * @return     The pr.
	 */
	public double getPR(int v) {
		return updated[v];
	}


    /**
     * string representation of the page ranks.
     * its complexity is O(N).
     */
	public  void tostring() {

		StringBuilder s = new StringBuilder();
		// System.out.println("tostring");
		for (int i = 0; i < extragraph.V() ; i++) {

			s.append(String.format("%d - ", i));
			//System.out.print("hello + i" + i+"\n");
			s.append(getPR(i));
			// System.out.println("hello");
			s.append("\n");
		}
		System.out.println(s);


	}

}



class WebSearch {

}

/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner scan = new Scanner(System.in);
		int vertexes = Integer.parseInt(scan.nextLine());
		Digraph digraph = new Digraph(vertexes);
		Digraph extragraph = new Digraph(vertexes);


		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph
		//

		for (int i = 0; i < vertexes; i++) {
			String[] graphinput = scan.nextLine().split(" ");
			// System.out.println(graphinput[1]);
			if(graphinput.length >= 2) {
			   for (int j = 1; j < graphinput.length; j++) {
				    digraph.addEdge(Integer.parseInt(graphinput[0]),
				                Integer.parseInt(graphinput[j]));
				    extragraph.addEdge(Integer.parseInt(graphinput[0]),
				                Integer.parseInt(graphinput[j]));
			    }
		    } else {
		    	for(int k = 0; k< vertexes;k++){
		    		if(k != i) {
		    			extragraph.addEdge(Integer.parseInt(graphinput[0]), k);

		    		}
		    	}
		    }
		}
		System.out.println(digraph);
		// System.out.println();




		// Create page rank object and pass the graph object to the constructor
		PageRank objpage = new PageRank(extragraph);
		objpage.pageRank();



		// print the page rank object
		objpage.tostring();
		// System.out.println();






		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}












