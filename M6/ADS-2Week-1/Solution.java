import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
	Double[] pageranks;
	Digraph originalgraph;
    /**
     * Constructs the object.
     *
     * @param      graph  The graph
     */
	PageRank(Digraph graph) {
		this.originalgraph = graph;

		pageranks = new Double[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			pageranks[i] = (double)1 /(double)graph.V();
		}
		//System.out.println(originalgraph.V());
		System.out.println(Arrays.toString(pageranks));
	}


	/**
	 * method to calculate page rank.
	 * its complexity is O(n*n*n) as I am using 3 for loops.
	 *
	 * @return     { array with page rank }
	 */
	public Double[] pageRank() {
        int k = 1;
        while(k <= 1) {
		    for(int i = 0; i < originalgraph.V(); i++){
			    for(int j = 0; j< originalgraph.V();j++) {
			    	if(j != i) {
		                for(int v : originalgraph.adj[j]) {
		        	        if(i == v) {
		        	            //System.out.println(originalgraph.outdegree(j)+"out");
		        	            pageranks[i] =  pageranks[j]/(double) originalgraph.outdegree(j);
		        	        }
		                }
		            }
			    }
            }

            k++;

	    }
	    return pageranks;

    }

    public double getPR(int v) {
    	return pageranks[v];
    }


    public  void tostring() {

    	StringBuilder s = new StringBuilder();
		for(int i = 0; i < originalgraph.V() ; i++) {

            s.append(String.format("%d: ", i));
		    s.append(getPR(i));
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


		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph
		//

		for (int i = 0; i < vertexes; i++) {
			String[] graphinput = scan.nextLine().split(" ");
			// System.out.println(graphinput[1]);
			for (int j = 1; j < graphinput.length; j++) {
				digraph.addEdge(Integer.parseInt(graphinput[0]),
				                Integer.parseInt(graphinput[j]));
			}
		}
		System.out.println(digraph);
		System.out.println();




		// Create page rank object and pass the graph object to the constructor
		PageRank objpage = new PageRank(digraph);




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












// int j = 0;
// 		for(int i = 0; i < originalgraph.V(); i++){
// 		    for(int v : originalgraph.adj[i]) {

// 		    	list[j] = v;
// 		    	j++;

// 		    	// if(i == v) {
// 		    	//  // pageranks[i] =
// 		    	// }

// 	        }
// 	        list[j] = 25;
// 	        j++;

// 	    }
// 	    System.out.println(Arrays.toString(list));