import java.util.Scanner;
import java.util.HashMap;
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution(){

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		HashMap<String, Integer> hashobj = new HashMap<String, Integer>();
		Scanner scan = new Scanner(System.in);
		String[] num = scan.nextLine().split(" ");
		int vertexes = Integer.parseInt(num[0]);
		int edges = Integer.parseInt(num[1]);
		String[] places = scan.nextLine().split(" ");
		EdgeWeightedGraph graphobj = new EdgeWeightedGraph(vertexes);
		for(int i = 0; i<places.length;i++) {
			hashobj.put(places[i], i);
		}



		for (int i = 0; i < edges; i++) {
			String[] formation = scan.nextLine().split(" ");
	        Edge edgeobj = new Edge(hashobj.get(formation[1]),
			 hashobj.get(formation[2]), Double.parseDouble(formation[3]));
			graphobj.addEdge(edgeobj);
        }

        int queries = Integer.parseInt(scan.nextLine());
        for(int i =0;i<queries;i++){
        	String[] qur = scan.nextLine().split(" ");
        	DijkstraSP dis = new DijkstraSP(graphobj, hashobj.get(qur[0]));
        	System.out.println((int)dis.distance(hashobj.get(qur[1])));
        }

	}
}