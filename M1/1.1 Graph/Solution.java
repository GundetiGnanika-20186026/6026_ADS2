import java.util.Scanner;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}

class AdjMatrixGraph implements Graph {
	private int vertices;
	private int edges;
	private int[][] matrix;
	AdjMatrixGraph(int vertical) {
		this.vertices = vertical;
		this.edges = 0;
		matrix = new int[vertical][vertical];
	}

    public int V() {
    	return vertices;
    }

    public int E() {
    	return edges;
    }

    public void addEdge(int v, int w) {
    	matrix[v][w] = 1;
    	matrix[w][v] = 1;
    	edges++;

    }

    public Iterable<Integer> adj(int v) {
    	return null;
    }

    public boolean hasEdge(int v, int w) {
    	return matrix[v][w] == 1;
    }

    public void print() {
    	System.out.println(vertices+" vertices, "+edges+" edges");

    	for(int i = 0; i < vertices; i++) {
    		String str = "";
    		for(int j = 0; j < edges; j++){
    			str += matrix[i][j]+" ";

    		}
    		System.out.println(str);
    	}
    }



}




final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cmd = scan.nextLine();
		int vertexNum = Integer.parseInt(scan.nextLine());
		int edgenum = Integer.parseInt(scan.nextLine());
		String[] places = scan.nextLine().split(",");
        switch (cmd) {
		case "List" :

			break;
		case "Matrix" :

		     AdjMatrixGraph obj = new AdjMatrixGraph(vertexNum);

		     for(int i = 0; i < edgenum; i++) {
		     	String[] input = scan.nextLine().split(" ");
		     	obj.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
             }
             obj.print();
             break;

		}





	}
}




