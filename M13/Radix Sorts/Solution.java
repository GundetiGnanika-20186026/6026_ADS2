import java.util.Scanner;
import java.util.Arrays;
final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] arr = new String[num];
		Quick3string obj = new Quick3string();
		for(int i = 0; i<num;i++){
			arr[i] = scan.nextLine();
        }
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));

	}
}