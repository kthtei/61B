public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    private Node sentinel;
    private int size;

    // Constructor
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // Constructor that creates a copy of other
    public LinkedListDeque(LinkedListDeque other) {
        size = 0;
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        Node ptr = other.sentinel;

        int counter = other.size;
        while (counter > 0) {
            addLast(ptr.next.item);
            ptr = ptr.next;
            counter--;
        }
    }

    /**
     * Add a first item to the Linked List Deque
     * @param item item that a user wants to add at the first place of Linked List Deque
     */
    public void addFirst(T item) {
       Node first = new Node(item);

       if (sentinel.next == null) {
           sentinel.next = first;
           sentinel.prev = first;
           first.next = sentinel;
           first.prev = sentinel;
       } else {
           first.next = sentinel.next;
           sentinel.next = first;
           first.prev = sentinel;
           first.next.prev = first;
       }
       size++;
    }

    /**
     * Add a last item to the Linked List Deque
     * @param item item that a user wants to add at the last place of Linked List Deque
     */
    public void addLast(T item) {
        Node last = new Node(item);
        Node ptr = sentinel;
        ptr.prev = last;
        int counter = size;
        last.next = sentinel;
        while (counter > 0) {
            ptr = ptr.next;
            counter--;
        }
        ptr.next = last;
        last.prev = ptr;
        size++;
    }

    /**
     * Returns true if Linked List Deque is empty, false when it's not empty.
     * @return true if it's empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of Linked List Deque
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int counter = size;
        Node ptr = sentinel;
        while (counter > 0) {
            System.out.println(ptr.next.item);
            ptr = ptr.next;
            counter--;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;

        return sentinel.next.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;

        return sentinel.prev.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
     * @param index the given index of Linked List Deque.
     * @return the item at the given index.
     */
    public T get(int index) {
        int counter = index;
        Node ptr = sentinel;
        while (counter > -1) {
            ptr = ptr.next;
            counter--;
        }
        return ptr.item;
    }
}
