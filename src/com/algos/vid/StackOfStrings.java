package com.algos.vid;

public class StackOfStrings {

    private Node first = null;

    private class Node {
        String value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String pop() {
        String val = first.value;
        first = first.next;
        return val;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
    }

}
