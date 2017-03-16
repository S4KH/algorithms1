import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;

        public Node(Item itm) {
            item = itm;
            next = null;
        }
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkItem(Item item) throws Exception {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    public void addFirst(Item item) throws Exception {
        checkItem(item);
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        if (isEmpty()) {
            last = first;
        }
        size++;
    }

    public void addLast(Item item) throws Exception {
        checkItem(item);
        Node n = new Node(item);
        last.next = n;
        last = n;
        if (isEmpty()) {
            first = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item rItm = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return rItm;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item rItem = last.item;
        last = last.next;
        size--;
        if (isEmpty()) {
            first = null;
        }
        return rItem;
    }

    @Override
    public Iterator<Item> iterator() {
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
            if (hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
    
    public static void main(String[] args) {
        
    }

}
