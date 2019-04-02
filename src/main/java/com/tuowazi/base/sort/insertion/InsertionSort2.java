package com.tuowazi.base.sort.insertion;

import com.tuowazi.base.sort.BaseSort;

/**
 * @author zhangweixiao
 */
public class InsertionSort2 extends BaseSort {

    @Override
    protected void sort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            int tmp =  arr[i];
            int j = i;
            //这里不是arr[j-1]=arr[j],因为arr[j]赋值完之后，j就-1了，最后赋值最小的那个
            //用大的赋值小的
            for (; j > 0 &&  arr[j - 1] > tmp ;j-- ) {
                compareTimes++;
                assignTimes++;
                arr[j] = arr[j-1];
            }
            compareTimes++;
            assignTimes++;
            arr[j] =  tmp;
        }
    }

    protected String getName(){
        return "不用swap的插入排序";
    }


    public static void main(String[] args)  {
        InsertionSort2 sort = new InsertionSort2();
        sort.sort();
    }
}
