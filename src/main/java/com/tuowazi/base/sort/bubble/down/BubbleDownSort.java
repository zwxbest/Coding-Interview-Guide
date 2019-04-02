package com.tuowazi.base.sort.bubble.down;

import com.tuowazi.base.sort.BaseSort;

/**
 * 下沉
 *
 * @author zhangweixiao
 */
public class BubbleDownSort extends BaseSort {

    @Override
    protected void sort(int[] arr) {
        int len = arr.length;
        for (int i = len; i >= 0; i--) {
           for (int j = 0; j < i-1; j++) {
               compareTimes++;
               if(arr[j] > arr[j+1]){
                   swap(arr,j,j+1);
               }
           }
       }

    }

    protected String getName(){
        return "下沉冒泡排序";
    }
    public static void main(String[] args)  {
        BubbleDownSort sort = new BubbleDownSort();
        sort.sort();
    }
}
