package com.tuowazi.base.sort;

/**
 * @author zhangweixiao
 */
public class AdvanceSort extends BaseSort {


    // 对arr[l...r]的区间使用InsertionSort排序
    protected   void insertionSort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1] > e; j--){
                arr[j] = arr[j - 1];
                assignTimes++;
            }
            arr[j] = e;
        }
    }

 }
