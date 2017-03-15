package com.algos.vid;

public class Stack<Item> {

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

}
