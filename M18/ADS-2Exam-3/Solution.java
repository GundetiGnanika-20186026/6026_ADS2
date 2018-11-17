import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		String[] msgs = toReadFile(file);
		for (int i = 0; i < msgs.length; i++) {
			String key = msgs[i].toLowerCase();
			if (!st.contains(key)) {
				st.put(key, 1);
			} else {
				int val = st.get(key);
				st.put(key, val + 1);
			}
		}
		return st;

	}

}


class T9 {
	private TST trie;

	public T9(BinarySearchST<String, Integer> st) {
		trie = new TST();
		for (String word : st.keys()) {
			trie.put(word, st.get(word));
		}


		// your code goes here
	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		//System.out.println("entered");
		return trie.keysWithPrefix(prefix);


	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here

		return null;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		//System.out.println("entered");
		Bag<String> bag1 = new Bag<String>();

        int i = 0;
        int[] values = new int[6];
        String[] keys1 = new String[6];
		for (String string : words) {
			//System.out.println("entered");
			int count = 0;
            keys1[i] = string;
			for (String each : getAllWords(string)) {
				count++;
			}
			values[i] = count;
			i++;
		}
		Arrays.sort(keys1);
		//.System.out.println(Arrays.toString(keys1));
        for(int l = 0; l < 3;l++){
        	bag1.add(keys1[l]);
        }
        bag1.add(keys1[5]);
        return bag1;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
