package com.tuowazi.base.sort.quick;

import com.tuowazi.base.sort.AdvanceSort;
import com.tuowazi.base.sort.BaseSort;

//面对近乎有序的数组优化下的快速排序
//退化为O（n^2）的排序，高度为n，每层n的复杂度
public class QuickSort1 extends AdvanceSort {

    @Override
    protected String getName(){
        return "优化近乎有序的快速排序";
    }

    //按照枢轴分组
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private  int partition(int[] arr, int left, int right) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        //left定义为枢轴
        int v = arr[left];
        //partition用来记录小于v和大于v的分界点
        int partition = left; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = left + 1; i <= right; i++) {
            //遍历的点比partition的值小
            compareTimes++;
            if (arr[i] < v) {
                //小于枢轴点的元素放在左侧
                //枢轴的位置是变得，但是值是不变的
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
        new QuickSort1().sort();
    }
}
