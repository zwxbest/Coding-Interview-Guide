package com.tuowazi.base.sort.heap.max.index;

import com.tuowazi.base.heap.IndexMaxHeap2;
import com.tuowazi.base.sort.BaseSort;

public class IndexHeapSort2 extends BaseSort {

    public  void sort(int[] arr) {
        int n = arr.length;

        IndexMaxHeap2 indexMaxHeap = new IndexMaxHeap2(n);
        for (int i = 0; i < n; i++)
            indexMaxHeap.insert(i, arr[i]);

        for (int i = n - 1; i >= 0; i--)
            arr[i] = indexMaxHeap.extractMax();
    }

    protected String getName(){
        return "使用reverse索引堆排序";
    }

    public static void main(String[] args) {
        new IndexHeapSort2().sort();
    }
}
