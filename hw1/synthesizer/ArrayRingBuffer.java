package synthesizer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer overflow");
        }

        rb[this.last] = x;
        fillCount++;

        if (this.last + 1 == this.capacity) {
            this.last = 0;
        } else {
            this.last++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        T item = rb[this.first];
        rb[this.first] = null;
        fillCount--;

        if (this.first + 1 == this.capacity) {
            this.first = 0;
        } else {
            this.first++;
        }
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[this.first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ARIterator();
    }

    private class ARIterator implements Iterator<T> {
        private int ptr;
        private int remain;

        ARIterator() {
            ptr = first;
            remain = fillCount();
        }

        @Override
        public boolean hasNext() {
            return !isFull();
        }

        @Override
        public T next() {
            T returnItem = rb[ptr];
            remain--;

            if (ptr + 1 == capacity) {
                ptr = 0;
            } else {
                ptr++;
            }
            return returnItem;
        }
    }
}
