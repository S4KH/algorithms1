package com.algos.vid;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

    private int idx = 0;
    private Item[] arr;

    public FixedCapacityStack() {
        arr = (Item[]) new Object[1];
    }

    public Item pop() {
        Item item = arr[idx--];
        arr[idx] = null;
        if (idx > 0 && idx == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public void push(Item item) {
        if (arr.length == idx + 1) {
            resize(arr.length * 2);
        }
        arr[++idx] = item;
    }

    private void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < cap; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = idx;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return arr[--i];
        }

    }

}
