

// import java.util.Comparator;
// import java.util.Iterator;
// import java.util.NoSuchElementException;

// /**
//  *  The {@code MinPQ} class represents a priority queue of generic keys.
//  *  It supports the usual <em>insert</em> and <em>delete-the-minimum</em>
//  *  operations, along with methods for peeking at the minimum key,
//  *  testing if the priority queue is empty, and iterating through
//  *  the keys.
//  *  <p>
//  *  This implementation uses a binary heap.
//  *  The <em>insert</em> and <em>delete-the-minimum</em> operations take
//  *  logarithmic amortized time.
//  *  The <em>min</em>, <em>size</em>, and <em>is-empty</em> operations take constant time.
//  *  Construction takes time proportional to the specified capacity or the number of
//  *  items used to initialize the data structure.
//  *  <p>
//  *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
//  *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
//  *
//  *  @author Robert Sedgewick
//  *  @author Kevin Wayne
//  *
//  *  @param <Key> the generic type of key on this priority queue
//  */
// public class MinPQ<Key> implements Iterable<Key> {
//     private Key[] pq;                    // store items at indices 1 to n
//     private int n;                       // number of items on priority queue
//     private Comparator<Key> comparator;  // optional comparator

//     /**
//      * Initializes an empty priority queue with the given initial capacity.
//      *
//      * @param  initCapacity the initial capacity of this priority queue
//      */
//     public MinPQ(int initCapacity) {
//         pq = (Key[]) new Object[initCapacity + 1];
//         n = 0;
//     }

//     /**
//      * Initializes an empty priority queue.
//      */
//     public MinPQ() {
//         this(1);
//     }

//     /**
//      * Initializes an empty priority queue with the given initial capacity,
//      * using the given comparator.
//      *
//      * @param  initCapacity the initial capacity of this priority queue
//      * @param  comparator the order in which to compare the keys
//      */
//     public MinPQ(int initCapacity, Comparator<Key> comparator) {
//         this.comparator = comparator;
//         pq = (Key[]) new Object[initCapacity + 1];
//         n = 0;
//     }

//     /**
//      * Initializes an empty priority queue using the given comparator.
//      *
//      * @param  comparator the order in which to compare the keys
//      */
//     public MinPQ(Comparator<Key> comparator) {
//         this(1, comparator);
//     }

//     /**
//      * Initializes a priority queue from the array of keys.
//      * <p>
//      * Takes time proportional to the number of keys, using sink-based heap construction.
//      *
//      * @param  keys the array of keys
//      */
//     public MinPQ(Key[] keys) {
//         n = keys.length;
//         pq = (Key[]) new Object[keys.length + 1];
//         for (int i = 0; i < n; i++)
//             pq[i+1] = keys[i];
//         for (int k = n/2; k >= 1; k--)
//             sink(k);
//         assert isMinHeap();
//     }

//     /**
//      * Returns true if this priority queue is empty.
//      *
//      * @return {@code true} if this priority queue is empty;
//      *         {@code false} otherwise
//      */
//     public boolean isEmpty() {
//         return n == 0;
//     }

//     /**
//      * Returns the number of keys on this priority queue.
//      *
//      * @return the number of keys on this priority queue
//      */
//     public int size() {
//         return n;
//     }

//     /**
//      * Returns a smallest key on this priority queue.
//      *
//      * @return a smallest key on this priority queue
//      * @throws NoSuchElementException if this priority queue is empty
//      */
//     public Key min() {
//         if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
//         return pq[1];
//     }

//     // helper function to double the size of the heap array
//     private void resize(int capacity) {
//         assert capacity > n;
//         Key[] temp = (Key[]) new Object[capacity];
//         for (int i = 1; i <= n; i++) {
//             temp[i] = pq[i];
//         }
//         pq = temp;
//     }

//     /**
//      * Adds a new key to this priority queue.
//      *
//      * @param  x the key to add to this priority queue
//      */
//     public void insert(Key x) {
//         // double size of array if necessary
//         if (n == pq.length - 1) resize(2 * pq.length);

//         // add x, and percolate it up to maintain heap invariant
//         pq[++n] = x;
//         swim(n);
//         assert isMinHeap();
//     }

//     /**
//      * Removes and returns a smallest key on this priority queue.
//      *
//      * @return a smallest key on this priority queue
//      * @throws NoSuchElementException if this priority queue is empty
//      */
//     public Key delMin() {
//         if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
//         Key min = pq[1];
//         exch(1, n--);
//         sink(1);
//         pq[n+1] = null;     // to avoid loiterig and help with garbage collection
//         if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
//         assert isMinHeap();
//         return min;
//     }


//    /***************************************************************************
//     * Helper functions to restore the heap invariant.
//     ***************************************************************************/

//     private void swim(int k) {
//         while (k > 1 && greater(k/2, k)) {
//             exch(k, k/2);
//             k = k/2;
//         }
//     }

//     private void sink(int k) {
//         while (2*k <= n) {
//             int j = 2*k;
//             if (j < n && greater(j, j+1)) j++;
//             if (!greater(k, j)) break;
//             exch(k, j);
//             k = j;
//         }
//     }

//    /***************************************************************************
//     * Helper functions for compares and swaps.
//     ***************************************************************************/
//     private boolean greater(int i, int j) {
//         if (comparator == null) {
//             return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
//         }
//         else {
//             return comparator.compare(pq[i], pq[j]) > 0;
//         }
//     }

