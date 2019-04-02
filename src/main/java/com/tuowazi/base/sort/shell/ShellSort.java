package com.tuowazi.base.sort.shell;

import com.tuowazi.base.sort.BaseSort;

public class ShellSort extends BaseSort {
    protected void sort(int[] arr){
        int  n =  arr.length;
        int h = 1;
        while (h < n/3){
            h = 3 * h +1;
        }
        //至此已经大于n/3
        //最外层用来缩小增量
        while (h >= 1) {
            // h-sort the array
            //外一层进行初始增量位置的++移动
            for (int i = h; i < n; i++) {
                //i用来记录增俩初始位置
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                //相隔增量进行插入排序
                int e = arr[i];
                //j用来记录增量的移动
                int j = i;
                compareTimes++;
                //h用来表示增量
                //内层记录增量间的对比，因为增量是间隔数组
                for (; j >= h && e < arr[j - h]; j -= h){
                    arr[j] = arr[j - h];
                    assignTimes++;
                }
                arr[j] = e;
            }
            h /= 3;
        }
    }

    protected String getName(){
        return "希尔排序";
    }

    public static void main(String[] args)  {
        new ShellSort().sort();
    }

}
