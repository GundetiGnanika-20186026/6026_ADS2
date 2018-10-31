// /*************************************************************************
//  *  Compilation:  javac Bag.java
//  *  Execution:    java Bag < input.txt
//  *
//  *  A generic bag or multiset, implemented using a linked list.
//  *
//  *************************************************************************/

// import java.util.Iterator;
// import java.util.NoSuchElementException;

// /**
//  *  The <tt>Bag</tt> class represents a bag (or multiset) of
//  *  generic items. It supports insertion and iterating over the
//  *  items in arbitrary order.
//  *  <p>
//  *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation
//  *  take constant time. Iteration takes time proportional to the number of items.
//  *  <p>
//  *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
//  *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
//  */
// public class Bag<Item> implements Iterable<Item> {
//     private int N;         // number of elements in bag
//     private Node first;    // beginning of bag

//     // helper linked list class
//     private class Node {
//         private Item item;
//         private Node next;
//     }

//    /**
//      * Create an empty stack.
//      */
//     public Bag() {
//         first = null;
//         N = 0;
//     }

//    /**
//      * Is the BAG empty?
//      */
//     public boolean isEmpty() {
//         return first == null;
//     }

//    /**
//      * Return the number of items in the bag.
//      */
//     public int size() {
//         return N;
//     }

//    /**
//      * Add the item to the bag.
//      */
//     public void add(Item item) {
//         Node oldfirst = first;
//         first = new Node();
//         first.item = item;
//         first.next = oldfirst;
//         N++;
//     }


//    /**
//      * Return an iterator that iterates over the items in the bag.
//      */
//     public Iterator<Item> iterator()  {
//         return new ListIterator();
//     }

//     // an iterator, doesn't implement remove() since it's optional
//     private class ListIterator implements Iterator<Item> {
//         private Node current = first;

//         public boolean hasNext()  { return current != null;                     }
//         public void remove()      { throw new UnsupportedOperationException();  }

//         public Item next() {
//             if (!hasNext()) throw new NoSuchElementException();
//             Item item = current.item;
//             current = current.next;
//             return item;
//         }
//     }

// }


import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * number of elements in bag .
     */
    private int n;
    /**
     * pointer at beginning of bag .
     */
    private Node first;
    /**
     * Class for node.
     *
     */
    private class Node {
        /**
         *  variable for item .
         */
        private Item item;
        /**
         *  variable for next node .
         */
        private Node next;
    }
    /**
     * Constructs the object.
     *
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Determines if empty.
     * its complexity is O(1).
     *
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     *  number of items in the bag .
     *  its complexity is O(1).
     *
     * @return     { size}
     */
    public int size() {
        return n;
    }

    /**
     * Add the item to the bag .
     * its complexity is O(1).
     *
     * @param      item  The item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * { Return an iterator that iterates over the items in the bag }.
     * its complexity is O(N).
     *
     * @return     { item }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * { current node }.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * { function for removeing }.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * { function for next }.
         *
         * @return     { item }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}