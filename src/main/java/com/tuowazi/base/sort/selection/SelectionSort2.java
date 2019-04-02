package com.tuowazi.base.sort.selection;
import com.tuowazi.base.sort.BaseSort;

public class SelectionSort2 extends BaseSort {
    @Override
    public void sort(int[] arr) {
        int left = 0,right =  arr.length -1;
        while (left < right){
            int minIndex =  left;
            int maxIndex =  right;
            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            compareTimes++;
            if (arr[minIndex] > arr[maxIndex] ){
                swap(arr, minIndex, maxIndex);
            }
            for (int i = left + 1; i < right; i++) {
                compareTimes++;
                if (arr[i] <  arr[minIndex]) {
                    minIndex = i;
                }
                else if (arr[i] >  arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);
            left++;
            right--;
        }
    }
    protected String getName(){
        return "选择最大最小排序";
    }

    public static void main(String[] args) {
        new SelectionSort2().sort();
    }
}