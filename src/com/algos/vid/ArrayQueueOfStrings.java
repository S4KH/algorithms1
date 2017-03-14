package com.algos.vid;

public class ArrayQueueOfStrings {
    private int head = 0;
    private int tail = 0;
    private String[] arr;

    public ArrayQueueOfStrings() {
        arr = new String[1];
    }

    public String pop() {
        String item = arr[head--];
        arr[head] = null;
        if (head > 0 && head == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return head == 0;
    }

    public void push(String item) {
        if (arr.length == tail + 1) {
            resize(arr.length * 2);
        }
        arr[++tail] = item;
    }

    private void resize(int cap) {
        String[] temp = new String[cap];
        for (int i = 0; i < cap; i++) {
            temp[i] = arr[i];
            if (i - 1 > 0 && arr[i] == null) {
                tail = i - 1;
            }
        }
        head = 0;
        arr = temp;
    }
}
