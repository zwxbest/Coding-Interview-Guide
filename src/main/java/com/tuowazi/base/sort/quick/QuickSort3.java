package com.tuowazi.base.sort.quick;

import com.tuowazi.base.sort.AdvanceSort;

/**
 * 3路快速排序 分为<v,=v,>v三部分 需要三个指针 为了优化有多个相同元素造成的不平衡问题,相比QuickSort2,这个根本不用管和parititon相同的元素
 */
public class QuickSort3 extends AdvanceSort {

    @Override
    protected String getName() {
        return "三路快速排序";
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private void sort(int[] arr, int left, int right) {

        // 对于小规模数组, 使用插入排序
//        if (r - l <= 15) {
//            insertionSort(arr, l, r);
//            return;
//        }

        if (left >= right) {
            return;
        }
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
//        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        int v = arr[left];

        int leftPartition = left;     // arr[l+1...lt] < v
        int rightPartition = right +1; // arr[gt...r] > v
        int i = left + 1;    // arr[lt+1...i) == v
        while (i < rightPartition) {
            //和小于v部分的下一个元素进行交换（一定是==v）
            //交换过去的肯定是小于v，所以处理一下lt++
            //交换过来的是<=v的，所以i++
            if (arr[i] < v) {
                swap(arr, i, ++leftPartition);
                i++;
                //当前读到的元素是>v的
                //和大于v部分的第二个元素一个元素交换位置
                //交换过来的数是未读取到数，和v大小比较不确定，所以不需要处理i，处理一下gt--
            } else if (arr[i] > v) {
                swap(arr, i, --rightPartition);
            } else { // arr[i] == v
                //处理下一个元素
                i++;
            }
        }

        //将第一个元素v交换到等于v的第一个位置。
        swap(arr, left, leftPartition);
        //arr[l..lt-1] < v
        sort(arr, left, leftPartition - 1);
        //arr[gt..r] > v
        //为什么gt不需要+1?
        //因为gt是大于v的第二个元素，gt--是第一个
        sort(arr, rightPartition, right);

    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        new QuickSort3().sort();
    }
}
