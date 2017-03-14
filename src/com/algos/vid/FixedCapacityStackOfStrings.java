package com.algos.vid;

public class FixedCapacityStackOfStrings {

    private int cap = 0;
    private String[] arr;

    public FixedCapacityStackOfStrings(int cap) {
        this.cap = cap;
        arr = new String[this.cap];
    }

    public String pop() {
        return arr[cap--];
    }

    public boolean isEmpty() {
        return cap == 0;
    }

    public void pust(String item) {
        arr[++cap] = item;
    }

}
