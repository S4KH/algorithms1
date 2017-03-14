package com.algos.vid;

public class QueueofStrings {

    private Node first;
    private Node last;

    private class Node {
        String val;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
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

    public String dequeue() {
        String item = first.val;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

}
