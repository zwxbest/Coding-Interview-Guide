package com.tuowazi.base.sort.heap.max;

import com.tuowazi.base.heap.MaxHeap;
import com.tuowazi.base.sort.BaseSort;

public class HeapSort2 extends BaseSort {

    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public  void sort(int[] arr) {
        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = n - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    protected String getName(){
        return "用数组构造的堆排序";
    }

    public static void main(String[] args) {
        new HeapSort2().sort();
    }
}
