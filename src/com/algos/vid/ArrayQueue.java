package com.algos.vid;

import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item> {
    private int head = 0;
    private int tail = 0;
    private Item[] arr;

    public ArrayQueue() {
        arr = (Item[]) new Object[1];
    }

    public Item pop() {
        Item item = arr[head--];
        arr[head] = null;
        if (head > 0 && head == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return head == 0;
    }

    public void push(Item item) {
        if (arr.length == tail + 1) {
            resize(arr.length * 2);
        }
        arr[++tail] = item;
    }

    private void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < cap; i++) {
            temp[i] = arr[i];
            if (i - 1 > 0 && arr[i] == null) {
                tail = i - 1;
            }
        }
        head = 0;
        arr = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i = head;

        @Override
        public boolean hasNext() {
            return i < tail;
        }

        @Override
        public Item next() {
            return arr[++i];
        }
    }
}
