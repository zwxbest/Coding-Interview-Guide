package com.tuowazi.base.sort.heap.min;

import com.tuowazi.base.heap.IndexMinHeap;
import com.tuowazi.base.sort.BaseSort;

public class IndexHeapSort extends BaseSort {

    public  void sort(int[] arr) {
        int n = arr.length;

        IndexMinHeap indexMaxHeap = new IndexMinHeap(n);
        for (int i = 0; i < n; i++)
            indexMaxHeap.insert(i, arr[i]);

        for (int i = 0; i < n; i++)
            arr[i] = indexMaxHeap.extractMin();
    }

    protected String getName(){
        return "最小索引堆排序";
    }

    public static void main(String[] args) {
        new IndexHeapSort().sort();
    }
}
