package com.tuowazi.base.sort.heap.min;

import com.tuowazi.base.heap.MinHeap;
import com.tuowazi.base.sort.BaseSort;

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort extends BaseSort {

    public void sort(int[] arr) {
        int n = arr.length;
        MinHeap minHeap = new MinHeap(n);
        for (int i = 0; i < n; i++){
            minHeap.insert(arr[i]);
        }
        for (int i = 0; i < n; i++){
            arr[i] = minHeap.extractMin();
        }
    }
    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void shiftDown2(int[] arr, int n, int k) {

        int e = arr[k];
        //左孩子节点是2*k+1
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            //找到两个孩子节点中最大的那个
            if (j + 1 < n && arr[j + 1] > arr[j]){
                j += 1;
            }
            //如果比最大的孩子都大就shiftDown喽
            //比孩子最大的还大就停止。
            if (e >= arr[j]){
                break;
            }
            //比孩子节点还小
            //不需要一直交换
            arr[k] = arr[j];
            k = j;
        }
        //找到一个孩子节点比他小了
        arr[k] = e;
    }

    protected String getName(){
        return "最小堆排序";
    }

    public static void main(String[] args) {
        new HeapSort().sort();
    }
}
