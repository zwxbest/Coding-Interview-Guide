package com.tuowazi.base.sort.bubble.up;

import com.tuowazi.base.sort.BaseSort;

/**
 * 上浮
 *
 * @author zhangweixiao
 */
public class BubbleUpSort extends BaseSort {

    @Override
    protected void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i + 1; j--) {
                compareTimes++;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    protected String getName(){
        return "上浮冒泡排序";
    }

    public static void main(String[] args)  {
        BubbleUpSort sort = new BubbleUpSort();
        sort.sort();
    }
}
