import java.util.Scanner;
class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertexes = Integer.parseInt(scan.nextLine());
		int edges = Integer.parseInt(scan.nextLine());
        EdgeWeightedGraph weighted = new EdgeWeightedGraph(vertexes);

		for(int i = 0;i<edges;i++) {
			String[] input = scan.nextLine().split(" ");
            Edge edgeobj = new Edge(Integer.parseInt(input[0]),
             Integer.parseInt(input[1]), Double.parseDouble(input[2]));
            weighted.addEdge(edgeobj);
        }
        KruskalMST kruskal = new KruskalMST(weighted);
        System.out.format("%.5f", kruskal.weight());







	}
}