//     private void exch(int i, int j) {
//         Key swap = pq[i];
//         pq[i] = pq[j];
//         pq[j] = swap;
//     }

//     // is pq[1..N] a min heap?
//     private boolean isMinHeap() {
//         return isMinHeap(1);
//     }

//     // is subtree of pq[1..n] rooted at k a min heap?
//     private boolean isMinHeap(int k) {
//         if (k > n) return true;
//         int left = 2*k;
//         int right = 2*k + 1;
//         if (left  <= n && greater(k, left))  return false;
//         if (right <= n && greater(k, right)) return false;
//         return isMinHeap(left) && isMinHeap(right);
//     }


//     /**
//      * Returns an iterator that iterates over the keys on this priority queue
//      * in ascending order.
//      * <p>
//      * The iterator doesn't implement {@code remove()} since it's optional.
//      *
//      * @return an iterator that iterates over the keys in ascending order
//      */
//     public Iterator<Key> iterator() {
//         return new HeapIterator();
//     }

//     private class HeapIterator implements Iterator<Key> {
//         // create a new pq
//         private MinPQ<Key> copy;

//         // add all items to copy of heap
//         // takes linear time since already in heap order so no keys move
//         public HeapIterator() {
//             if (comparator == null) copy = new MinPQ<Key>(size());
//             else                    copy = new MinPQ<Key>(size(), comparator);
//             for (int i = 1; i <= n; i++)
//                 copy.insert(pq[i]);
//         }

//         public boolean hasNext()  { return !copy.isEmpty();                     }
//         public void remove()      { throw new UnsupportedOperationException();  }

//         public Key next() {
//             if (!hasNext()) throw new NoSuchElementException();
//             return copy.delMin();
//         }
//     }

//     // /**
//     //  * Unit tests the {@code MinPQ} data type.
//     //  *
//     //  * @param args the command-line arguments
//     //  */
//     // public static void main(String[] args) {
//     //     MinPQ<String> pq = new MinPQ<String>();
//     //     while (!StdIn.isEmpty()) {
//     //         String item = StdIn.readString();
//     //         if (!item.equals("-")) pq.insert(item);
//     //         else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
//     //     }
//     //     StdOut.println("(" + pq.size() + " left on pq)");
//     // }

// }



import java.util.Comparator;
/**
 * Class for minimum pq.
 * @param      <Key>  The key
 */
public class MinPQ<Key> {
    /**
     * pq array of type Key.
     */
    private Key[] pq;
    /**
     * size of array pq.
     */
    private int n;
    /**
     * comparator of type Comparator.
     */
    private Comparator<Key> comparator;
    /**
     * Initializes an empty priority queue with the given initial capacity.
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue.
     */
    public MinPQ() {
        this(1);
    }
    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparatorr the order in which to compare the keys
     */
    public MinPQ(final int initCapacity, final Comparator<Key> comparatorr) {
        this.comparator = comparatorr;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue using the given comparator.
     * @param  comparatorr the order in which to compare the keys
     */
    public MinPQ(final Comparator<Key> comparatorr) {
        this(1, comparatorr);
    }
    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     * @param  keys the array of keys
     */
    public MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
    }
    /**
     * Returns true if this priority queue is empty.
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     * time complexity is O(1)
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * Returns the number of keys on this priority queue.
     * @return the number of keys on this priority queue
     * time complexity is O(1)
     */
    public int size() {
        return n;
    }
    /**
     * Returns a smallest key on this priority queue.
     * @return a smallest key on this priority queue.
     * time complexity is O(1)
     */
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return pq[1];
    }
    /**
     * resize method to resize the array.
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * Adds a new key to this priority queue.
     * @param  x the key to add to this priority queue
     * time complexity is O(log(n))
     */
    public void insert(final Key x) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }
    /**
     * Removes and returns a smallest key on this priority queue.
     * @return a smallest key on this priority queue
     * time complexity is O(log(n))
     */
    public Key delMin() {
        if (isEmpty()) {
            return null;
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        final int four = 4;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        return min;
    }
    /**
     * swim method.
     * @param      k    index.
     * time complexity is O(log(n))
     */
    private void swim(final int k) {
        int k1 = k;
        while (k1 > 1 && greater(k1 / 2, k1)) {
            exch(k1, k1 / 2);
            k1 = k1 / 2;
        }
    }
    /**
     * sink method.
     * @param      k    index.
     * time complexity is O(log(n))
     */
    private void sink(final int k) {
        int k1 = k;
        while (2 * k1 <= n) {
            int j = 2 * k1;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k1, j)) {
                break;
            }
            exch(k1, j);
            k1 = j;
        }
    }
    /**
     * greater method.
     * @param      i     index.
     * @param      j     index.
     * @return     true or false.
     * time complexity is O(1)
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * exch method to swap the elements.
     * @param      i     index.
     * @param      j     index.
     * time complexity is O(1)
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * Determines if minimum heap.
     * @return     True if minimum heap, False otherwise.
     * time complexity is O(1)
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     * @param      k     index.
     * @return     True if minimum heap, False otherwise.
     * time complexity is O(1)
     */
    private boolean isMinHeap(final int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }
}