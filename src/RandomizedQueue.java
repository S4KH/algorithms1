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

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (n == a.length)
            resize(2 * a.length);
        a[++n] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        int idx = StdRandom.uniform(n);
        Item rItem = a[idx];
        a[idx] = null;
        resize(--n);
        return rItem;
    }

    // return (but do not remove) a random item
    public Item sample() {
        return a[StdRandom.uniform(n)];
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        a = java.util.Arrays.copyOf(a, capacity);
    }

    public static void main(String[] args) {

    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
