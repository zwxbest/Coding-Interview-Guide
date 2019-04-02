package com.tuowazi.base.sort.bubble.up;

import com.tuowazi.base.sort.BaseSort;

/**
 * 上浮冒泡，每一轮如果没有交换发生，提前结束
 *
 * @author zhangweixiao
 */
public class BubbleUpSort1 extends BaseSort {

    @Override
    protected void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            boolean swapped = false;
            for (int j = len - 1; j >= i + 1; j--) {
                compareTimes++;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    protected String getName(){
        return "用swapped提前结束的上浮冒泡排序";
    }

    public static void main(String[] args)  {
        BubbleUpSort1 sort = new BubbleUpSort1();
        sort.sort();
    }
}
