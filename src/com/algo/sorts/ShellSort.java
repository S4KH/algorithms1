package com.algo.sorts;

import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {

    // WC: O(n*3/2) 3x+1 increments
    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
    
    public static void shuffle(Object[]a){
        for(int i=0;i<a.length;i++){
            int r = StdRandom.uniform(i+1);
            exch((Comparable[]) a, i, r);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        sort(new Integer[] { 14, 18, 19, 30, 23, 40, 29, 37, 11 });
    }
}
