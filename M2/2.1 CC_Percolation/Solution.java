import java.util.Scanner;
class Percolation {
    private int size;
    Percolation(final int vertex) {
        size = vertex;
    }
    public int  transition(int i , int j) {
        return ((i * size) + j);
    }
    public boolean percolates(final boolean[][] grid, final Graph graph) {
        for (int row = 0 ; row < size ; row++) {
            for (int col = 0 ; col < size; col++) {
                if (grid[row][col]) {
                    int tmp = transition(row, col);
                    if (row == 0) {
                        graph.addEdge(tmp , size * size);
                    }
                    if (row == size - 1) {
                        graph.addEdge(tmp , size * size + 1);
                    }
                    if (row - 1 >= 0 && grid[row - 1][col]) {
                        graph.addEdge(tmp , transition(row - 1, col));
                    }
                    if (row + 1 < size  && grid[row + 1][col]) {
                        graph.addEdge(tmp , transition(row + 1, col));
                    }
                    if (col - 1 >= 0 && grid[row][col - 1]) {
                        graph.addEdge(tmp , transition(row, col - 1));
                    }
                    if (col + 1 < size && grid[row][col + 1]) {
                        graph.addEdge(tmp , transition(row, col + 1));
                    }
                }
            }
        }
        DepthFirstPaths object = new DepthFirstPaths(graph, size * size);
        return object.hasPathTo(size * size + 1);
    }

}

final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertexes = Integer.parseInt(scan.nextLine());
        boolean[][] grid = new boolean[vertexes][vertexes];
        Graph graph = new Graph(vertexes * vertexes + 2);
        Percolation obj = new Percolation(vertexes);

        while (scan.hasNext()) {
            int rowvalue = scan.nextInt();
            int colvalue = scan.nextInt();
            grid[rowvalue - 1][colvalue - 1] = true;
        }
        System.out.println(obj.percolates(grid, graph));





        // while (scan.hasNext()) {
        //     String[] input = scan.nextLine().split(" ");
        //     grid[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;
        // }
        // for(int i = 0; i < size;i++){
        //     for(int j = 0; j< size; j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }



    }
}
