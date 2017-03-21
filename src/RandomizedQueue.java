import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n;
    private Item[] a;

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
        a = (Item[]) new Object[2];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        checkItem(item);
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        int ri = StdRandom.uniform(n);
        n--;
        swap(ri, n);
        Item rItem = a[n];
        a[n] = null;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return rItem;
    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        Item tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        tmp = null;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int ri = StdRandom.uniform(n);
        return a[ri];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item> {

        private Item[] items;
        private int size;

        public RandomArrayIterator() {
            items = a;
            StdRandom.shuffle(items);
            size = n;
        }

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[--size];
        }
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        a = java.util.Arrays.copyOf(a, capacity);
    }

}
