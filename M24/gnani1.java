import java.util.NoSuchElementException;
class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;
    private int iterations;

    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
        iterations = 0;

    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }


    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    }


    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        iterations = 0;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            iterations += 1;
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }



    public void put(Key key, Value val)  {


        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) resize(2 * keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;

    }


    public int size(Key lo, Key hi) {


        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    // public Iterable<Key> keys() {
    //     return keys(min(), max());
    // }

    public int getiterations() {
        return iterations;
    }


    // public Iterable<Key> keys(Key lo, Key hi) {

    //     Queue<Key> queue = new Queue<Key>();
    //     if (lo.compareTo(hi) > 0) return queue;
    //     for (int i = rank(lo); i < rank(hi); i++)
    //         queue.enqueue(keys[i]);
    //     if (contains(hi)) queue.enqueue(keys[rank(hi)]);
    //     return queue;
    // }


    // public static void main(String[] args) {
    //     BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
    //     for (int i = 0; !StdIn.isEmpty(); i++) {
    //         String key = StdIn.readString();
    //         st.put(key, i);
    //     }
    //     for (String s : st.keys())
    //         StdOut.println(s + " " + st.get(s));
    // }
}





/////////////////////////////////////////////////////////////////////////////
class SequentialSearchST<Key, Value> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs
    private int noiterations;

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {
        noiterations = 0;
    }


    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Key key) {
        // if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }


    public Value get(Key key) {
        // if (key == null) throw new IllegalArgumentException("argument to get() is null");
        noiterations = 0;
        for (Node x = first; x != null; x = x.next) {
            noiterations += 1;
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }


    public void put(Key key, Value val) {
        // if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        for (Node x = first; x != null; x = x.next) {

            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public int getiterations() {
        return noiterations;
    }



    // public Iterable<Key> keys()  {
    //     Queue<Key> queue = new Queue<Key>();
    //     for (Node x = first; x != null; x = x.next)
    //         queue.enqueue(x.key);
    //     return queue;
    // }


    // public static void main(String[] args) {
    //     SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
    //     for (int i = 0; !StdIn.isEmpty(); i++) {
    //         String key = StdIn.readString();
    //         st.put(key, i);
    //     }
    //     for (String s : st.keys())
    //         StdOut.println(s + " " + st.get(s));
    // }
}




public class gnani1 {
    // private static int[] array= new int[1000000];
    private gnani1() {
    }
    public static void main(final String[] args) {

        SequentialSearchST<Integer, Integer> ss = new SequentialSearchST<>();
        BinarySearchST<Integer, Integer> bs = new BinarySearchST<>();
        int ssiter;
        int bsiter;
        int cou = 0;
        for (int i = 1; i < 1000000; i++) {

            ss.put(i, i);
            bs.put(i, i);
            for (int j = 1; j < i; j++) {

                ss.get(j);
                ssiter = ss.getiterations();


                bs.get(j);
                bsiter = bs.getiterations();

                if ((bsiter * 1000) == ssiter) {
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(bsiter);
                    System.out.println(ssiter);
                    cou = 1;

                }
            }
            if (cou == 1){
                break;
            }

        }
    }
}

















