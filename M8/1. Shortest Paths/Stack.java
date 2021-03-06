import java.util.Iterator;
//import java.util.NoSuchElementException;
/**
 * stack class.
 *
 * @param      <Item>  The item
 */
class Stack<Item> implements Iterable<Item> {
    /**
     * //top of stack.
     */
    private Node<Item> first;
    /**
     *  // size of the stack.
     */
    private int n;

    // helper linked list class

    /**
     * Class for node.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * item.
         */
        private Item item;
        /**
         * next node.
         */
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack.
     * its complexity is O(1).
     */
    Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     * its complexity is O(1).
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     * its complexity is O(1).
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(final Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * {Removes and returns the item most
     *  recently added to this stack}.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {

        Item item = first.item; // save item to return
        first = first.next;  // delete first node
        n--;
        return item; // return the saved item
    }




    /**
     * {Returns an iterator to this stack that
     *  iterates through the items in LIFO order}.
     *  its time complexity is O(1).
     *
     * @return an iterator to this stack that
     *  iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional

    /**
     * Class for list iterator.
     *
     *
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * current node.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         *
         * @param      first1  The first
         */
        ListIterator(final Node<Item> first1) {
            current = first1;
        }
        /**
         * Determines if it has next.
         * its complexity is O(1).
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }


        /**
         * checks wether the next element is present.
         * Time complexity for this method is O(1).
         *
         * @return     { returns item }.
         */
        public Item next() {

            Item item = current.item;
            current = current.next;
            return item;
        }
    }


}





