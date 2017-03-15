package com.algos.vid;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first = null;

    private class Node {
        Item value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item pop() {
        Item val = first.value;
        first = first.next;
        return val;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.value;
            current = current.next;
            return item;
        }

    }

}
