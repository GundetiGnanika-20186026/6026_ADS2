import java.util.ArrayList;
public class MoveToFront {
	//private static char[] chararray;
	private static ArrayList<Character> list;
	public static final int R = 256;
    MoveToFront(){
		// chararray = new char[R];
		// for (int i = 0; i < R; i++) {
		// 	chararray[i] = (char)i;
		//}

	}
	public static void encode() {

		// char temp1 = chararray[0];
		// char temp2;
		// String input1 = BinaryStdIn.readString();
		// char[]  input = input1.toCharArray();
		// for (int i = 0; i < input.length; i++) {
		// 	for (int j = 0; j < chararray.length-1; j++) {
		// 		if (input[i] != temp1) {
		// 			temp2 = temp1;
  //                   temp1 = chararray[j + 1];
		// 			chararray[j+1] = temp2;



		// 		} else {
		// 			BinaryStdOut.write((char)j);
		// 			chararray[0] = temp1;
		// 			break;

		// 		}
		// 	}
		// }
		// BinaryStdOut.close();


		 ArrayList<Character> list = new ArrayList<Character>();
        for (char i = 0 ; i < R; i++) {
                list.add(i);
            }
        while (!BinaryStdIn.isEmpty()) {
            char chr = BinaryStdIn.readChar();
            int index = (int) list.indexOf(chr);
            BinaryStdOut.write((char) index);
            list.remove(index);
            list.add(0, chr);
        }
        BinaryStdOut.close();
    }

    public static void decode() {
        ArrayList<Character> list = new ArrayList<Character>();
        for (char i = 0 ; i < R; i++) {
            list.add(i);
        }
        while (!BinaryStdIn.isEmpty()) {
            char chr = BinaryStdIn.readChar();
            char index = list.get(chr);
            BinaryStdOut.write(index);
            list.remove(chr);
            list.add(0, index);
        }
        BinaryStdOut.close();
    }


	public static void main(String[] args) {
		MoveToFront obj = new MoveToFront();

        if      (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new IllegalArgumentException("Illegal command line argument");
	}
}
