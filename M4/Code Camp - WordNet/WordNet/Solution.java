import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String file1 = scan.nextLine();
		String file2 = scan.nextLine();
		HashMap<Integer, String[]> synset = new HashMap<>();
		HashMap<String, ArrayList<Integer>> queries = new HashMap<>();
        //*****************************************************************
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

        //**************** try catch block *******************8
		Digraph digraph = new Digraph(synset.size());
		try {
			Scanner scanner2 = new Scanner(new File("File/" + file2));
			while (scanner2.hasNextLine()) {
				String[] graphinput = scanner2.nextLine().split(",");
				System.out.println(Arrays.toString(graphinput));
				digraph.addEdge(Integer.parseInt(graphinput[0]), Integer.parseInt(graphinput[1]));
			}
		}  catch (FileNotFoundException e) {

		}
		//*****************************************************

        while(scan.hasNext()) {
        	String line1 = scan.nextLine();
        	switch(line1) {
        		case "Graph" :
        		      System.out.println(digraph);
        		break;
        		// case "":
        		// break;
        		default:
        		      System.out.println("IllegalArgumentException");
        		break;
        	}
        }



		}


	}

