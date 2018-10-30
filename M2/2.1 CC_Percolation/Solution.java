import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] array = new int[size][size];
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            array[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;
        }
        for(int i = 0; i < size;i++){
            for(int j = 0; j< size; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }



    }
}
