package com.tuowazi.base.sort.selection;
import com.tuowazi.base.sort.BaseSort;

public class SelectionSort extends BaseSort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                compareTimes++;
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                    assignTimes++;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    protected String getName(){
        return "选择排序";
    }

    public static void main(String[] args) {
        new SelectionSort().sort();
    }
}