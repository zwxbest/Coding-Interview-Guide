package com.tuowazi.base.sort.quick;

import com.tuowazi.base.sort.AdvanceSort;

public class QuickSort extends AdvanceSort {

    @Override
    protected String getName(){
        return "快速排序";
    }

    //按照枢轴分组
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private  int partition(int[] arr, int left, int right) {
        //left定义为枢轴
        int v = arr[left];
        //partition用来记录小于v和大于v的分界点
        int partition = left; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = left + 1; i <= right; i++) {
            //遍历的点比partition的值小
            compareTimes++;
            if (arr[i] < v) {
                //小于枢轴点的元素放在左侧
                //枢轴的位置是变得，但是值是不变的,最后肯定等于v
                partition++;
                //index小于partition的肯定在比v小
                swap(arr, partition, i);
            }
        }
        //最后parition所在位置的左边都是比v小的
        //将枢轴点放到该在的位置，这样小于枢轴点的就在左侧了
        if (left != partition) {
            swap(arr, left, partition);
        }
        //返回枢轴的位置
        return partition;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private  void sort(int[] arr, int l, int r) {

        //l==r也return
        if (l >= r) {
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
        new QuickSort().sort();
    }
}
