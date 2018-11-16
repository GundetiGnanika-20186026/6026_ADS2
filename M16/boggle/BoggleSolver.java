import java.util.Arrays;
import java.util.HashSet;
public class BoggleSolver {

	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)

	private TrieST trie;
	private HashSet<String> bag;
	private int mrows;
	private int ncol;
	public BoggleSolver(String[] dictionary) {
		//System.out.println(Arrays.toString(dictionary));
		trie = new TrieST();
		int j = 0;
		for (int i = 0; i < dictionary.length; i++) {
			trie.put(dictionary[i], j);
			j++;
		}
		bag = new HashSet<>();
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		//System.out.println(board);
		if(board == null){
			System.out.println("board is null");
			return null;
		}
		mrows = board.rows();
		ncol = board.cols();

		//char[][] arr = new char[mrows][ncol];
		for (int i = 0; i < mrows; i++) {
			for (int j = 0; j < ncol; j++) {
				boolean[][] marked = new boolean[mrows][ncol];
				//arr[i][j] = board.getLetter(i, j);
				String word = "";

				Dfs(board, i, j, word, marked);

			}
		}
		// for(String i : bag){
		// 	System.out.println(i);
		// }
		return bag;
	}


	public String chartoString(char chr) {
		//String string = "";
		if (chr == 'Q') {
			return "QU";
		} else {
			return chr+"";
		}


	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		int wordlength = word.length();
		if (wordlength <= 2) {
			return 0;
		} else if (wordlength <= 4) {
			return 1;
		} else if (wordlength == 5) {
			return 2;
		} else if (wordlength == 6) {
			return 3;
		} else if (wordlength == 7) {
			return 5;
		} else {
			return 11;
		}
	}

	public boolean validindex(int i, int j) {
		if (i < 0 || i >= mrows || j < 0 || j >= ncol) {
			return false;
		}
		return true;

	}

	public void Dfs(BoggleBoard board, int i, int j, String word, boolean[][] marked) {

		if (marked[i][j]) {
			return;
		}
		// if(word.length() == 1) {
		// 	if(!trie.hasPrefix(word)) {
		// 		return;
		// 	}
		// }

		if(word.length() >= 3) {
		     if (!trie.hasPrefix(word)) {
			//System.out.println("hii");
			   return;
		    }
		}

		if (word == "") {
			//System.out.println("hii");
			char chr = board.getLetter(i, j);
			word = chartoString(chr);
		}

		if (word.length() > 2 && trie.contains(word) && (!bag.contains(word))) {
			//System.out.println(word);
			bag.add(word);
			//return;1

		}
		marked[i][j] = true;
		if (validindex(i - 1, j - 1) && (!marked[i - 1][j - 1])) {
			//System.out.println("hii");
			Dfs(board, i - 1, j - 1, word + chartoString(board.getLetter(i - 1, j - 1)), marked);
			marked[i - 1][j - 1] = false;
		}

		if (validindex(i - 1, j) && (!marked[i - 1][j])) {
			Dfs(board, i - 1, j, word + chartoString(board.getLetter(i - 1, j)), marked);
			marked[i - 1][j] = false;
		}

		if (validindex(i - 1, j + 1) && (!marked[i - 1][j + 1])) {
			Dfs(board, i - 1, j + 1, word + chartoString(board.getLetter(i - 1, j + 1)), marked);
			marked[i - 1][j + 1] = false;
		}

		if (validindex(i, j - 1) && (!marked[i][j - 1])) {
			Dfs(board, i, j - 1, word + chartoString(board.getLetter(i, j - 1)), marked);
			marked[i][j - 1] = false;
		}

		if (validindex(i, j + 1) && (!marked[i][j + 1])) {
			Dfs(board, i, j + 1, word + chartoString(board.getLetter(i, j + 1)), marked);
			marked[i][j + 1] = false;
		}

		if (validindex(i + 1, j - 1) && (!marked[i + 1][j - 1])) {
			Dfs(board, i + 1, j - 1, word + chartoString(board.getLetter(i + 1, j - 1)), marked);
			marked[i + 1][j - 1] = false;
		}

		if (validindex(i + 1, j) && (!marked[i + 1][j])) {
			Dfs(board, i + 1, j, word + chartoString(board.getLetter(i + 1, j)), marked);
			marked[i + 1][j] = false;
		}

		if (validindex(i + 1, j + 1) && (!marked[i + 1][j + 1])) {
			Dfs(board, i + 1, j + 1, word + chartoString(board.getLetter(i + 1, j + 1)), marked);
			marked[i + 1][j + 1] = false;
		}
	}
}