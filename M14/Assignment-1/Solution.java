import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Tst<Integer> st = new Tst<Integer>();
		String[] words = loadWords();

		//Your code goes here...
		int j = 1;
		for (int i = 0; i < words.length; i++) {
            for(int k = 0;k<words[i].length();k++) {
			    st.put(words[i].substring(k), j);
			     j++;
		   }
		}
		String req = scan.nextLine();
		//int sum = 0;
		for (String s : st.keysWithPrefix(req)) {
			System.out.println(s);
			//sum +=1;
		}
		//System.out.println(sum);

	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}