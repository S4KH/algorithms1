package com.algos.vid;

public class Queue<Item> {

    private Node first;
    private Node last;

    private class Node {
        Item val;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.val = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item dequeue() {
        Item item = first.val;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

}
