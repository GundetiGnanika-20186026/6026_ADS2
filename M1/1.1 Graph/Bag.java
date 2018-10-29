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
     *
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * { Return the number of items in the bag }.
     *
     * @return     { size}
     */
    public int size() {
        return n;
    }

    /**
     * { Add the item to the bag }.
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
         * { variable for current node }.
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


