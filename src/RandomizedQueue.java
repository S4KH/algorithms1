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

    private void checkItem(Item item) throws Exception {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) throws Exception {
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
        StdRandom.shuffle(a, 0, n);
        Item rItem = a[n - 1];
        a[n - 1] = null;
        n--;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return rItem;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return a[StdRandom.uniform(n)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            StdRandom.shuffle(a, 0, i);
            return a[--i];
        }
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        a = java.util.Arrays.copyOf(a, capacity);
    }

    public static void main(String[] args) throws Exception {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("A");
        rq.enqueue("B");
        rq.enqueue("C");
        rq.enqueue("D");
        // Iterator<String> it = rq.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.sample());
    }

}
