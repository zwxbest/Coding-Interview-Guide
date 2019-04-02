package com.tuowazi.base.sort.quick;

import com.tuowazi.base.sort.AdvanceSort;
import com.tuowazi.base.sort.BaseSort;

/**
 * 很多相同元素，普通的快速排序算法会造成分割不均衡的问题
 */
public class QuickSort2 extends AdvanceSort {

    @Override
    protected String getName(){
        return "两路快速排序";
    }

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private  int partition(int[] arr, int left, int right) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        int v = arr[left];

        //小于v的从最左边开始，大于v的从最右边开始，注意不要等于v
        // arr[l+1...i) < v; arr(j...r] > v
        int i = left + 1, j = right;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            //从左往右找，找到第一个>=v的停止
            while (i <= right && arr[i] < v){
                i++;
            }
            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            //从右往左找，找到第一个<=v的停止
            while (j >= left + 1 && arr[j] > v){
                j--;
            }
            if (i > j){
                break;
            }
            //交换两个停止的指针，这里只是分割，分割完成后的两部分并不有序。
            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, left, i);
//        swap(arr, left, j);都可以

        return j;
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private  void sort(int[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    @Override
    public  void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        BaseSort.COUNT = 1_0000;
        new QuickSort2().sort();
    }
}
