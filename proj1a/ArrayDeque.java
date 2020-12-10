public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an emptylist */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length / 2;
        nextLast = items.length / 2 + 1;
    }

    /** Creates a deep copy of other */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        size = 0;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;

        int counter = 0;
        while (counter < items.length) {
            if (other.items[counter] != null) {
                items[counter] = (T) other.items[counter];
                size++;
            }
            counter++;
        }
    }

    /**
     * Add a first item to the Array List Deque
     * @param item item that a user wants to add at the first place of Array List Deque
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst--;
        }
        size++;
    }

    /**
     * Returns true if Array List Deque is empty, false when it's not empty.
     * @return true if it's empty, false otherwise.
     */
    public void addLast(T item) {
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        size++;
    }

    /**
     * Returns true if Array List Deque is empty, false when it's not empty.
     * @return true if it's empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of Array List Deque
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int counter = 0;
        while (counter < items.length) {
            System.out.println(items[counter]);
            counter++;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) return null;

        double usageRatio = (double) size / items.length;
        if (usageRatio < 0.25) {
            System.out.println("resizing");
            System.out.println("size of array before: " + items.length);
            resize();
            System.out.println("size of array after: " + items.length);
            printDeque();
        }

        if (nextFirst == items.length - 1) {
            nextFirst = 0;
            items[nextFirst] = null;
        } else {
            items[nextFirst + 1] = null;
        }
        nextFirst++;
        size--;

        int i = nextFirst + 1 == items.length ? 0 : nextFirst + 1;
        return items[i];
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) return null;

        double usageRatio = (double) size / items.length;
        if (usageRatio < 0.25) {
            System.out.println("resizing");
            System.out.println("size of array before: " + items.length);
            resize();
            System.out.println("size of array after: " + items.length);
            printDeque();
        }

        if (nextLast == 0) {
            nextLast = items.length - 1;
            items[nextLast] = null;
        } else {
            items[nextLast - 1] = null;
            nextLast--;
        }
        size--;

        int i = nextLast - 1 < 0 ? items.length - 1 : nextLast - 1;
        return items[i];
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
     * @param index the given index of Array List Deque.
     * @return the item at the given index.
     */
    public T get(int index) {
        return items[index];
    }

    /**
     * Resizes the array to half when usage ratio is less than 0.25.
     */
    public void resize() {

        T[] newItems = (T[]) new Object[items.length / 2];
        nextFirst /= 2;
        nextLast /= 2;

        int counter = 0;
        while (counter < items.length) {
            if (items[counter] != null) {
                addLast(items[counter]);
            }
            counter++;
        }
        items = newItems;
    }

}
