import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     * its complexity is 1.39WNlog(N)* as
     *  we are using 3- way quick sort.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String[] arr = new String[num];
        Quick3string obj = new Quick3string();
        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextLine();
        }
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
