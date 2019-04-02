package com.tuowazi.base.sort.bubble.down;

import com.tuowazi.base.sort.BaseSort;

/**
 * 下沉
 *
 * @author zhangweixiao
 */
public class BubbleDownSort1 extends BaseSort {

    @Override
    protected void sort(int[] arr) {
        int len = arr.length;
        boolean swapped =  false;
        for (int i = len; i >= 0; i--) {
           for (int j = 0; j < i-1; j++) {
               if(arr[j] > arr[j+1]){
                   compareTimes++;
                   swap(arr,j,j+1);
                   swapped = true;
               }
           }
           if(!swapped){
               break;
           }
       }

    }

    protected String getName(){
        return "swapped下沉冒泡排序";
    }

    public static void main(String[] args)  {
        BubbleDownSort1 sort = new BubbleDownSort1();
        sort.sort();
    }
}
