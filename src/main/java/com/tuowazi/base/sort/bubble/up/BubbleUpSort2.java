package com.tuowazi.base.sort.bubble.up;

import com.tuowazi.base.sort.BaseSort;

/**
 * 上浮冒泡，用最后一个比较的
 *
 * @author zhangweixiao
 */
public class BubbleUpSort2 extends BaseSort {

    @Override
    protected void sort(int[] arr) {
        int len = arr.length;
        int newn; // 使用newn进行优化
        for (int i = 0; i < len; i++) {
            newn = len -1 ;
            for (int j = len - 1; j >= i + 1; j--) {
                compareTimes++;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    newn = j;
                }
            }
            if (newn == len - 1) {
                break;
            }
        }
    }

    protected String getName(){
        return "用newn提前结束的上浮冒泡排序";
    }

    public static void main(String[] args)  {
        BubbleUpSort2 sort = new BubbleUpSort2();
        sort.sort();
    }
}
