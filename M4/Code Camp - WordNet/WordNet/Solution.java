import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;


/////////////////////////////////////////////////////

/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String file1 = scan.nextLine();
		String file2 = scan.nextLine();
HashMap<Integer, String[]> synset = new HashMap<>();
HashMap<String, ArrayList<Integer>> queries = new HashMap<>();
		//********************************************************
		try {
	Scanner firstscan = new Scanner(new File("Files/" + file1));
			//putting values into synset hashmap;
			while (firstscan.hasNextLine()) {

				String[] input = firstscan.nextLine().split(",");
				String[] letter = input[1].split(" ");
				synset.put(Integer.parseInt(input[0]), letter);
			}

			for (int key : synset.keySet()) {
				String[] values = synset.get(key);
				for (int i = 0; i < values.length; i++) {

					if (queries.containsKey(values[i])) {
				ArrayList<Integer> array2 = queries.get(values[i]);
						array2.add(key);
						queries.put(values[i], array2);
					} else {
					ArrayList<Integer> array1 = new ArrayList<>();
						array1.add(key);
						queries.put(values[i], array1);
					}

				}
			}

		} catch (FileNotFoundException e) {
			// System.out.println(e.message());
		}

		//**********************************************

		//**************** try catch block *******************
		Digraph digraph = new Digraph(synset.size());

		try {

	Scanner scanner2 = new Scanner(new File("Files/" + file2));
		while (scanner2.hasNextLine()) {
	String[] graphinput = scanner2.nextLine().split(",");
				// System.out.println(graphinput[1]);
			for (int i = 1; i < graphinput.length; i++) {
				digraph.addEdge(Integer.parseInt(graphinput[0]),
					            Integer.parseInt(graphinput[i]));
				}
			}
		}  catch (FileNotFoundException e) {

		}
		//*****************************************************

		// while(scan.hasNext()) {
		String line1 = scan.nextLine();
		switch (line1) {
		case "Graph" :
		DirectedCycle finder = new DirectedCycle(digraph);
			if (finder.hasCycle()) {
				System.out.println("Cycle detected");

			} else if (digraph.multipleroots()) {
				System.out.println("Multiple roots");
			} else {
				System.out.println(digraph);
			}
			break;
		case "Queries":
			while (scan.hasNext()) {
				String[] cmdlines = scan.nextLine().split(" ");
				// if (cmdlines[0].equals("null")) {
			// 	System.out.println("IllegalArgumentException");
				// }
				try {
					if (cmdlines[0].equals("null")) {
			System.out.println("IllegalArgumentException");
						return;
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				SAP objectsap = new SAP(digraph);
			objectsap.length(queries.get(cmdlines[0]),
				 queries.get(cmdlines[1]), synset);
			}
			break;


		default:

			break;
		}


	}
}








