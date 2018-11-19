//import java.util.Arrays;
import java.util.HashSet;
/**
 * Class for boggle solver.
 */
class BoggleSolver {
    /**
     * R way tries.
     */
    private TrieST trie;
    /**
     * hashset.
     */
    private HashSet<String> bag;
    /**
     * rows.
     */
    private int mrows;
    /**
     * cols.
     */
    private int ncol;
    /**
     * Constructs the object.
     * its timecomplexity is O(no. of words in dictionary)
     *
     * @param      dictionary  The dictionary
     */
    BoggleSolver(final String[] dictionary) {
//System.out.println(Arrays.toString(dictionary));
        trie = new TrieST();
        int j = 0;
        for (int i = 0; i < dictionary.length; i++) {
            trie.put(dictionary[i], j);
            j++;
        }
        bag = new HashSet<>();
    }

// Returns the set of all valid words in
// the given Boggle board, as an Iterable.

    /**
     * Gets all valid words.
     * its time complexity is O(rows * colums).
     *
     *
     * @param      board  The board
     *
     * @return     All valid words.
     */
    public Iterable<String> getAllValidWords(final BoggleBoard board) {
        //System.out.println(board);
        if (board == null) {
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

                dfs(board, i, j, word, marked);

            }
        }
        // for(String i : bag){
        //  System.out.println(i);
        // }
        return bag;
    }

    /**
     * converts char to String.
     * its time complexity is O(1).
     *
     * @param      chr   The character
     *
     * @return     { string }
     */
    public String chartoString(final char chr) {
        //String string = "";
        if (chr == 'Q') {
            return "QU";
        } else {
            return chr + "";
        }


    }

    /**
     * calculates the score of given word.
     *its time complexity is O(1).
     * @param      word  The word
     *
     * @return     { score }
     */
    public int scoreOf(final String word) {
        int wordlength = word.length();
        if (wordlength <= 2) {
            return 0;
        } else if (wordlength <= (2 + 2)) {
            return 1;
        } else if (wordlength == (2 + 2 + 1)) {
            return 2;
        } else if (wordlength == (2 + 2 + 2)) {
            return 2 + 1;
        } else if (wordlength == (2 + 2 + 2 + 1)) {
            return 2 + 2 + 1;
        } else {
            return 2 + 2 + 2 + 2 + 2 + 1;
        }
    }

    /**
     * checks wether the index is valid or not.
     *its time complexity is O(1).
     * @param      i     { index1 }
     * @param      j     { index2 }
     *
     * @return     { boolean }
     */
    public boolean validIndex(final int i, final int j) {
        if (i < 0 || i >= mrows || j < 0 || j >= ncol) {
            return false;
        }
        return true;

    }

    /**
     * checks all possible words.
     * its time complexity is O(vertices + edges).
     *
     * @param      board   The board
     * @param      i       { index1 }
     * @param      j       { index2 }
     * @param      word    The word
     * @param      marked  The marked
     */
    public void dfs(final BoggleBoard board, final int i,
final int j, final String word, final boolean[][] marked) {

        String word1 = word;
        if (marked[i][j]) {
            return;
        }
        //if (word.length() >= 3) {
        if (!trie.hasPrefix(word)) {
            //System.out.println("hii");
            return;
        }
        //}

        if (word == "") {
            //System.out.println("hii");
            char chr = board.getLetter(i, j);
            word1 = chartoString(chr);
        }

        if (word1.length() > 2 && trie.contains(
                    word1) && (!bag.contains(word1))) {
            //System.out.println(word);
            bag.add(word1);
            //return;1

        }
        marked[i][j] = true;
        if (validIndex(i - 1, j - 1) && (!marked[i - 1][j - 1])) {
            //System.out.println("hii");
            dfs(board, i - 1, j - 1, word1 + chartoString(
                    board.getLetter(i - 1, j - 1)), marked);
            marked[i - 1][j - 1] = false;
        }

        if (validIndex(i - 1, j) && (!marked[i - 1][j])) {
            dfs(board, i - 1, j, word1 + chartoString(
                    board.getLetter(i - 1, j)), marked);
            marked[i - 1][j] = false;
        }

        if (validIndex(i - 1, j + 1) && (!marked[i - 1][j + 1])) {
            dfs(board, i - 1, j + 1, word1 + chartoString(
                    board.getLetter(i - 1, j + 1)), marked);
            marked[i - 1][j + 1] = false;
        }

        if (validIndex(i, j - 1) && (!marked[i][j - 1])) {
            dfs(board, i, j - 1, word1 + chartoString(
                    board.getLetter(i, j - 1)), marked);
            marked[i][j - 1] = false;
        }

        if (validIndex(i, j + 1) && (!marked[i][j + 1])) {
            dfs(board, i, j + 1, word1 + chartoString(
                    board.getLetter(i, j + 1)), marked);
            marked[i][j + 1] = false;
        }

        if (validIndex(i + 1, j - 1) && (!marked[i + 1][j - 1])) {
            dfs(board, i + 1, j - 1, word1 + chartoString(
                    board.getLetter(i + 1, j - 1)), marked);
            marked[i + 1][j - 1] = false;
        }

        if (validIndex(i + 1, j) && (!marked[i + 1][j])) {
            dfs(board, i + 1, j, word1 + chartoString(
                    board.getLetter(i + 1, j)), marked);
            marked[i + 1][j] = false;
        }

        if (validIndex(i + 1, j + 1) && (!marked[i + 1][j + 1])) {
            dfs(board, i + 1, j + 1, word1 + chartoString(
                    board.getLetter(i + 1, j + 1)), marked);
            marked[i + 1][j + 1] = false;
        }
    }
}
