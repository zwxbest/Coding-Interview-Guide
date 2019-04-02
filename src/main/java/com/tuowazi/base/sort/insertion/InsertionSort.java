package com.tuowazi.base.sort.insertion;

import com.tuowazi.base.sort.BaseSort;

/**
 * @author zhangweixiao
 */
public class InsertionSort extends BaseSort {

    @Override
    protected void sort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0 && arr[j] < arr[j - 1] ; j--) {
                compareTimes++;
                swap(arr, j, j - 1);
            }
        }
    }

    protected String getName(){
        return "插入排序";
    }

    public static void main(String[] args)  {
        InsertionSort sort = new InsertionSort();
        sort.sort();
    }
}
