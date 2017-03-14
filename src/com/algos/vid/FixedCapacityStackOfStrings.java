package com.algos.vid;

public class FixedCapacityStackOfStrings {

    private int idx = 0;
    private String[] arr;

    public FixedCapacityStackOfStrings() {
        arr = new String[1];
    }

    public String pop() {
        String item = arr[idx--];
        arr[idx] = null;
        if (idx > 0 && idx == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public void push(String item) {
        if (arr.length == idx + 1) {
            resize(arr.length * 2);
        }
        arr[++idx] = item;
    }

    private void resize(int cap) {
        String[] temp = new String[cap];
        for (int i = 0; i < cap; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

}
