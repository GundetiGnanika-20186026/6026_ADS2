// /******************************************************************************
//  *  Compilation:  javac Bag.java
//  *  Execution:    java Bag < input.txt
//  *  Dependencies: StdIn.java StdOut.java
//  *
//  *  A generic bag or multiset, implemented using a singly linked list.
//  *
//  *  % more tobe.txt
//  *  to be or not to - be - - that - - - is
//  *
//  *  % java Bag < tobe.txt
//  *  size of bag = 14
//  *  is
//  *  -
//  *  -
//  *  -
//  *  that
//  *  -
//  *  -
//  *  be
//  *  -
//  *  to
//  *  not
//  *  or
//  *  be
//  *  to
//  *
//  ******************************************************************************/


// import java.util.Iterator;
// import java.util.NoSuchElementException;

// /**
//  *  The {@code Bag} class represents a bag (or multiset) of
//  *  generic items. It supports insertion and iterating over the
//  *  items in arbitrary order.
//  *  <p>
//  *  This implementation uses a singly linked list with a static nested class Node.
//  *  See {@link LinkedBag} for the version from the
//  *  textbook that uses a non-static nested class.
//  *  See {@link ResizingArrayBag} for a version that uses a resizing array.
//  *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
//  *  take constant time. Iteration takes time proportional to the number of items.
//  *  <p>
//  *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
//  *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
//  *
//  *  @author Robert Sedgewick
//  *  @author Kevin Wayne
//  *
//  *  @param <Item> the generic type of an item in this bag
//  */
// public class Bag<Item> implements Iterable<Item> {
//     private Node<Item> first;    // beginning of bag
//     private int n;               // number of elements in bag

//     // helper linked list class
//     private static class Node<Item> {
//         private Item item;
//         private Node<Item> next;
//     }

//     /**
//      * Initializes an empty bag.
//      */
//     public Bag() {
//         first = null;
//         n = 0;
//     }

//     /**
//      * Returns true if this bag is empty.
//      *
//      * @return {@code true} if this bag is empty;
//      *         {@code false} otherwise
//      */
//     public boolean isEmpty() {
//         return first == null;
//     }

//     /**
//      * Returns the number of items in this bag.
//      *
//      * @return the number of items in this bag
//      */
//     public int size() {
//         return n;
//     }

//     /**
//      * Adds the item to this bag.
//      *
//      * @param  item the item to add to this bag
//      */
//     public void add(Item item) {
//         Node<Item> oldfirst = first;
//         first = new Node<Item>();
//         first.item = item;
//         first.next = oldfirst;
//         n++;
//     }


//     /**
//      * Returns an iterator that iterates over the items in this bag in arbitrary order.
//      *
//      * @return an iterator that iterates over the items in this bag in arbitrary order
//      */
//     public Iterator<Item> iterator()  {
//         return new ListIterator<Item>(first);
//     }

//     // an iterator, doesn't implement remove() since it's optional
//     private class ListIterator<Item> implements Iterator<Item> {
//         private Node<Item> current;

//         public ListIterator(Node<Item> first) {
//             current = first;
//         }

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
         * Time complexity for this method is O(1).
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        // /**
        //  * { function for removeing }.
        //  */
        // public void remove() {
        //     throw new UnsupportedOperationException();
        // }
        /**
         * { function for next }.
         * Time complexity for this method is O(1).
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
