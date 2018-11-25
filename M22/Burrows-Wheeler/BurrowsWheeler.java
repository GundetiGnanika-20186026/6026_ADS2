import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.HashMap;
import java.util.Arrays;
public class BurrowsWheeler {
    BurrowsWheeler(){

	}
    private static final int R = 256;

    public static void transform() {
        String str1 = BinaryStdIn.readString();
        CircularSuffixArray c = new CircularSuffixArray(str1);
        int first = 0;
        while (first < c.length() && c.index(first) != 0) {
            first++;
        }
        BinaryStdOut.write(first);
        for (int i = 0; i < c.length(); i++) {
            BinaryStdOut.write(str1.charAt((c.index(i) + str1.length() - 1) % str1.length()));
        }
        BinaryStdOut.close();
    }

    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String str2 = BinaryStdIn.readString();
        char[] array = str2.toCharArray();
        HashMap<Character, Queue<Integer>> hashmap = new HashMap<Character, Queue<Integer>>();
        for (int i = 0; i < array.length; i++) {
            if (!hashmap.containsKey(array[i])) {
                hashmap.put(array[i], new Queue<Integer>());
            }
            hashmap.get(array[i]).enqueue(i);
        }
        Arrays.sort(array);
        int[] indexes = new int[array.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = hashmap.get(array[i]).dequeue();
        }

        for (int i = 0; i < indexes.length; i++) {
            BinaryStdOut.write(array[first]);
            first = indexes[first];
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
    	 	// String s = StdIn.readAll().replaceAll("\\s+", " ").trim();

        if      (args[0].equals("-")) transform();
        else if (args[0].equals("+")) inverseTransform();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}





