import java.util.Scanner;
import java.io.File;
import java.io.IOException;
//import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     * its complexity is L*N;
     * where L = length of each word.
     * N = no. of strings.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Tst<Integer> st = new Tst<Integer>();
        String[] words = loadWords();
        int j = 1;
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words[i].length(); k++) {
                st.put(words[i].substring(k), j);
                j++;
            }
        }
        String req = scan.nextLine();

        for (String s : st.keysWithPrefix(req)) {
            System.out.println(s);

        }
    }

    /**
     * Loads words.
     *
     * @return     { array with words }.
     */
    public static String[] loadWords() {

        try {
            Scanner filescan = new Scanner(
                new File("Files/dictionary-algs4.txt"));
            final int value = 6013;
            String[] input = new String[value];

            int s = 0;
            while (filescan.hasNextLine()) {
                input[s] = filescan.nextLine();
                s++;
            }
            // System.out.println(Arrays.toString(input));
            return input;

        } catch (IOException e) {
            System.out.println("file not found");
            return null;
        }

        // In in = new In("/Files/dictionary-algs4.txt");
        // String[] words = in.readAllStrings();
        // return words;

    }
}
