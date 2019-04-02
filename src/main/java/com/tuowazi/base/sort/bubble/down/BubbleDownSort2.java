package com.tuowazi.base.sort.bubble.down;

import com.tuowazi.base.sort.BaseSort;

/**
 * 下沉
 *
 * @author zhangweixiao
 */
public class BubbleDownSort2 extends BaseSort {

    @Override
    protected void sort(int[] arr) {
        int len = arr.length;
        for (int i = len; i >= 0; i--) {
            int newn = 0;
           for (int j = 0; j < i-1; j++) {
               if(arr[j] > arr[j+1]){
                   compareTimes++;
                   swap(arr,j,j+1);
                   newn = j;
               }
           }
           if(newn == 0){
               break;
           }
       }

    }

    protected String getName(){
        return "newn下沉冒泡排序";
    }


    public static void main(String[] args)  {
        BubbleDownSort2 sort = new BubbleDownSort2();
        sort.sort();
    }
}
