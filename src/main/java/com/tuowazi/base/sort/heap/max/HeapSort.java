package com.tuowazi.base.sort.heap.max;

import com.tuowazi.base.heap.MaxHeap;
import com.tuowazi.base.sort.BaseSort;

public class HeapSort extends BaseSort {

    @Override
    public  void sort(int[] arr) {
        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++){
            maxHeap.insert(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    protected String getName(){
        return "一个一个插入构造的堆排序";
    }

    public static void main(String[] args) {
        new HeapSort().sort();
    }
}
